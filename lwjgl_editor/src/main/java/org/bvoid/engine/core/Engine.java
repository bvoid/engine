package org.bvoid.engine.core;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.bvoid.engine.gfx.view.View;
import org.bvoid.engine.input.InputService;
import org.bvoid.engine.window.GlfwWindowCloser;

@Named
public class Engine {

  @Inject
  private List<Initializer> initializers;

  // TODO discuss closer approach
  @Inject
  private GlfwWindowCloser windowCloser;

  // TODO discuss update approach
  @Inject
  private CameraUpdateService cameraUpdateService;
  @Inject
  private InputService inputService;
  @Inject
  private View view;

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
    initializers.forEach(Initializer::init);
  }

  private void loop() {
    while (!view.shouldClose()) {
      // (1) Input
      inputService.update();
      // (2) GameLogic
      // (3) Camera
      cameraUpdateService.update();
      // (4) World <-> Physics (The physics cycle may happen more than once per frame if the fixed
      // time step is less than the actual frame update time.)
      // (5) GUI (OnGUI is called multiple time per frame update.)
      // (6) AI
      // (7) Audio
      // (8) Render
      view.update();
      // (X) Possible Pause
    }
  }

  private void close() {
    windowCloser.close();
  }

}
