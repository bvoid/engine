package com.gritzer.mvc.view.lwjgl;

import javax.inject.Inject;
import javax.inject.Named;

import org.lwjgl.glfw.GLFWScrollCallback;

import com.gritzer.mvc.view.event.EventController;

@Named
public class MouseWheelHandler extends GLFWScrollCallback {

  @Inject
  private EventController eventController;

  @Override
  public void invoke(long window, double xoffset, double yoffset) {
    eventController.mouseWheelMoved(yoffset);
  }
}
