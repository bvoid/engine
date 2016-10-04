package com.gritzer.mvc.view.render;

import com.gritzer.util.math.Polygon;

public interface Renderer {

  Renderer renderPolygon(Polygon p);

  Renderer drawString(String text, float x, float y);

  int getFontSize();

}
