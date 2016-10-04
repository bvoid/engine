package org.bvoid.engine.input.callback;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.input.InputController;
import org.lwjgl.glfw.GLFWCursorPosCallback;

@Named
public class CursorPosCallback extends GLFWCursorPosCallback {

  @Inject
  private InputController inputController;

  public long y = 0;
  public long x = 0;

  @Override
  public void invoke(long window, double xpos, double ypos) {
    inputController.mouseMoved(xpos, ypos);
  }

}
