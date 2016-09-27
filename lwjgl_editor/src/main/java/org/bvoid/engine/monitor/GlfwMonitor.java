package org.bvoid.engine.monitor;

import static org.lwjgl.glfw.GLFW.glfwGetMonitorName;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;

import org.bvoid.engine.geometry.point.Point2D;
import org.bvoid.engine.geometry.rectangle.Rectangle2D;
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
  public Rectangle2D getArea() {
    final Point2D position = new Point2D(0, 0);

    final GLFWVidMode videoMode = glfwGetVideoMode(handle);
    final int width = videoMode.width();
    final int height = videoMode.height();

    return new Rectangle2D(position, width, height);
  }

}
