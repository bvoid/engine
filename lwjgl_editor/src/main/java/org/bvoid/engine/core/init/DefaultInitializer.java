package org.bvoid.engine.core.init;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import javax.inject.Named;

import org.bvoid.engine.gfx.lwjgl.glfw.LwjglWindow;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

@Named
public class DefaultInitializer implements Initializer {

  private long windowHandle; // TODO

  @Override
  public void init() {
    GLFWErrorCallback.createPrint(System.err).set(); // TODO move

    if (!glfwInit()) { // TODO move
      throw new IllegalStateException("Unable to initialize GLFW");
    }

    this.windowHandle = new LwjglWindow().create(); // TODO

    // ???? dummy loop
    GL.createCapabilities();
    glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);

    // TODO a test making use of System.gc(); ???

    while (!glfwWindowShouldClose(windowHandle)) {
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
      glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);
      glfwSwapBuffers(windowHandle);
      glfwPollEvents();
    }
  }

}
