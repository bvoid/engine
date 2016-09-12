package com.gritzer.mvc.view.lwjgl;

import javax.inject.Inject;
import javax.inject.Named;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.gritzer.mvc.view.event.EventController;
import com.gritzer.mvc.view.event.InputConstants;

@Named
public class MouseClickHandler extends GLFWMouseButtonCallback {

  @Inject
  private EventController eventController;

  @Override
  public void invoke(long arg0, int button, int clicked, int arg3) {
    if (clicked == 0) {
      eventController.mouseReleased(toInputConstant(button));
    } else {
      eventController.mouseClicked(toInputConstant(button));
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
