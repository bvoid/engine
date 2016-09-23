package org.bvoid.engine.window;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.opengl.GL11.glClearColor;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.monitor.GlfwMonitorProvider;
import org.bvoid.engine.monitor.Monitor;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

@Named
public class WindowInitializer implements Initializer {

  @Inject
  private WindowHolder windowHolder;

  @Inject
  private WindowFactory windowService;

  @Inject
  private GlfwMonitorProvider monitorService;

  @Override
  public void init() {
    GLFWErrorCallback.createPrint(System.err).set(); // TODO move

    if (!glfwInit()) { // TODO move
      throw new IllegalStateException("Unable to initialize GLFW");
    }

    final Window window = windowService.createWindow();
    windowHolder.setMainWindow(window);

    window.show();

    final Monitor primaryMonitor = monitorService.getPrimaryMonitor();
    window.centralize(primaryMonitor);

    // --------------------------------------------------------------------------------
    // ???? dummy loop
    // --------------------------------------------------------------------------------
    GL.createCapabilities();
    glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);

    // TODO a test making use of System.gc(); ???

    // A common pattern is to use the close flag as a main loop condition.
    while (!window.shouldClose()) {
      // glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
      // glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);
      window.update();
    }
  }

}
