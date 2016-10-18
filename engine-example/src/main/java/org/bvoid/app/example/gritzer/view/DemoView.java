package org.bvoid.app.example.gritzer.view;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.app.example.gritzer.geom.Point2D;
import org.bvoid.app.example.gritzer.geom.Rectangle2D;
import org.bvoid.app.example.gritzer.view.canvas.DemoCanvas;
import org.bvoid.engine.view.DefaultView;
import org.springframework.context.annotation.Primary;

@Named
@Primary
public class DemoView extends DefaultView {

  @Inject
  private DemoCanvas demoCanvas;

  @Override
  public void update() {
    demoCanvas.setBounds(new Rectangle2D(new Point2D(primaryWindow.getX(), primaryWindow.getY()),
        primaryWindow.getWidth(), primaryWindow.getHeight()));
    super.update();
  }
}
