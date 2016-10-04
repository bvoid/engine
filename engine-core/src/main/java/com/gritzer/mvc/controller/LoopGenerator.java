package com.gritzer.mvc.controller;

import java.util.function.Consumer;

public interface LoopGenerator {

  void startLoop(final Consumer<Double> consumer);

  public void stopLoop();

  void init();

}
