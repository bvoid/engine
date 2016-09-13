package org.bvoid.engine.core;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.close.Closer;
import org.bvoid.engine.core.init.Initializer;

@Named
public class Engine {

  @Inject
  private Initializer initializer;

  @Inject
  private Closer closer;

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
    initializer.init();
  }

  private void loop() {
    boolean todo = false; // TODO
    while (todo) {
      // (1) Input
      // (2) GameLogic
      // (3) Camera
      // (4) World <-> Physics (The physics cycle may happen more than once per frame if the fixed
      // time step is less than the actual frame update time.)
      // (5) GUI (OnGUI is called multiple time per frame update.)
      // (6) AI
      // (7) Audio
      // (8) Render
      // (X) Possible Pause
    }
  }

  private void close() {
    closer.close();
  }

}
