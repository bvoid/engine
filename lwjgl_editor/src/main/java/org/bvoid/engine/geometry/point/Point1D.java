package org.bvoid.engine.geometry.point;

public class Point1D implements Point {

  private final float x;

  /**
   * A point in a 1-dimensional space.
   * 
   * @param x x-coordinate
   */
  public Point1D(final float x) {
    this.x = x;
  }

  public float getX() {
    return x;
  }

}
