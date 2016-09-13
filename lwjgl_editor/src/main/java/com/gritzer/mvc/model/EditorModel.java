package com.gritzer.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.gritzer.util.math.Polygon;
import com.gritzer.util.math.Polygons;
import com.gritzer.util.math.Rectangle;

@Named
public class EditorModel implements Model {

  private final List<PolygonBot> bots = new ArrayList<>();

  @Override
  public void init() {
    for (int i = 0; i < 20000; i++) {
      final Polygon poly = new Rectangle(2, 2);
      poly.setX(-1);
      poly.setY(-1);
      final PolygonBot bot = new PolygonBot(poly);
      bot.setPosition((float) (Math.random() * 1900), (float) (Math.random() * 1000));
      bot.setTarget(bot.getX(), bot.getY());
      bots.add(bot);
    }

  }

  @Override
  public void update(Double t) {
    bots.stream().forEach(bot -> bot.accept(t));
  }

  public PolygonBot findBot(float x, float y) {
    return bots.stream()
        .filter(b -> Polygons.containsInBounds(b.getPolygon(), x - b.getX(), y - b.getY()))
        .findFirst().orElse(null);
  }

  public List<PolygonBot> getBots() {
    return bots;
  }

}
