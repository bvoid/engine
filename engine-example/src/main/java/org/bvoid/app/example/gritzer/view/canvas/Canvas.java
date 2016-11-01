package org.bvoid.app.example.gritzer.view.canvas;

import org.bvoid.app.example.gritzer.input.Controller;
import org.bvoid.engine.geom.Rectangle2D;


public interface Canvas {

  Rectangle2D getBounds();

  boolean isActive();

  Controller getController();
}
