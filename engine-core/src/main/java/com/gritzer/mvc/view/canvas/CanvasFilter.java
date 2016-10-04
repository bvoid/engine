package com.gritzer.mvc.view.canvas;

import java.util.function.Predicate;

import javax.inject.Named;

@Named
public class CanvasFilter implements Predicate<Canvas> {

  @Override
  public boolean test(Canvas canvas) {
    return canvas.isActive();
  }

}
