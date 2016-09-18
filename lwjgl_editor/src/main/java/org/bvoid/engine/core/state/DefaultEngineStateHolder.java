package org.bvoid.engine.core.state;

import javax.inject.Named;

@Named
public class DefaultEngineStateHolder implements EngineStateHolder {

  private EngineState state = EngineState.PAUSED;

  @Override
  public EngineState getState() {
    return state;
  }

  public void setState(EngineState state) {
    this.state = state;
  }



}
