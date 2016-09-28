package org.bvoid.engine.window;

import org.bvoid.engine.geometry.point.Point2D;
import org.bvoid.engine.geometry.rectangle.Rectangle2D;
import org.bvoid.engine.monitor.Monitor;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public interface Window {

  public Rectangle2D getArea();

  public void show();

  public void hide();

  public void centralize(final Monitor targetMonitor);

  public void setPosition(final Point2D position);

  public Point2D getPosition();

  public void setIcon();

  public void update();

  public boolean shouldClose();

  public void destroy();

  public void bindKeyCallback(final GLFWKeyCallback keyCallback);

  public void bindCursorPosCallback(final GLFWCursorPosCallback cursorPosCallback);

  public void bindMouseButtonCallback(final GLFWMouseButtonCallback mouseButtonCallback);

  public void bindScrollCallback(final GLFWScrollCallback scrollCallback);

}
