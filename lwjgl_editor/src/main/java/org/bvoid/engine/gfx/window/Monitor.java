package org.bvoid.engine.gfx.window;

import static org.lwjgl.glfw.GLFW.glfwGetMonitorName;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;

import org.joml.Vector2i;
import org.lwjgl.glfw.GLFWVidMode;

public class Monitor {

  private final long handle;

  public Monitor(final long handle) {
    this.handle = handle;
  }

  public long getHandle() {
    return handle;
  }

  public String getName() {
    return glfwGetMonitorName(handle);
  }

  public Vector2i getSize() {
    final GLFWVidMode videoMode = glfwGetVideoMode(handle);

    final int width = videoMode.width();
    final int height = videoMode.height();

    return new Vector2i(width, height);
  }

}
