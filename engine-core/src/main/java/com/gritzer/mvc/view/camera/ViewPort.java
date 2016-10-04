package com.gritzer.mvc.view.camera;

public class ViewPort {
  public double x, y, h, w;

  public ViewPort() {

  }

  public ViewPort(double x, double y, double w, double h) {
    this();
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  public ViewPort(ViewPort rect) {
    this(rect.x, rect.y, rect.w, rect.h);
  }

  @Override
  public int hashCode() {
    // TODO implement correctly...
    return (int) (x + y + w + h);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ViewPort) {
      final ViewPort other = (ViewPort) obj;
      return other.x == this.x && other.y == this.y && other.w == this.w && other.h == this.h;
    }
    return false;

  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getH() {
    return h;
  }

  public void setH(double h) {
    this.h = h;
  }

  public double getW() {
    return w;
  }

  public void setW(double w) {
    this.w = w;
  }

  public boolean contains(double d, double e) {
    return d >= x && d <= (x + w) && e >= y && e <= (y + h);
  }

  public boolean contains(ViewPort other) {
    return new java.awt.Rectangle((int) x, (int) y, (int) w, (int) h).intersects(
        new java.awt.Rectangle((int) other.x, (int) other.y, (int) other.w, (int) other.h));
  }

  public void setRect(double x2, double y2, double d, double e) {
    this.x = x2;
    this.y = y2;
    this.w = d;
    this.h = e;

  }

  @Override
  public String toString() {
    return "[" + x + "," + y + "," + w + "," + h + "]";
  }

}
