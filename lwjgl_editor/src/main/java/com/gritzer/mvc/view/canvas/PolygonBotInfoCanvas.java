package com.gritzer.mvc.view.canvas;

import java.util.Map;
import java.util.function.Function;

import javax.inject.Named;

import com.gritzer.mvc.model.PolygonBot;

@Named
public class PolygonBotInfoCanvas extends BasicCanvas {

  private Map<String, String> info;
  private PolygonBot bot;
  private Function<PolygonBot, Map<String, String>> updateFunction;
  private float mouseX;
  private float mouseY;

  @Override
  protected void doPaint() {
    renderer.drawString(mouseX + " , " + mouseY, 100, 100);
    update();
    if (info == null) {
      return;
    }
    drawBackGround();
    drawInfo();
  }

  // TODO enable renderer.drawPolyonStatic
  private void drawBackGround() {
    // Rectangle r = new Rectangle(w, (info.size() * fontSize) + 50);
    // r.setColor(Colors.BLUE);
    // r.setX(x);
    // r.setY(y);
    // renderer.drawPolyonStatic(r);
  }

  private void drawInfo() {
    for (String key : info.keySet()) {
      write(key);
      xPointer += 50;
      write(info.get(key));
      xPointer -= 50;
      newLine();
    }
  }

  public void update() {
    if (updateFunction == null) {
      return;
    }
    info = updateFunction.apply(bot);
  }

  public void setInfo(PolygonBot bot, Function<PolygonBot, Map<String, String>> updateFunction) {
    this.bot = bot;
    this.updateFunction = updateFunction;
    update();
  }

  public void checkUpdate(PolygonBot selected) {
    if (selected != null && selected == bot) {
      update();
    }
  }

  public void renderMouse(float x, float y) {
    // TODO remove
    this.mouseX = x;
    this.mouseY = y;
  }

}
