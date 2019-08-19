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
public class ShippingBean {
	private String address;
	private String cardType;
	private boolean isShopping;
	private int cardNumber;
	private int repetedCardNumber;

	public ShippingBean() {
		address=null;
		cardType=null;
		isShopping=false;
		cardNumber=0;
		repetedCardNumber=0;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public boolean isShopping() {
		return isShopping;
	}
	public void setShopping(boolean isShopping) {
		this.isShopping = isShopping;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getRepetedCardNumber() {
		return repetedCardNumber;
	}
	public void setRepetedCardNumber(int repetedCardNumber) {
		this.repetedCardNumber = repetedCardNumber;
	}
	
}
