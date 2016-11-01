package org.bvoid.engine.geom;

public class Point2D {
  private float x, y;

  public Point2D(float xpos, float ypos) {
    x = xpos;
    y = ypos;
  }

  public Point2D() {
    this(0f, 0f);
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }


}
