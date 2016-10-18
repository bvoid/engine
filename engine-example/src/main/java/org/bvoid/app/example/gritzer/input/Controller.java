package org.bvoid.app.example.gritzer.input;


import org.bvoid.app.example.gritzer.geom.Point2D;
import org.bvoid.app.example.gritzer.view.canvas.Canvas;

public interface Controller {

  void mouseDragged(Point2D point);

  Canvas getCanvas();

}
