package org.bvoid.engine.input;

import org.bvoid.engine.window.Window;

public interface InputService {

  public void update();

  public void bindInputCallbacks(final Window window);

}
