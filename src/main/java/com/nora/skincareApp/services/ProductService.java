package com.nora.skincareApp.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nora.skincareApp.models.Product;
import com.nora.skincareApp.repositories.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository prodRepo;
	
	public List<Product> all() {
		return prodRepo.findAllNative();
	}
	

	public Product createProduct(Product newProduct){
		return prodRepo.save(newProduct);
	}
			

	public Product findProduct(Long id) {
		Optional<Product> potentialProduct = prodRepo.findById(id);
		if (potentialProduct.isEmpty() ) {
			return null;
		}
		return potentialProduct.get();
	}

	public Product updateProduct(Product updatedProduct) {
		return prodRepo.save(updatedProduct);
	}

	public void deleteProd(Long id) {
		Optional<Product> potentialProduct = prodRepo.findById(id);
		if (potentialProduct.isPresent()) {
			prodRepo.deleteById(id);
		}
	}
	
	public List<Product> findByCategory(String category) {
		Optional<List<Product>> potentialCategory = prodRepo.findAllByCategory(category);
		if (potentialCategory.isEmpty()) {
//			return an empty list
			return Collections.emptyList();
		}
		return potentialCategory.get();
	}
	
	public List<Product> findByBrand(String brand) {
		Optional<List<Product>> potentialBrand = prodRepo.findAllByBrand(brand);
		if (potentialBrand.isEmpty()) {
			return Collections.emptyList();
		}
		return potentialBrand.get();
	}


	public List<Product> findByKeyword(String keyword){
		return prodRepo.findByKeyword(keyword);
	}

	public List<Product> findByFilter(String skin, String price, String concern, String rating) {
		return prodRepo.findByFilter(skin, price, concern, rating);
	}

	public List<Product> findPostsById(Long id) {
		Optional<List<Product>> potentialPosts = prodRepo.findPostsById(id);
		if (potentialPosts.isEmpty()) {
			return Collections.emptyList();
		}
		return potentialPosts.get();
	}

}
