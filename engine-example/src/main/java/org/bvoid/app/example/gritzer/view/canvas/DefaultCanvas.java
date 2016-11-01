package org.bvoid.app.example.gritzer.view.canvas;


import javax.inject.Named;

import org.bvoid.app.example.gritzer.input.Controller;
import org.bvoid.engine.geom.Rectangle2D;
import org.bvoid.engine.scene.Entity;

@Named
public class DefaultCanvas implements Canvas {

  private Rectangle2D bounds;
  private Entity camera;
  private Controller controller;
  private boolean active;

  public DefaultCanvas() {
    super();
  }

  @Override
  public Rectangle2D getBounds() {
    return bounds;
  }

  public void setBounds(Rectangle2D bounds) {
    this.bounds = bounds;
  }

  public void setCamera(Entity camera) {
    this.camera = camera;
  }

  public Entity getCamera() {
    return camera;
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  public Controller getController() {
    return controller;
  }

  public void setActive(boolean b) {
    active = b;
  }

  @Override
  public boolean isActive() {
    return active;
  }

}
