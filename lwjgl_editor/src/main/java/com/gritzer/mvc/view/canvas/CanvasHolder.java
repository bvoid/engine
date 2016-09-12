package com.gritzer.mvc.view.canvas;

import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CanvasHolder implements Supplier<Stream<Canvas>> {

  @Inject
  private EditorSimCanvas editorSimCanvas;
  @Inject
  private PolygonBotInfoCanvas infoCanvas;

  public void init() {
    halfScreenRight(infoCanvas);
    fullScreen(editorSimCanvas);
  }

  @Override
  public Stream<Canvas> get() {
    return Stream.of(editorSimCanvas, infoCanvas);
  }

  private void halfScreenRight(Canvas canvas) {
    canvas.layout(900, 0, 1020, 1050);
  }

  private void fullScreen(Canvas canvas) {
    canvas.layout(0, 0, 1920, 1050);
  }

}
