package com.nora.skincareApp.models;

public enum Category {
	CLEANSER("Cleanser"),
	EYECARE("Eye Care"),
	LIPCARE("Lip Care"),
	MASK("Mask"),
	MOISTURIZER("Moisturizer"),
	SERUM("Serum"),
	SUNSCREEN("Sunscreen"),
	TREATMENT("Treatment");

	private String enumCategory;
	
	private Category(String category) {
		this.enumCategory = category;
	}
	
	public String getCategory() {
		return enumCategory;
	}
}
