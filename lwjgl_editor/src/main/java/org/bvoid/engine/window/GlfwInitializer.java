package org.bvoid.engine.window;

import static org.lwjgl.glfw.GLFW.glfwInit;

import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class GlfwInitializer implements Initializer {

  @Override
  public void init() {
    GLFWErrorCallback.createPrint(System.err).set(); // TODO move

    if (!glfwInit()) { // TODO move
      throw new IllegalStateException("Unable to initialize GLFW");
    }
  }

}
