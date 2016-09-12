package com.gritzer.util.math;

public class Rectangle extends Polygon {

  public Rectangle(float length, float height) {
    super();
    setxPoints(new float[] {0f, length, length, 0f});
    setYPoints(new float[] {0f, 0f, height, height});
    setColor(Colors.random());
    // Polygons.ROTATE.accept(this, 27d);
    // setR(120);
    w = (int) length;
    h = (int) height;
  }

}
