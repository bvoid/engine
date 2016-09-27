package org.bvoid.engine.geometry.point;

public class Point2D implements Point {

  private final float x;
  private final float y;

  /**
   * A point in 2-dimensional space.
   * 
   * @param x x-coordinate
   * @param y y-coordinate
   */
  public Point2D(final float x, final float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

}
