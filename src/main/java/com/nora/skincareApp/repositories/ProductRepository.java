package com.nora.skincareApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.nora.skincareApp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product>findAll();

	
	@Query(value="SELECT * FROM products ORDER BY brand ASC", nativeQuery=true)
	List<Product>findAllNative();
	
	
	
	Optional<List<Product>> findAllByCategory(String category);

	Optional<List<Product>> findAllByBrand(String brand);
	
	
	@Query(value="SELECT * FROM products p "
			+ "WHERE p.brand LIKE %:keyword% "
			+ "OR p.category LIKE %:keyword% "
			+ "OR p.concern LIKE %:keyword% "
			+ "OR p.description LIKE %:keyword% "
			+ "OR p.name LIKE %:keyword% "
			+ "OR p.price LIKE %:keyword% "
			+ "OR p.rating LIKE %:keyword% "
			+ "OR p.skin LIKE %:keyword% "
			, nativeQuery=true)
	List<Product> findByKeyword(@Param("keyword") String keyword);
	
	
	
	@Query(value="SELECT * FROM products "
			+ "WHERE (skin=:skin)"
			+ "AND (price < :price)"
			+ "AND (concern =:concern)"
			+ "AND (rating =:rating)"
			+ "ORDER BY brand ASC", nativeQuery=true)
	List<Product> findByFilter(@RequestParam("skin") String skin, @RequestParam("price") String price, @RequestParam("concern") String concern, @RequestParam("rating") String rating);

	
	
	@Query(value="SELECT * FROM products "
			+ "WHERE user_id = :id", nativeQuery=true)
	Optional<List<Product>> findPostsById(Long id);
	
}
