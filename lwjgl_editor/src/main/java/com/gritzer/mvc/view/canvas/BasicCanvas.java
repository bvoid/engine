package com.gritzer.mvc.view.canvas;

import com.gritzer.mvc.view.camera.ViewPort;
import com.gritzer.mvc.view.render.Renderer;
import com.gritzer.util.math.Polygon;

public abstract class BasicCanvas implements Canvas {

  protected int x;
  protected int y;
  protected int w;
  protected int h;
  protected Renderer renderer;
  protected boolean active = true;
  protected ViewPort bounds;
  protected int xPointer;
  protected int yPointer;
  protected int fontSize;

  @Override
  public void accept(Renderer renderer) {
    this.fontSize = renderer.getFontSize();
    this.xPointer = x + 20;
    this.yPointer = y + 50;
    this.renderer = renderer;
    doPaint();
  }

  protected void newLine() {
    yPointer += fontSize;
  }

  protected void render(Polygon polygon) {
    renderer.renderPolygon(polygon);
  }

  protected BasicCanvas startAt(int xPointer, int yPointer) {
    this.xPointer = xPointer;
    this.yPointer = yPointer;
    return this;
  }

  @Override
  public boolean contains(int x1, int y1) {
    return x1 >= x && x1 <= (x + w) && y1 >= y && y1 <= (y + h);
  }

  protected BasicCanvas write(String string) {
    renderer.drawString(string, xPointer, yPointer);
    return this;
  }

  protected abstract void doPaint();

  @Override
  public void layout(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.bounds = new ViewPort(x, y, w, h);
  }

  @Override
  public void setActive(boolean b) {
    active = b;
  }

  @Override
  public boolean isActive() {
    return active;
  }

  @Override
  public ViewPort getBounds() {
    return bounds;
  }

}
