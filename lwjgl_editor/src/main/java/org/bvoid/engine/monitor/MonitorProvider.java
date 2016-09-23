package org.bvoid.engine.monitor;

import java.util.Collection;

public interface MonitorProvider {

  Monitor getPrimaryMonitor();

  Collection<Monitor> getMonitors();

}
