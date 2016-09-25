package org.bvoid.engine.core.init;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.opengl.GL11.glClearColor;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.gfx.view.View;
import org.bvoid.engine.gfx.window.Monitor;
import org.bvoid.engine.gfx.window.MonitorService;
import org.bvoid.engine.gfx.window.Window;
import org.bvoid.engine.gfx.window.WindowService;
import org.bvoid.engine.input.InputService;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

@Named
public class DefaultInitializer implements Initializer {

  @Inject
  private WindowService windowService;

  @Inject
  private MonitorService monitorService;
  @Inject
  private InputService inputService;
  @Inject
  private View view;

  @Override
  public void init() {
    GLFWErrorCallback.createPrint(System.err).set(); // TODO move

    if (!glfwInit()) { // TODO move
      throw new IllegalStateException("Unable to initialize GLFW");
    }

    setDefaultWindow();

    // TODO when does this have to be called exactly?
    GL.createCapabilities();

    glClearColor(1f, 0.0f, 0.0f, 0.0f);
    // TODO a test making use of System.gc(); ???

    // A common pattern is to use the close flag as a main loop condition.
    // while (!mainWindow.shouldClose()) {
    // // glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    // // glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);
    // mainWindow.update();
    // }

  }

  protected void setDefaultWindow() {
    view.setPrimaryWindow(initPrimaryWindow());
  }

  protected Window initPrimaryWindow() {
    final Window window = windowService.createWindow();
    window.show();
    final Monitor primaryMonitor = monitorService.getPrimaryMonitor();
    window.centralize(primaryMonitor);
    inputService.bindInputCallbacks(window);
    return window;
  }
}
