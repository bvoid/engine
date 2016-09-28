package org.bvoid.engine.geometry.polygon;

import org.bvoid.engine.geometry.point.Point;

public abstract class Square<P extends Point> extends Rectangle<P> {

  // TODO not sufficient (e.g. rotation ...). maybe via rectangle/polygon
  public Square(final P position, final float length) {
    super(position, length, length);
  }

}
