package com.gritzer.util.physics;

public class Energy {

	private double quantity;

	public Energy(double d) {
		this.setQuantity(d);
	}

	@Override
	public String toString() {
		return String.valueOf((int) quantity);
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
