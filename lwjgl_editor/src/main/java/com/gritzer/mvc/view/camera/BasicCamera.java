package com.gritzer.mvc.view.camera;

import javax.inject.Named;

@Named("Camera")
public class BasicCamera implements Camera {
  private float x, y, w, h, zoom;

  // TODO remove
  @Override
  public boolean isRendered(RenderSize renderSize) {
    switch (renderSize) {
      case PROJECTILE:
        return zoom > 0.05f;
      case SMALL:
        return zoom > 0.01f;
      default:
        return true;
    }
  }

  public BasicCamera() {
    this(0f, 0f, 1920f, 1080f, 1f);
  }

  public BasicCamera(float x, float y, float w, float h, float zoom) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.zoom = zoom;
  }

  public void setBounds(float x, float y, float w, float h, float zoom) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.zoom = zoom;
  }

  private void correctView() {
    // if (x < 0) {
    // x = 0;
    // }
    // if (y < 0) {
    // y = 0;
    // }
  }

  public boolean isInView(ViewPort bounds, float x1, float y1) {
    return bounds.contains(translateXToView(x1), translateYToView(y1));
    // return x1 >= x && x1 <= (x + w) && y1 >= y && y1 <= (y + h);
  }

  @Override
  public boolean isInView(ViewPort bounds, ViewPort rectangle) {
    return bounds.contains(new ViewPort(translateXToView((float) rectangle.x),
        translateYToView((float) rectangle.y), rectangle.w * zoom, rectangle.h * zoom));
  }

  @Override
  public void move(int x, int y) {
    this.x += x / zoom;
    this.y += y / zoom;
    correctView();
  }

  @Override
  public void zoom(int direction, float x, float y) {
    if (direction > 0) {
      increaseZoom(x, y);
    } else {
      decreaseZoom(x, y);
    }
  }

  @Override
  public void centerView(float x1, float y1) {
    this.x = x1 - w / 2f / zoom;
    this.y = y1 - h / 2f / zoom;
    correctView();
  }

  @Override
  public float translateXToModel(float x1) {
    return x1 / zoom + this.x;
  }

  @Override
  public float translateYToModel(float y1) {
    return y1 / zoom + this.y;
  }

  @Override
  public float translateXToView(float x1) {
    return (x1 - this.x) * zoom;
  }

  @Override
  public float translateYToView(float y1) {
    return (y1 - this.y) * zoom;
  }

  private void increaseZoom(float x1, float y1) {
    float lastFocusPointX = translateXToModel(x1);
    float lastFocusPointY = translateYToModel(y1);
    float xDistanceToCenter = (w / 2 - (int) x1);
    float yDistanceToCenter = (h / 2 - (int) y1);
    if (zoom > 0.2) {
      zoom = zoom - 0.1f;
    } else if (zoom > 0.02f) {
      zoom = zoom - 0.01f;
    } else if (zoom > 0.002f) {
      zoom = zoom - 0.001f;
    } else if (zoom > 0.0002f) {
      zoom = zoom - 0.0001f;
    }
    lastFocusPointX = translateXToView(lastFocusPointX);
    lastFocusPointY = translateYToView(lastFocusPointY);
    lastFocusPointX += xDistanceToCenter;
    lastFocusPointY += yDistanceToCenter;
    lastFocusPointX = translateXToModel(lastFocusPointX);
    lastFocusPointY = translateYToModel(lastFocusPointY);
    centerView(lastFocusPointX, lastFocusPointY);
  }

  private void decreaseZoom(float x1, float y1) {
    float lastFocusPointX = translateXToModel(x1);
    float lastFocusPointY = translateYToModel(y1);
    float xDistanceToCenter = (w / 2 - (int) x1);
    float yDistanceToCenter = (h / 2 - (int) y1);
    if (zoom < 0.002f) {
      zoom = zoom + 0.0001f;
    } else if (zoom < 0.02f) {
      zoom = zoom + 0.001f;
    } else if (zoom < 0.2f) {
      zoom = zoom + 0.01f;
    } else if (zoom < 10.0f) {
      zoom = zoom + 0.1f;
    }
    lastFocusPointX = translateXToView(lastFocusPointX);
    lastFocusPointY = translateYToView(lastFocusPointY);
    lastFocusPointX += xDistanceToCenter;
    lastFocusPointY += yDistanceToCenter;
    lastFocusPointX = translateXToModel(lastFocusPointX);
    lastFocusPointY = translateYToModel(lastFocusPointY);
    centerView(lastFocusPointX, lastFocusPointY);
  }

  @Override
  public float getZoom() {
    return zoom;
  }

  @Override
  public void setZoom(float zoom) {
    this.zoom = zoom;
  }

  @Override
  public float getX() {
    return x;
  }

  @Override
  public void setX(float x) {
    this.x = x;
  }

  @Override
  public float getY() {
    return y;
  }

  @Override
  public void setY(float y) {
    this.y = y;
  }

  @Override
  public float getW() {
    return w;
  }

  @Override
  public void setW(float w) {
    this.w = w;
  }

  @Override
  public float getH() {
    return h;
  }

  @Override
  public void setH(float h) {
    this.h = h;
  }

  @Override
  public ViewPort translateToModel(ViewPort rect) {
    return new ViewPort(translateXToModel((float) rect.x), translateYToModel((float) rect.y),
        rect.w / zoom, rect.h / zoom);
  }

}
