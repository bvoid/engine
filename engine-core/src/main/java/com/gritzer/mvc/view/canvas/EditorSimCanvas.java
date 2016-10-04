package com.gritzer.mvc.view.canvas;

import javax.inject.Inject;
import javax.inject.Named;

import com.gritzer.mvc.model.EditorModel;
import com.gritzer.mvc.model.PolygonBot;
import com.gritzer.mvc.view.camera.Camera;
import com.gritzer.mvc.view.camera.ViewPort;
import com.gritzer.util.math.Polygons;

@Named
public class EditorSimCanvas extends BasicCanvas {

  @Inject
  private EditorModel model;
  @Inject
  private Camera camera;

  @Override
  protected void doPaint() {
    model.getBots().stream().filter(bot -> this.isVisible(bot))
        .forEach(bot -> this.rotateAndRender(bot));
  }

  private void rotateAndRender(PolygonBot bot) {
    final float realX = (bot.getX() + bot.getPolygon().getX() - camera.getX()) * camera.getZoom();
    final float realY = (bot.getY() + bot.getPolygon().getX() - camera.getY()) * camera.getZoom();
    render(Polygons.transform(bot.getPolygon(), realX, realY, bot.getTheta(), camera.getZoom()));
  }

  public boolean isVisible(PolygonBot bot) {
    return camera.isInView(getBounds(),
        new ViewPort(bot.getX(), bot.getY(), bot.getW(), bot.getH()));
  }

}
