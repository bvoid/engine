package com.gritzer.mvc.view.lwjgl;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

import javax.inject.Inject;
import javax.inject.Named;

import org.lwjgl.glfw.GLFWKeyCallback;

import com.gritzer.mvc.view.event.EventController;
import com.gritzer.mvc.view.event.InputConstants;

@Named
public class KeyHandler extends GLFWKeyCallback {

  @Inject
  private EventController eventController;

  @Override
  public void invoke(long window, int key, int scancode, int action, int mods) {
    if (action == GLFW_RELEASE) {
      eventController.keyReleased(toInputConstant(key));
    } else {
      eventController.keyPressed(toInputConstant(key));
    }
  }

  private int toInputConstant(int key) {
    switch (key) {
      case org.lwjgl.glfw.GLFW.GLFW_KEY_A:
        return InputConstants.A;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_B:
        return InputConstants.B;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_C:
        return InputConstants.C;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_D:
        return InputConstants.D;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_E:
        return InputConstants.E;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_F:
        return InputConstants.F;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_G:
        return InputConstants.G;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_H:
        return InputConstants.H;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_I:
        return InputConstants.I;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_J:
        return InputConstants.J;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_K:
        return InputConstants.K;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_L:
        return InputConstants.L;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_M:
        return InputConstants.M;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_N:
        return InputConstants.N;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_O:
        return InputConstants.O;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_P:
        return InputConstants.P;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_Q:
        return InputConstants.Q;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_R:
        return InputConstants.R;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_S:
        return InputConstants.S;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_T:
        return InputConstants.T;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_U:
        return InputConstants.U;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_V:
        return InputConstants.V;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_W:
        return InputConstants.W;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_X:
        return InputConstants.X;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_Y:
        return InputConstants.Y;
      case org.lwjgl.glfw.GLFW.GLFW_KEY_Z:
        return InputConstants.Z;
      default:
        return -1;
    }
  }

}
