package org.bvoid.app.example.gritzer.view.canvas;

import java.util.stream.Stream;

import javax.inject.Named;

import org.bvoid.app.example.gritzer.input.Controller;
import org.bvoid.app.example.gritzer.input.ControllerService;
import org.bvoid.app.example.gritzer.input.DemoCanvasController;
import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.geom.Point2D;
import org.bvoid.engine.geom.Rectangle2D;
import org.bvoid.engine.scene.BasicEntity;

@Named
public class CanvasHolder implements Initializer, ControllerService {

  private DefaultCanvas demoCanvas;

  @Override
  public void init() {
    demoCanvas = createCanvas();
    demoCanvas.setActive(true);
    demoCanvas.setController(new DemoCanvasController());
    layout(demoCanvas, 0, 0, 100, 100);
  }

  public Stream<Canvas> getCanvases() {
    return Stream.of(demoCanvas);
  }

  public Stream<Canvas> getActiveCanvases() {
    return getCanvases().filter(Canvas::isActive);
  }

  public void layout(int w, int h) {
    layout(demoCanvas, 0, 0, 100, 100);
  }

  private DefaultCanvas createCanvas() {
    final DefaultCanvas canvas = new DefaultCanvas();
    canvas.setCamera(new BasicEntity());
    canvas.setBounds(new Rectangle2D(new Point2D(0, 0), 0, 0));
    return canvas;
  }

  private void layout(DefaultCanvas canvas, int x, int y, int w, int h) {
    canvas.getBounds().setH(h);
    canvas.getBounds().setW(w);
    canvas.getBounds().getPosition().setX(x);
    canvas.getBounds().getPosition().setY(y);
  }

  @Override
  public int getOrdinal() {
    return 0;
  }

  @Override
  public Controller find(Point2D point) {
    final Canvas canvas =
        getActiveCanvases().filter(c -> c.getBounds().contains(point)).findFirst().orElse(null);
    if (canvas != null) {
      return canvas.getController();
    }
    return null;
  }



}
