package org.bvoid.app.example.gritzer.view.canvas;


import javax.inject.Named;

import org.bvoid.app.example.gritzer.geom.Rectangle2D;
import org.bvoid.engine.scene.Camera;

@Named
public class DemoCanvas implements Canvas {

  private Rectangle2D bounds;
  private Camera camera;

  public DemoCanvas() {
    super();
  }

  @Override
  public Rectangle2D getBounds() {
    return bounds;
  }

  public void setBounds(Rectangle2D bounds) {
    this.bounds = bounds;
  }

  public void setCamera(Camera camera) {
    this.camera = camera;
  }

  public Camera getCamera() {
    return camera;
  }

}
