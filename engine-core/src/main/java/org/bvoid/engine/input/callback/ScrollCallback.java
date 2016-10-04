package org.bvoid.engine.input.callback;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.input.InputController;
import org.lwjgl.glfw.GLFWScrollCallback;

@Named
public class ScrollCallback extends GLFWScrollCallback {

  @Inject
  private InputController inputController;

  @Override
  public void invoke(long window, double xoffset, double yoffset) {
    inputController.mouseWheelMoved(yoffset);
  }
}
