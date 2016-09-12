package com.gritzer.util.physics;

import java.awt.Point;
import java.io.Serializable;

public class Vector implements Serializable {

  private static final long serialVersionUID = 1L;
  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public Vector(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public Vector() {
    this(0, 0, 0, 0);
  }

  public Vector(Point point) {
    this(0, 0, point.x, point.y);
  }

  public Vector(Vector vector) {
    this(vector.x1, vector.y1, vector.x2, vector.y2);
  }

  public double getX1() {
    return x1;
  }

  public void setX1(double x1) {
    this.x1 = x1;
  }

  public double getY1() {
    return y1;
  }

  public void setY1(double y1) {
    this.y1 = y1;
  }

  public double getX2() {
    return x2;
  }

  public void setX2(double x2) {
    this.x2 = x2;
  }

  public double getY2() {
    return y2;
  }

  public void setY2(double y2) {
    this.y2 = y2;
  }

  public Vector add(Vector v1) {
    final Vector v = new Vector(this);
    v.x1 += v1.x1;
    v.y1 += v1.y1;
    v.x2 += v1.x2;
    v.y2 += v1.y2;
    return v;
  }

  public Vector multiply(double f) {
    final Vector v = new Vector(this);
    v.x1 *= f;
    v.y1 *= f;
    v.x2 *= f;
    v.y2 *= f;
    return v;
  }

  // lol
  public double scalar() {
    // return (Math.abs(x2 - x1) + Math.abs(y2 - y1)) / 2;
    double scalar = Math.abs(((x2 - x1) + (y2 - y1)) / 2);
    return scalar;
  }

  public Point point() {
    return new Point((int) x2, (int) y2);
  }

  @Override
  public String toString() {
    int scalar = (int) (((x2 - x1) + (y2 - y1)) / 2);
    char sign = ' ';
    if (scalar < 0) {
      sign = '-';
    }
    scalar = (int) Math.abs(((x2 - x1) + (y2 - y1)) / 2);
    return sign + "|" + scalar + "| " + "[" + x1 + "] [" + y1 + "] [" + x2 + "] [" + y2 + "]";
  }

}
