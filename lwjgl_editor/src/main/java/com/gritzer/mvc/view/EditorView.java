package com.gritzer.mvc.view;

import javax.inject.Inject;
import javax.inject.Named;

import com.gritzer.mvc.view.canvas.CanvasFilter;
import com.gritzer.mvc.view.canvas.CanvasHolder;
import com.gritzer.mvc.view.render.Renderer;

@Named
public class EditorView implements View {

  @Inject
  private CanvasHolder canvasHolder;
  @Inject
  private CanvasFilter canvasFilter;
  @Inject
  private Renderer renderer;

  @Override
  public void init() {
    canvasHolder.init();
  }

  @Override
  public void render() {
    canvasHolder.get().filter(canvasFilter).forEach(c -> c.accept(renderer));
  }

}
