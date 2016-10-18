package org.bvoid.app.example.gritzer.geom;


public class Rectangle2D {

  private Point2D position;
  private float w, h;

  public Rectangle2D(final Point2D position, final float width, final float height) {
    this.position = position;
    w = width;
    h = height;
  }


  public boolean contains(Point2D point) {
    return getPosition().getX() <= point.getX() && (getPosition().getX() + getW()) >= point.getX()
        && getPosition().getY() <= point.getY() && (getPosition().getY() + getH()) >= point.getY();
  }

  public Point2D getPosition() {
    return position;
  }

  public void setPosition(Point2D position) {
    this.position = position;
  }

  public float getW() {
    return w;
  }

  public void setW(float w) {
    this.w = w;
  }

  public float getH() {
    return h;
  }

  public void setH(float h) {
    this.h = h;
  }
}
