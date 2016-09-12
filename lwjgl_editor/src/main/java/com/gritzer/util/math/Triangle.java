package com.gritzer.util.math;

public class Triangle extends Polygon {

  public Triangle(float a, float b) {
    super();
    setxPoints(new float[] {0f, a, 0f});
    setYPoints(new float[] {0f, 0f, b});
    setColor(Colors.random());
    w = (int) a;
    h = (int) b;
  }
}
