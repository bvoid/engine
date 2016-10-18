package org.bvoid.app.example.gritzer.input;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.app.example.gritzer.geom.Point2D;

@Named
public class DemoControllerService implements ControllerService {

  @Inject
  private List<Controller> controllers;
  private Controller activeController;
  private Controller defaultController;

  @PostConstruct
  public void init() {
    defaultController = controllers.get(0);
  }

  @Override
  public Controller find(Point2D point) {
    final Controller controller =
        controllers.stream()
            .filter(c -> c.getCanvas() != null && c.getCanvas().getBounds().contains(point))
            .findFirst().orElse(null);

    if (controller != null) {
      activeController = controller;
      return activeController;
    } else {
      return defaultController;
    }

  }

  @Override
  public Controller get() {
    return activeController != null ? activeController : defaultController;
  }
}
