package org.bvoid.engine.util;

import java.util.function.Supplier;

public class Update implements Supplier<Long> {
  private long lastTime;
  private long nowTime;

  public Update() {
    nowTime = java.lang.System.currentTimeMillis();
  }

  @Override
  public Long get() {
    lastTime = nowTime;
    nowTime = java.lang.System.currentTimeMillis();
    return nowTime - lastTime;
  }
}
