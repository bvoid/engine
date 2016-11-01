package org.bvoid.app.example.gritzer.scene;

import org.bvoid.engine.geom.Rectangle2D;
import org.bvoid.engine.render.Renderer;
import org.bvoid.engine.scene.Shape;

public class PolygonShape extends Shape {

  private Rectangle2D rect;

  public PolygonShape(Rectangle2D bounds) {
    super();
    rect = bounds;
  }

  @Override
  protected void doRender(Renderer renderer) {
    renderer.render(rect);
  }

}
