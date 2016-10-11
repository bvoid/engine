package org.bvoid.engine.window;

import static org.lwjgl.BufferUtils.createIntBuffer;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwHideWindow;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowIcon;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.nio.IntBuffer;

import org.bvoid.engine.monitor.Monitor;
import org.bvoid.engine.monitor.Resolution;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWImage.Buffer;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class GlfwWindow implements Window {

  private final long handle;

  public GlfwWindow(long handle) {
    this.handle = handle;
  }

  @Override
  public void show() {
    glfwMakeContextCurrent(handle);
    glfwShowWindow(handle);
  }

  @Override
  public void hide() {
    glfwMakeContextCurrent(handle);
    glfwHideWindow(handle);
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
    final IntBuffer widthBuffer = createIntBuffer(1);
    final IntBuffer heightBuffer = createIntBuffer(1);

    glfwGetWindowSize(handle, widthBuffer, heightBuffer);

    return widthBuffer.get(0);
  }

  @Override
  public int getHeight() {
    final IntBuffer widthBuffer = createIntBuffer(1);
    final IntBuffer heightBuffer = createIntBuffer(1);

    glfwGetWindowSize(handle, widthBuffer, heightBuffer);

    return heightBuffer.get(0);
  }

  @Override
  public void setIcon() {
    final Buffer images = null; // TODO
    glfwSetWindowIcon(handle, images);
  }

  @Override
  public void update() {
    glfwSwapBuffers(handle);
    glfwPollEvents();
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

}
