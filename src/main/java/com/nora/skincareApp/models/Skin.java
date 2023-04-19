package com.nora.skincareApp.models;

public enum Skin {
	DRY("Dry"),
	OILY("Oily"),
	COMBINATION("Combination"),
	NORMAL("Normal"),
	SENSITIVE("Sensitive");
	
	private String enumSkin;
	
	private Skin(String skin) {
		this.enumSkin = skin;
	}
	
	public String getSkin() {
		return enumSkin;
	}
}
