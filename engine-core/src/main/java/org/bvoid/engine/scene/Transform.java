package org.bvoid.engine.scene;

import java.io.Serializable;

import org.bvoid.engine.geom.Point2D;

public class Transform implements Serializable {

  private static final long serialVersionUID = 0xA000000000000001L;
  private Point2D pos;

  public Transform() {
    this(new Point2D());
  }

  public Transform(Point2D position) {
    this.pos = position;
  }

  public Point2D getPos() {
    return pos;
  }

  public void setPos(Point2D pos) {
    this.pos = pos;
  }

  // TODO [Transform] position
  // TODO [Transform] rotation
  // TODO [Transform] scale

}
