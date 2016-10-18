package org.bvoid.engine.view;

import org.bvoid.engine.window.Window;

public interface View {

  public void update();

  public boolean shouldClose();

  public void setPrimaryWindow(final Window initPrimaryWindow);

}
