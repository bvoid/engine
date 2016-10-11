package org.bvoid.engine.monitor;

import java.util.List;

public interface Monitor {

  public String getName();

  public Resolution getResolution();

  public List<Resolution> getResolutions();

}
