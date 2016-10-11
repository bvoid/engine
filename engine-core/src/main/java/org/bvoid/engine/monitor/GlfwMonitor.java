package org.bvoid.engine.monitor;

import static org.lwjgl.glfw.GLFW.glfwGetMonitorName;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetVideoModes;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWVidMode.Buffer;

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

  @Override
  public List<Resolution> getResolutions() {
    final List<Resolution> resolutions = new ArrayList<>();

    final Buffer videoModes = glfwGetVideoModes(handle);

    if (videoModes == null) {
      return null;
    }

    while (videoModes.hasRemaining()) {
      final GLFWVidMode videoMode = videoModes.get();
      final int width = videoMode.width();
      final int height = videoMode.height();
      resolutions.add(new Resolution(width, height));
    }

    return resolutions;
  }

}
