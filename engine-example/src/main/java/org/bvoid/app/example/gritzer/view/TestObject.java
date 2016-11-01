package org.bvoid.app.example.gritzer.view;

import org.bvoid.engine.geom.Point2D;


public class TestObject {

  private String name;
  private Point2D position;

  public TestObject(String name, int x, int y) {
    this.name = name;
    position = new Point2D(x, y);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Point2D getPosition() {
    return position;
  }

  public void setPosition(Point2D position) {
    this.position = position;
  }



}
