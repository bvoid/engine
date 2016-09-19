package org.bvoid.engine.gfx.lwjgl.glfw;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWVidMode;

public class LwjglWindow {

  public static final String DEFAULT_TITLE = "ENGINE";
  public static final int DEFAULT_WIDTH = 640;
  public static final int DEFAULT_HEIGHT = 480;

  public long create() {
    return create(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TITLE);
  }

  public long create(final int width, final int height, final String title) {
    // init
    glfwDefaultWindowHints();
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // TODO properties?
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

    // create
    final long handle = glfwCreateWindow(width, height, title, NULL, NULL);
    if (handle == NULL) {
      throw new RuntimeException("Failed to create the GLFW window");
    }

    // init
    final long primaryMonitor = glfwGetPrimaryMonitor();
    final GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
    final int windowX = (vidMode.width() - width) / 2;
    final int windowY = (vidMode.height() - height) / 2;
    glfwSetWindowPos(handle, windowX, windowY);

    // show
    glfwMakeContextCurrent(handle);
    glfwShowWindow(handle);
    return handle;
  }

  public void show() {
    // glfwShowWindow(handle);
  }

}
