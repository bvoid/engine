package com.gritzer.util.math;

import java.io.Serializable;

public class Color implements Serializable {

	private static final long serialVersionUID = 1L;
	private int r, g, b;

	public Color() {
	}

	public Color(int r, int g, int b) {
		this();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Color clone() {
		return new Color(r, g, b);
	}

	public Color brighten() {
		r = (r + 255) / 2;
		g = (g + 255) / 2;
		b = (b + 255) / 2;
		return this;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setG(int g) {
		this.g = g;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "" + r + "," + g + "," + b;

	}
}
