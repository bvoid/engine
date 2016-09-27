package org.bvoid.engine.core;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.state.EngineState;
import org.bvoid.engine.core.state.EngineStateHolder;
import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.bvoid.engine.gfx.render.OpenglInitializer;
import org.bvoid.engine.window.GlfwInitializer;
import org.bvoid.engine.window.GlfwWindowCloser;
import org.bvoid.engine.window.GlfwWindowInitializer;

@Named
public class Engine {

  // TODO discuss init approach
  @Inject
  private GlfwInitializer glfwInitializer;
  @Inject
  private GlfwWindowInitializer glfwWindowInitializer;
  @Inject
  private OpenglInitializer openglInitializer;

  // TODO discuss closer approach
  @Inject
  private GlfwWindowCloser windowCloser;

  // TODO discuss update approach
  @Inject
  private CameraUpdateService cameraUpdateService;

  @Inject
  private EngineStateHolder engineStateHolder;

  private boolean paused = false;

  /**
   * Run the engine.
   */
  @PostConstruct
  public void run() {
    try {
      init();
      loop();
    } finally {
      close();
    }
  }

  private void init() {
    glfwInitializer.init();
    glfwWindowInitializer.init();
    openglInitializer.init();
  }

  private void loop() {
    while (!paused) {
      // (1) Input
      // (2) GameLogic
      // (3) Camera
      cameraUpdateService.update();
      // (4) World <-> Physics (The physics cycle may happen more than once per frame if the fixed
      // time step is less than the actual frame update time.)
      // (5) GUI (OnGUI is called multiple time per frame update.)
      // (6) AI
      // (7) Audio
      // (8) Render
      // (X) Possible Pause
      paused = (EngineState.PAUSED == engineStateHolder.getState());
    }
  }

  private void close() {
    windowCloser.close();
  }

}
