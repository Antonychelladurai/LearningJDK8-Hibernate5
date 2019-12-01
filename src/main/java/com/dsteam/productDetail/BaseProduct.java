package com.dsteam.productDetail;

import java.util.*;

public class BaseProduct {

	List<String> categories = new ArrayList<String>();

	// (Arrays.asList("Audio system","Car audio","Laptop","Digital
	// camera","GPS","HDD","Mobile","CCTV","Printer","Wireless device","EarPhone"));

	// categories.

	Map<String, String> contrymade = new HashMap<String, String>();

	Map<String, List<String>> brand = new HashMap<String, List<String>>();

	Map<String, Double> price = new HashMap<String, Double>();

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Map<String, String> getContrymade() {
		return contrymade;
	}

	public void setContrymade(Map<String, String> contrymade) {
		this.contrymade = contrymade;
	}

	public Map<String, List<String>> getBrand() {
		return brand;
	}

	public void setBrand(Map<String, List<String>> brand) {
		this.brand = brand;
	}

	public Map<String, Double> getPrice() {
		return price;
	}

	public void setPrice(Map<String, Double> pricemap) {
		this.price = pricemap;
	}

}
