package org.bvoid.engine.gfx.view;

import javax.inject.Named;

import org.bvoid.engine.window.Window;
import org.lwjgl.opengl.GL11;


@Named
public class DefaultView implements View {

  private Window primaryWindow;

  @Override
  public void setPrimaryWindow(final Window window) {
    primaryWindow = window;
  }

  @Override
  public void update() {
    // TODO clear separation - view GL specific?
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    primaryWindow.update();
  }

  // TODO workaround / implicit
  @Override
  public boolean shouldClose() {
    return primaryWindow.shouldClose();
  }

}
