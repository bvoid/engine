package org.bvoid.engine.core;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.input.InputService;
import org.bvoid.engine.model.Model;
import org.bvoid.engine.util.Update;
import org.bvoid.engine.view.View;
import org.bvoid.engine.window.GlfwWindowCloser;

@Named
public class Engine {


  @Inject
  private Supplier<List<Initializer>> initializerSupplier;
  // TODO discuss closer approach
  @Inject
  private GlfwWindowCloser windowCloser;
  @Inject
  private List<Model<?>> models;
  // TODO discuss update approach
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
    initializerSupplier.get().forEach(Initializer::init);
  }

  private void loop() {
    final Update update = new Update();
    while (!view.shouldClose()) {
      // (1) Input
      inputService.update();
      models.forEach(m -> m.update(update.get()));
      // (2) GameLogic
      // (3) World <-> Physics (The physics cycle may happen more than once per frame if the fixed
      // time step is less than the actual frame update time.)
      // (4) GUI (OnGUI is called multiple time per frame update.)
      // (5) AI
      // (6) Audio
      // (7) Render
      view.update();
      // (X) Possible Pause
    }
  }

  private void close() {
    windowCloser.close();
  }

}
