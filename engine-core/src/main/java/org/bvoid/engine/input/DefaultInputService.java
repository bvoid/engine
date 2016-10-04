package org.bvoid.engine.input;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.window.Window;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

@Named
public class DefaultInputService implements InputService {

  @Inject
  private GLFWKeyCallback keyCallback;
  @Inject
  private GLFWCursorPosCallback cursorPosCallback;
  @Inject
  private GLFWMouseButtonCallback mouseButtonCallback;
  @Inject
  private GLFWScrollCallback scrollCallback;

  @Override
  public void update() {
    glfwPollEvents();
  }

  @Override
  public void bindInputCallbacks(final Window window) {
    window.bindKeyCallback(keyCallback);
    window.bindCursorPosCallback(cursorPosCallback);
    window.bindMouseButtonCallback(mouseButtonCallback);
    window.bindScrollCallback(scrollCallback);
  }

}
