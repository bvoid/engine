package org.bvoid.engine.window;

import static org.lwjgl.BufferUtils.createIntBuffer;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwHideWindow;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowIcon;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.nio.IntBuffer;

import org.bvoid.engine.monitor.Monitor;
import org.bvoid.engine.monitor.Resolution;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWImage.Buffer;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;

public class GlfwWindow implements Window, GLFWWindowSizeCallbackI {

  private final long handle;
  private int width;
  private int height;
  private boolean resized;

  public GlfwWindow(long handle) {
    this.handle = handle;

  }

  @Override
  public void show() {
    glfwMakeContextCurrent(handle);
    glfwSwapInterval(1);
    glfwShowWindow(handle);
    org.lwjgl.glfw.GLFW.glfwSetWindowSizeCallback(handle, this);
    final IntBuffer widthBuffer = createIntBuffer(1);
    final IntBuffer heightBuffer = createIntBuffer(1);

    glfwGetWindowSize(handle, widthBuffer, heightBuffer);
    width = widthBuffer.get(0);
    height = heightBuffer.get(0);
  }

  @Override
  public void hide() {
    glfwMakeContextCurrent(handle);
    glfwHideWindow(handle);
    org.lwjgl.glfw.GLFW.glfwSetWindowSizeCallback(handle, null);
  }

  @Override
  public void centralize(Monitor monitor) {
    final Resolution resolution = monitor.getResolution();

    final int x = (resolution.getWidth() / 2) - (getWidth() / 2);
    final int y = (resolution.getHeight() / 2) - (getHeight() / 2);

    setPosition(x, y);
  }

  @Override
  public void setPosition(int x, int y) {
    glfwSetWindowPos(handle, x, y);
  }

  @Override
  public int getX() {
    final IntBuffer xBuffer = createIntBuffer(1);
    final IntBuffer yBuffer = createIntBuffer(1);

    glfwGetWindowPos(handle, xBuffer, yBuffer);

    return xBuffer.get(0);
  }

  @Override
  public int getY() {
    final IntBuffer xBuffer = createIntBuffer(1);
    final IntBuffer yBuffer = createIntBuffer(1);

    glfwGetWindowPos(handle, xBuffer, yBuffer);

    return yBuffer.get(0);
  }

  @Override
  public int getWidth() {
    // final IntBuffer widthBuffer = createIntBuffer(1);
    // final IntBuffer heightBuffer = createIntBuffer(1);
    //
    // glfwGetWindowSize(handle, widthBuffer, heightBuffer);
    //
    // return widthBuffer.get(0);
    return width;
  }

  @Override
  public int getHeight() {
    // final IntBuffer widthBuffer = createIntBuffer(1);
    // final IntBuffer heightBuffer = createIntBuffer(1);
    //
    // glfwGetWindowSize(handle, widthBuffer, heightBuffer);
    //
    // return heightBuffer.get(0);
    return height;
  }

  @Override
  public void setIcon() {
    final Buffer images = null; // TODO
    glfwSetWindowIcon(handle, images);
  }

  @Override
  public void update() {
    glfwSwapBuffers(handle);
  }

  @Override
  public void destroy() {
    glfwDestroyWindow(handle);
  }

  // TODO workaround / implicit
  @Override
  public boolean shouldClose() {
    return glfwWindowShouldClose(handle);
  }

  @Override
  public void bindKeyCallback(GLFWKeyCallback keyCallback) {
    glfwSetKeyCallback(handle, keyCallback);
  }

  @Override
  public void bindCursorPosCallback(GLFWCursorPosCallback cursorPosCallback) {
    glfwSetCursorPosCallback(handle, cursorPosCallback);
  }

  @Override
  public void bindMouseButtonCallback(GLFWMouseButtonCallback mouseButtonCallback) {
    org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback(handle, mouseButtonCallback);
  }

  @Override
  public void bindScrollCallback(GLFWScrollCallback scrollCallback) {
    org.lwjgl.glfw.GLFW.glfwSetScrollCallback(handle, scrollCallback);
  }


  @Override
  public void invoke(long window, int width, int height) {
    if (handle != window) {
      return;
    }
    resized = true;
    this.width = width;
    this.height = height;
  }

  @Override
  public boolean resized(boolean consume) {
    if (resized) {
      if (consume) {
        resized = false;
      }
      return true;
    }
    return false;
  }
}
