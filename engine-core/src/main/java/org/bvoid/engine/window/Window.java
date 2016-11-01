package org.bvoid.engine.window;

import org.bvoid.engine.monitor.Monitor;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public interface Window {

  void show();

  void hide();

  void centralize(Monitor targetMonitor);

  void setPosition(int x, int y);

  int getX();

  int getY();

  int getWidth();

  int getHeight();

  void setIcon();

  void update();

  boolean shouldClose();

  void destroy();

  void bindKeyCallback(GLFWKeyCallback keyCallback);

  void bindCursorPosCallback(GLFWCursorPosCallback cursorPosCallback);

  void bindMouseButtonCallback(GLFWMouseButtonCallback mouseButtonCallback);

  void bindScrollCallback(GLFWScrollCallback scrollCallback);

  boolean resized(boolean consume);
}
