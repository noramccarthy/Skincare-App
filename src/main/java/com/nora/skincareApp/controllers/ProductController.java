package com.nora.skincareApp.controllers;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nora.skincareApp.models.Category;
import com.nora.skincareApp.models.Concern;
import com.nora.skincareApp.models.Product;
import com.nora.skincareApp.models.Skin;
import com.nora.skincareApp.models.User;
import com.nora.skincareApp.services.PaginationService;
import com.nora.skincareApp.services.ProductService;
import com.nora.skincareApp.services.UserService;


@Controller
public class ProductController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ProductService prodServ;
	
	@Autowired
	private PaginationService pageServ;
	
	@GetMapping("/dashboard/pages/{pageNumber}")
	public String dashboard(Model model, @PathVariable("pageNumber") int pageNumber, HttpSession session, RedirectAttributes redirect) {
		if (session.getAttribute("userID") == null) {
			redirect.addFlashAttribute("error", "Please log in first.");
			return "redirect:/login";
		} else {
			Long id = (Long) session.getAttribute("userID");
			User loggedInUser = userServ.findById(id); 
			model.addAttribute("loggedInUser", loggedInUser);
			
			
			Page<Product> products = pageServ.productsPerPage(pageNumber - 1);
		    int totalPages = products.getTotalPages();
		    model.addAttribute("totalPages", totalPages);
		    model.addAttribute("products", products);
			
			return "dashboard.jsp";
		}
	}
	
	
	@GetMapping("/search")
	public String search(@ModelAttribute("filteredProduct") Product product, Model model, String keyword) {
		
		if (keyword != null) {
			model.addAttribute("product", prodServ.findByKeyword(keyword)) ;
		} else {
			List<Product> products = prodServ.all();
			model.addAttribute("product", products);
		}
		return "searchDashboard.jsp";
	}
	
	
	@GetMapping("/filters")
	public String filteredDashboard(
			@RequestParam(value="skin", required=false) String skin, 
			@RequestParam(value="price", required=false) String price, 
			@RequestParam(value="concern", required=false) String concern,
			@RequestParam(value="rating", required=false) String rating,
			Model model) {
		
		if (skin != null || price != null || concern != null ||  rating != null) {
			List<Product> products = prodServ.findByFilter(skin, price, concern, rating);
			model.addAttribute("product", products);
			
		} else {
			List<Product> products = prodServ.all();
			model.addAttribute("products", products);
		}
		
		return "filteredDashboard.jsp";
	}
	
	@GetMapping("/posts")
	public String userPosts(Model model, HttpSession session, RedirectAttributes redirect) {
		
		if (session.getAttribute("userID") == null) {
			redirect.addFlashAttribute("error", "Please log in first.");
			return "redirect:/login";
		} else {
			Long id = (Long) session.getAttribute("userID");
			User loggedInUser = userServ.findById(id); 
			model.addAttribute("loggedInUser", loggedInUser);
			
			model.addAttribute("products", prodServ.findPostsById(loggedInUser.getId()));
			
			return "userPosts.jsp";
		}
	}
	
	
	@ModelAttribute("categoryList")
	public List<String> getCategoryList()  {
//		turn array into a list
//		return Arrays.asList(Category.values());
		return Arrays.stream(Category.values()).map(category -> category.getCategory()).collect(Collectors.toList());
	}
	
	
	@ModelAttribute("concernList")
	public List<String> getConcernList()  {
//		return Arrays.asList(Concern.values());
		return Arrays.stream(Concern.values()).map(concern -> concern.getConcern()).collect(Collectors.toList());
	}
	
	@ModelAttribute("skinList")
	public List<String> getSkinList()  {
//		return Arrays.asList(Skin.values());
		return Arrays.stream(Skin.values()).map(skin -> skin.getSkin()).collect(Collectors.toList());
	}
	
	@GetMapping("/new")
	public String createProduct(@ModelAttribute("newProduct") Product product, Model model, HttpSession session, RedirectAttributes redirect) {
		if (session.getAttribute("userID") == null) {
			redirect.addFlashAttribute("error", "Please log in first.");
			return "redirect:/login";
		} else {
			Long id = (Long) session.getAttribute("userID");
			User loggedInUser = userServ.findById(id); 
			model.addAttribute("loggedInUser", loggedInUser);
			
			return "newProduct.jsp";
		}
	}
	
	@PostMapping("/new")
	public String processProduct(@Valid @ModelAttribute("newProduct") Product product, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			prodServ.createProduct(product);
			return "redirect:/dashboard/pages/1";
			
		} 
	}
	
	@GetMapping("/view/{id}")
	public String viewProduct(Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes redirect) {
		if (session.getAttribute("userID") == null) {
			redirect.addFlashAttribute("error", "Please log in first.");
			return "redirect:/login";
		} else {
			Product product = prodServ.findProduct(id);
			model.addAttribute("product", product);
			return "view.jsp";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes redirect) {
		if (session.getAttribute("userID") == null) {
			redirect.addFlashAttribute("error", "Please log in first.");
			return "redirect:/login";
		} else {
			Product product = prodServ.findProduct(id);
			model.addAttribute("updatedProduct", product);
			return "edit.jsp";
		}
	}
	
	@PutMapping("/edit/{id}")
	public String processEditedProduct(@Valid @ModelAttribute("updatedProduct") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			prodServ.updateProduct(product);
			return "redirect:/dashboard/pages/1";
		}
	}
	
	@GetMapping("/{id}/delete")
	public String deleteProduct(@PathVariable("id") Long id) {
		prodServ.deleteProd(id);
		return "redirect:/dashboard/pages/1";
	}
	
	@GetMapping("/{category}")
	public String cleanser(Model model, @PathVariable("category") String category, HttpSession session, RedirectAttributes redirect) {
		if (session.getAttribute("userID") == null) {
			redirect.addFlashAttribute("error", "Please log in first.");
			return "redirect:/login";
		} else {
			List<Product> products = prodServ.findByCategory(category);			
			model.addAttribute("products", products);
			return "categoryPage.jsp";
		}
	}
	
	
}
