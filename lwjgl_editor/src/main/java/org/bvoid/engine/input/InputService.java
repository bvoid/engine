package org.bvoid.engine.input;

import org.bvoid.engine.gfx.window.Window;

public interface InputService {

  void update();

  void bindInputCallbacks(Window window);

}
