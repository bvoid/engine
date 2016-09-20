package org.bvoid.engine.gfx.window;

import static org.bvoid.engine.gfx.window.WindowConstants.DEFAULT_SIZE;
import static org.bvoid.engine.gfx.window.WindowConstants.DEFAULT_TITLE;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.system.MemoryUtil.NULL;

import javax.inject.Named;

import org.joml.Vector2i;

@Named
public class WindowService {

  public Window createWindow() {
    return createWindow(DEFAULT_SIZE, DEFAULT_TITLE);
  }

  public Window createWindow(final Vector2i size, final String title) {
    initWindowHints();

    final long handle = glfwCreateWindow(size.x, size.y, title, NULL, NULL);
    if (handle == NULL) {
      throw new RuntimeException("Failed to create GLFW window");
    }

    return new Window(handle);
  }

  private void initWindowHints() {
    glfwDefaultWindowHints();

    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
  }

}
