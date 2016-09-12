package com.gritzer.util.math;

import java.io.Serializable;

public class Color implements Serializable {

  private static final long serialVersionUID = 1L;

  private int red;
  private int green;
  private int blue;

  public Color() {}

  public Color(int red, int green, int blue) {
    this();
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public Color clone() {
    return new Color(red, green, blue);
  }

  public Color brighten() {
    red = (red + 255) / 2;
    green = (green + 255) / 2;
    blue = (blue + 255) / 2;
    return this;
  }

  public int getR() {
    return red;
  }

  public int getG() {
    return green;
  }

  public int getB() {
    return blue;
  }

  public void setR(int red) {
    this.red = red;
  }

  public void setG(int green) {
    this.green = green;
  }

  public void setB(int blue) {
    this.blue = blue;
  }

  @Override
  public String toString() {
    return "" + red + "," + green + "," + blue;
  }

}
