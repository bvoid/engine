package org.bvoid.engine.input.callback;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.input.InputController;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.gritzer.mvc.view.event.InputConstants;

@Named
public class MouseButtonCallback extends GLFWMouseButtonCallback {

  @Inject
  private InputController inputController;

  @Override
  public void invoke(long arg0, int button, int clicked, int arg3) {
    if (clicked == 0) {
      inputController.mouseReleased(toInputConstant(button));
    } else {
      inputController.mouseClicked(toInputConstant(button));
    }
  }

  private int toInputConstant(int button) {
    switch (button) {
      case 0:
        return InputConstants.MOUSE_BUTTON_1;
      case 1:
        return InputConstants.MOUSE_BUTTON_2;
      case 2:
        return InputConstants.MOUSE_BUTTON_3;
      default:
        return -1;
    }
  }

}
