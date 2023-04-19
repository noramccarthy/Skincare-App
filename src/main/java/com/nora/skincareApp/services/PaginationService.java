package com.nora.skincareApp.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nora.skincareApp.models.Product;
import com.nora.skincareApp.repositories.ProductRepository;

@Service
@Transactional
public class PaginationService {

	@Autowired
	private ProductRepository prodRepo;
	
	
	private static final int PAGE_SIZE = 10;
	public Page<Product> productsPerPage(int pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "brand");

        return prodRepo.findAll(pageRequest);
	}
}
