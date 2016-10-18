package org.bvoid.engine.view;

import javax.inject.Named;

import org.bvoid.engine.window.Window;

@Named
public class DefaultView implements View {

  protected Window primaryWindow;

  @Override
  public void update() {
    primaryWindow.update();
  }

  @Override
  public boolean shouldClose() {
    return primaryWindow.shouldClose();
  }

  @Override
  public Window getPrimaryWindow() {
    return primaryWindow;
  }

  @Override
  public void setPrimaryWindow(final Window primaryWindow) {
    this.primaryWindow = primaryWindow;
  }

}
