package com.dsteam.productDetail;

import java.util.*;

public class Product extends BaseProduct {
	
	double pro_net_price;
	long prod_id;
	String prod_name;
	String prod_categorie;
	//String prod_made;
	String prod_brand;
	
	
	
	public double getPro_net_price() {
		return pro_net_price;
	}

	public void setPro_net_price(double pro_net_price) {
		this.pro_net_price = pro_net_price;
	}
	public String getProd_categorie() {
		return prod_categorie;
	}

	public void setProd_categorie(String prod_categorie) {
		this.prod_categorie = prod_categorie;
	}

	/*
	 * public String getProd_made() { return prod_made; }
	 * 
	 * public void setProd_made(String prod_made) { this.prod_made = prod_made; }
	 */
	public String getProd_brand() {
		return prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public long getPro_id() {
		return prod_id;
	}

	public void setPro_id(long pro_id) {
		this.prod_id = pro_id;
	}

	@Override
	public void setCategories(List<String> categories) {
		// TODO Auto-generated method stub
		//categories.addAll(categories);
		super.setCategories(categories);
	}

	@Override
	public void setContrymade(Map<String, String> contrymade) {
		// TODO Auto-generated method stub
		super.setContrymade(contrymade);
	}

	@Override
	public void setBrand(Map<String, List<String>> brand) {
		// TODO Auto-generated method stub
		super.setBrand(brand);
	}

	@Override
	public void setPrice(Map<String, Double> pricemap) {
		// TODO Auto-generated method stub
		super.setPrice(pricemap);
	}
	
	public long genProdid() {
		Random random = new Random();
		long id=random.nextInt(Integer.MAX_VALUE);
		return id ;
	}
	
	public double genProCalc(double cat_price,double brand_morgin) {
		
		pro_net_price=pro_calc(cat_price, brand_morgin);
		return(pro_net_price);
		//setPro_net_price(pro_net_price);
	}
	
	private double pro_calc(double cat_price,double brand_morgin) {
		double tax=12.5;
		return (brand_morgin*cat_price);
		
	}

}
