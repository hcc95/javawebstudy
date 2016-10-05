package com.cdut.session;

public class Customer {
	private String name;
	private String address;
	private String cardType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Customer(String name, String address, String cardType) {
		super();
		this.name = name;
		this.address = address;
		this.cardType = cardType;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
