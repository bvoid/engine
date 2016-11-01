package org.bvoid.app.example.gritzer.input;


import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.geom.Point2D;
import org.bvoid.engine.input.api.InputAdapter;
import org.springframework.context.annotation.Primary;

@Named
@Primary
public class DemoInputHandler extends InputAdapter {

  @Inject
  private ControllerService controllerService;

  private boolean dragging;
  private double x;
  private double y;

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
    x = xpos;
    y = ypos;
    if (dragging) {
      mouseDragged();
    }
  }

  private void mouseDragged() {
    final Point2D mousePosition = new Point2D((float) x, (float) y);
    final Controller controller = controllerService.find(mousePosition);
    if (controller != null) {
      controller.mouseDragged(mousePosition);
    }
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
