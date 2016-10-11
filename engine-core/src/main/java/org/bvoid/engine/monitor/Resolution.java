package org.bvoid.engine.monitor;

public class Resolution {

  private int width;
  private int height;

  public Resolution(int width, int height) {
    this.setWidth(width);
    this.setHeight(height);
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

}
