package org.bvoid.engine.geometry.rectangle;

import org.bvoid.engine.geometry.point.Point2D;

public class Rectangle2D extends Rectangle<Point2D> {

  public Rectangle2D(final Point2D position, final float width, final float height) {
    super(position, width, height);
  }

  public Point2D getCenter() {
    final float x = getPosition().getX() + (getWidth() / 2);
    final float y = getPosition().getY() + (getHeight() / 2);

    return new Point2D(x, y);
  }

}
