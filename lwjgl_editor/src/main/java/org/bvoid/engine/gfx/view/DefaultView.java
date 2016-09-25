package org.bvoid.engine.gfx.view;

import javax.inject.Named;

import org.bvoid.engine.gfx.window.Window;
import org.lwjgl.opengl.GL11;


@Named
public class DefaultView implements View {

  private Window primaryWindow;

  public void setPrimaryWindow(Window window) {
    primaryWindow = window;
  }

  @Override
  public void update() {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    primaryWindow.update();
  }

  @Override
  public boolean shouldClose() {
    return primaryWindow.shouldClose();
  }

}
