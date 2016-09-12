package com.gritzer.mvc.view.lwjgl;

import javax.inject.Inject;
import javax.inject.Named;

import org.lwjgl.glfw.GLFWCursorPosCallback;

import com.gritzer.mvc.view.event.EventController;

@Named
public class MouseHandler extends GLFWCursorPosCallback {

  @Inject
  private EventController eventController;

  public long y = 0;
  public long x = 0;

  @Override
  public void invoke(long window, double xpos, double ypos) {
    eventController.mouseMoved(xpos, ypos);
  }

}
