package org.bvoid.engine.scene;

import java.io.Serializable;

import org.bvoid.engine.render.Renderer;

public abstract class Shape implements Serializable {
  private static final long serialVersionUID = 1L;

  public void render(Renderer renderer) {
    doRender(renderer);
  }

  protected abstract void doRender(Renderer renderer);

}
