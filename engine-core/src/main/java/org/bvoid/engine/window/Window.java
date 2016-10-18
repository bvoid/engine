package org.bvoid.engine.window;

import org.bvoid.engine.monitor.Monitor;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public interface Window {

  public void show();

  public void hide();

  public void centralize(Monitor targetMonitor);

  public void setPosition(int x, int y);

  public int getX();

  public int getY();

  public int getWidth();

  public int getHeight();

  public void setIcon();

  public void update();

  public boolean shouldClose();

  public void destroy();

  public void bindKeyCallback(GLFWKeyCallback keyCallback);

  public void bindCursorPosCallback(GLFWCursorPosCallback cursorPosCallback);

  public void bindMouseButtonCallback(GLFWMouseButtonCallback mouseButtonCallback);

  public void bindScrollCallback(GLFWScrollCallback scrollCallback);

}
