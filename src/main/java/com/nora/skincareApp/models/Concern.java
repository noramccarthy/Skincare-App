package com.nora.skincareApp.models;

public enum Concern {
	ACNE("Acne"),
	ANTIAGING("Anti-Aging"),
	DRYNESS("Dryness"),
	DULLNESS("Dullness"),
	HYPERPIGMENTATION("Hyperpigmentation"),
	PORES("Pores"),
	WRINKLES("Wrinkles");
	
	private String enumConcern;
	
	private Concern(String concern) {
		this.enumConcern = concern;
	}
	
	public String getConcern() {
		return enumConcern;
	}
}
