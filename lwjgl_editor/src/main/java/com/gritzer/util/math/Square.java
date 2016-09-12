package com.gritzer.util.math;

public class Square extends Polygon {

	public Square(float length) {
		super();
		setxPoints(new float[] { 0f, length, length, 0f });
		setYPoints(new float[] { 0f, 0f, length, length });
		setColor(Colors.random());
		w = (int) length;
		h = (int) length;
	}

}
