package com.anto.dao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy_product")
public class DBProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	long prod_id;
	@Column(name = "prod_name")
	String prod_name;
	@Column(name = "prod_categories")
	String prod_categorie;
	@Column(name = "prod_brand")
	String prod_brand;
	@Column(name = "prod_price")
	double pro_net_price;

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_categorie() {
		return prod_categorie;
	}

	public void setProd_categorie(String prod_categorie) {
		this.prod_categorie = prod_categorie;
	}

	public String getProd_brand() {
		return prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}

	public double getPro_net_price() {
		return pro_net_price;
	}

	public void setPro_net_price(double pro_net_price) {
		this.pro_net_price = pro_net_price;
	}

	@Override
	public String toString() {
		return "DBProduct [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_categorie=" + prod_categorie
				+ ", prod_brand=" + prod_brand + ", pro_net_price=" + pro_net_price + "]";
	}

}
