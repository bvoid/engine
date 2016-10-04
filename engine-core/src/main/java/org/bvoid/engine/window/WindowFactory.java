package org.bvoid.engine.window;

import org.joml.Vector2i;

public interface WindowFactory {

  public Window createWindow(final Vector2i size, final String title);

}
