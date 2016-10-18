package org.bvoid.app.example.gritzer.input;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.app.example.gritzer.geom.Point2D;
import org.bvoid.app.example.gritzer.view.canvas.Canvas;
import org.bvoid.app.example.gritzer.view.canvas.DemoCanvas;

@Named
public class DemoCanvasController implements Controller {

  @Inject
  private DemoCanvas demoCanvas;
  private List<Point2D> pointsToDraw = new ArrayList<>();

  @Override
  public void mouseDragged(Point2D mousePosition) {
    System.out.println("dragged");
  }

  @Override
  public Canvas getCanvas() {
    return demoCanvas;
  }

}
