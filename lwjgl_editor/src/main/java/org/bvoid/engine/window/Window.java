package org.bvoid.engine.window;

import org.bvoid.engine.geometry.point.Point2D;
import org.bvoid.engine.geometry.rectangle.Rectangle2D;
import org.bvoid.engine.monitor.Monitor;

public interface Window {

  public Rectangle2D getArea();

  public void show();

  public void hide();

  public void centralize(final Monitor targetMonitor);

  public void setPosition(final Point2D position);

  public Point2D getPosition();

  public void setIcon();

  public void update();

  public void destroy();

}
