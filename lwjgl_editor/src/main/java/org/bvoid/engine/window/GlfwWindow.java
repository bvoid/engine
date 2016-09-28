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

import org.bvoid.engine.geometry.point.Point2D;
import org.bvoid.engine.geometry.rectangle.Rectangle2D;
import org.bvoid.engine.monitor.Monitor;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWImage.Buffer;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class GlfwWindow implements Window {

  private final long handle;

  public GlfwWindow(final long handle) {
    this.handle = handle;
  }

  @Override
  public Rectangle2D getArea() {
    final Point2D position = getPosition();

    final IntBuffer widthBuffer = createIntBuffer(1);
    final IntBuffer heightBuffer = createIntBuffer(1);

    glfwGetWindowSize(handle, widthBuffer, heightBuffer);

    final float width = widthBuffer.get(0);
    final float height = heightBuffer.get(0);

    return new Rectangle2D(position, width, height);
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
  public void centralize(final Monitor targetMonitor) {
    final Rectangle2D screenArea = targetMonitor.getArea();
    final Point2D screenCenter = screenArea.getCenter();

    final float screenCenterX = screenCenter.getX();
    final float screenCenterY = screenCenter.getY();

    final float x = screenCenterX - (getArea().getWidth() / 2);
    final float y = screenCenterY - (getArea().getHeight() / 2);

    setPosition(new Point2D(x, y));
  }

  @Override
  public void setPosition(final Point2D point) {
    final int x = (int) point.getX();
    final int y = (int) point.getY();

    glfwSetWindowPos(handle, x, y);
  }

  @Override
  public Point2D getPosition() {
    final IntBuffer xBuffer = createIntBuffer(1);
    final IntBuffer yBuffer = createIntBuffer(1);

    glfwGetWindowPos(handle, xBuffer, yBuffer);

    final float x = xBuffer.get(0);
    final float y = yBuffer.get(0);

    return new Point2D(x, y);
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
  public void bindKeyCallback(final GLFWKeyCallback keyCallback) {
    glfwSetKeyCallback(handle, keyCallback);
  }

  @Override
  public void bindCursorPosCallback(final GLFWCursorPosCallback cursorPosCallback) {
    glfwSetCursorPosCallback(handle, cursorPosCallback);
  }

  @Override
  public void bindMouseButtonCallback(final GLFWMouseButtonCallback mouseButtonCallback) {
    org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback(handle, mouseButtonCallback);
  }

  @Override
  public void bindScrollCallback(final GLFWScrollCallback scrollCallback) {
    org.lwjgl.glfw.GLFW.glfwSetScrollCallback(handle, scrollCallback);
  }

}
