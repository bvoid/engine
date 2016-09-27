package org.bvoid.engine.geometry.rectangle;

import org.bvoid.engine.geometry.point.Point;

// TODO extend some kind of base interface for geometric objects
public abstract class Rectangle<P extends Point> {

  private final P position;

  // TODO not sufficient (e.g. rotation ...). maybe via rectangle/polygon
  private final float width;
  private final float height;

  /**
   * A rectangle.
   * 
   * @param position position
   * @param width width
   * @param height height
   */
  public Rectangle(final P position, final float width, final float height) {
    this.position = position;
    this.width = width;
    this.height = height;
  }

  public P getPosition() {
    return position;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

}
