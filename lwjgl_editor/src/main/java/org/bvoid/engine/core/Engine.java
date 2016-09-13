package org.bvoid.engine.core;

public class Engine {

  /**
   * Run the engine.
   */
  public void run() {
    try {
      // init();
      // loop();
    } finally {
      close();
    }
  }

  private void init() {
    // TODO
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
    // TODO
  }

}
