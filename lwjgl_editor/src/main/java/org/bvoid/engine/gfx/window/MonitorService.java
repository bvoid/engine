package org.bvoid.engine.gfx.window;

import java.util.Collection;

public interface MonitorService {

  Monitor getPrimaryMonitor();

  Collection<Monitor> getMonitors();

}
