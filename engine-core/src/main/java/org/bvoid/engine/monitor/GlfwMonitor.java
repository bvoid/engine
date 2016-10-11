package org.bvoid.engine.monitor;

import static org.lwjgl.glfw.GLFW.glfwGetMonitorName;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;

import org.lwjgl.glfw.GLFWVidMode;

public class GlfwMonitor implements Monitor {

  private final long handle;

  public GlfwMonitor(final long handle) {
    this.handle = handle;
  }

  @Override
  public String getName() {
    return glfwGetMonitorName(handle);
  }

  @Override
  public Resolution getResolution() {
    final GLFWVidMode videoMode = glfwGetVideoMode(handle);
    final int width = videoMode.width();
    final int height = videoMode.height();
    return new Resolution(width, height);
  }

}
