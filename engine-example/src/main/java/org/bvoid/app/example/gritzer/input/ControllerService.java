package org.bvoid.app.example.gritzer.input;

import org.bvoid.app.example.gritzer.geom.Point2D;


public interface ControllerService {

  Controller find(Point2D point);

  Controller get();

}
