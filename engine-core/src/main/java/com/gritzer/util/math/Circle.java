package com.gritzer.util.math;

import org.joml.Vector2f;

public class Circle {

  private final Vector2f center;
  private final float radius;

  public Circle(final Vector2f center, float radius) {
    this.center = center;
    this.radius = radius;
  }

  public Vector2f getCenter() {
    return center;
  }

  public float getRadius() {
    return radius;
  }

}
