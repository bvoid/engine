package org.bvoid.engine.gfx.window;

import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwHideWindow;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowIcon;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.nio.IntBuffer;

import org.joml.Vector2i;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWImage.Buffer;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class Window {

  private final long handle;

  public Window(final long handle) {
    this.handle = handle;
  }

  public Vector2i getSize() {
    final IntBuffer width = BufferUtils.createIntBuffer(1);
    final IntBuffer height = BufferUtils.createIntBuffer(1);

    glfwGetWindowSize(handle, width, height);

    return new Vector2i(width.get(0), height.get(0));
  }

  public void show() {
    glfwMakeContextCurrent(handle);
    glfwShowWindow(handle);
  }

  public void hide() {
    glfwMakeContextCurrent(handle);
    glfwHideWindow(handle);
  }

  public void centralize(final Monitor targetMonitor) {
    final Vector2i windowSize = getSize();
    final Vector2i screenSize = targetMonitor.getSize();
    final Vector2i deltaSize = screenSize.sub(windowSize);

    setPosition((deltaSize.x / 2), (deltaSize.y / 2));
  }

  public void setPosition(final int x, final int y) {
    glfwSetWindowPos(handle, x, y);
  }

  public void setIcon() {
    final Buffer images = null; // TODO
    glfwSetWindowIcon(handle, images);
  }

  public void update() {
    glfwSwapBuffers(handle);
  }

  public boolean shouldClose() {
    return glfwWindowShouldClose(handle);
  }

  public void destroy() {
    glfwDestroyWindow(handle);
  }

  public void bindKeyCallback(GLFWKeyCallback keyCallback) {
    glfwSetKeyCallback(handle, keyCallback);
  }

  public void bindCursorPosCallback(GLFWCursorPosCallback cursorPosCallback) {
    glfwSetCursorPosCallback(handle, cursorPosCallback);
  }

  public void bindMouseButtonCallback(GLFWMouseButtonCallback mouseButtonCallback) {
    org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback(handle, mouseButtonCallback);
  }

  public void bindScrollCallback(GLFWScrollCallback scrollCallback) {
    org.lwjgl.glfw.GLFW.glfwSetScrollCallback(handle, scrollCallback);
  }



}
