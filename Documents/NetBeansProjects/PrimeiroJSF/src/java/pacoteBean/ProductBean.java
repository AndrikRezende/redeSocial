/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteBean;

import javax.faces.bean.ManagedBean;



/**
 *
 * @author Andrik
 */
@ManagedBean
public class ProductBean {
	private int id;
	private String name;
	private int quantity;
	private double price;
	
	public ProductBean() {
		id=0;
		name=null;
		quantity=0;
		price=0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}