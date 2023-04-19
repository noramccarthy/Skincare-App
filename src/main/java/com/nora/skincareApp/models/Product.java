package com.nora.skincareApp.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 2, message = "Choose a product category.")
	private String category;
	
	@NotEmpty
	@Size(min = 3, message = "Brand must be at least 3 characters.")
	private String brand;
	
	@NotEmpty
	@Size(min = 3, message = "Name must be at least 5 characters.")
	private String name;
	
	@NotNull
	@Min(value = 1, message = "Price must be at least $1.")
	private BigDecimal price;
	
	@NotEmpty
	@Size(min = 5, message = "Description be at least 5 characters.")
	private String description;
	
	@NotEmpty
	@Size(min = 2, message = "Choose your skin type.")
	private String skin;
	
	@NotEmpty
	@Size(min = 3, message = "Choose concern(s).")
	private String concern;
	
	@NotNull
	@Min(value = 1, message = "Rating must be at least 1 star.")
	@Max(value = 5, message = "Rating cannot exceed 5 stars.")
	private Integer rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User submittedBy;

	private String [] categoryList;
	private String [] concernList;
	private String [] skinList;
	
	public Product() {};
	
	public Product(String category, String brand, String name, BigDecimal price, String description, String skin, String concern, Integer rating) {
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.description = description;
		this.skin = skin;
		this.concern = concern;
		this.rating = rating;
	}
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(User submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String[] getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String[] categoryList) {
		this.categoryList = categoryList;
	}

	public String[] getConcernList() {
		return concernList;
	}

	public void setConcernList(String[] concernList) {
		this.concernList = concernList;
	}

	public String[] getSkinList() {
		return skinList;
	}

	public void setSkinList(String[] skinList) {
		this.skinList = skinList;
	}

	
	
}
