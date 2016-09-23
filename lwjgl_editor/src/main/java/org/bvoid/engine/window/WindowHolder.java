package org.bvoid.engine.window;

import javax.inject.Named;

@Named
public class WindowHolder {

  private Window mainWindow = null;

  public WindowHolder() {}

  public void setMainWindow(Window mainWindow) {
    this.mainWindow = mainWindow;
  }

  public Window getMainWindow() {
    return mainWindow;
  }

}
