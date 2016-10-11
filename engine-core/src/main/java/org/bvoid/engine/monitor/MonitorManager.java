package org.bvoid.engine.monitor;

import java.util.List;

public interface MonitorManager {

  public Monitor getPrimaryMonitor();

  public List<Monitor> getMonitors();

}
