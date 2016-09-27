package org.bvoid.engine.core.state;

public interface EngineStateHolder {

  EngineState getState();

  void setState(EngineState engineState);

}
