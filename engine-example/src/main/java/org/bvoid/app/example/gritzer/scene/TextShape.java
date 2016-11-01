package org.bvoid.app.example.gritzer.scene;

import org.bvoid.engine.render.Renderer;
import org.bvoid.engine.scene.Shape;

public class TextShape extends Shape {

  private static final long serialVersionUID = 1L;
  private String string;

  public TextShape(String string) {
    this.string = string;
  }

  @Override
  protected void doRender(Renderer renderer) {
    renderer.render(string);
  }

}
