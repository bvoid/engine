package org.bvoid.engine.window;

import static org.lwjgl.glfw.GLFW.glfwInit;

import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.lwjgl.glfw.GLFWErrorCallback;

@Named
public class GlfwInitializer implements Initializer {

  @Override
  public void init() {
    GLFWErrorCallback.createPrint(System.err).set(); // TODO move

    if (!glfwInit()) { // TODO move
      throw new IllegalStateException("Unable to initialize GLFW");
    }
  }

}
