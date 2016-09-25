package org.bvoid.engine.gfx.view;

import org.bvoid.engine.gfx.window.Window;

public interface View {

  void update();

  boolean shouldClose();

  void setPrimaryWindow(Window initPrimaryWindow);
}
