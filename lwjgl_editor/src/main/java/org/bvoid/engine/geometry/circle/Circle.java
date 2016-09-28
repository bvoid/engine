package org.bvoid.engine.geometry.circle;

import org.bvoid.engine.geometry.point.Point;

public abstract class Circle<P extends Point> {

  private final P position;
  private final double radius;

  public Circle(final P position, final double radius) {
    this.position = position;
    this.radius = radius;
  }

  public P getCenter() {
    return position;
  }

  public double getRadius() {
    return radius;
  }

}
