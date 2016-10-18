package org.bvoid.app.example.gritzer.input;


import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.app.example.gritzer.geom.Point2D;
import org.bvoid.engine.input.api.InputAdapter;
import org.springframework.context.annotation.Primary;

@Named
@Primary
public class DemoInputHandler extends InputAdapter {

  @Inject
  private ControllerService controllerService;

  private boolean dragging;

  @Override
  public void mouseClicked(int inputConstant) {
    dragging = true;
  }

  @Override
  public void mouseReleased(int inputConstant) {
    dragging = false;
  }

  @Override
  public void mouseMoved(double xpos, double ypos) {
    if (dragging) {
      mouseDragged(xpos, ypos);
    }
  }

  private void mouseDragged(double xpos, double ypos) {
    final Point2D mousePosition = new Point2D((float) xpos, (float) ypos);
    final Controller controller = controllerService.find(mousePosition);
    if (controller != null) {
      controller.mouseDragged(mousePosition);
    }
  }
}
