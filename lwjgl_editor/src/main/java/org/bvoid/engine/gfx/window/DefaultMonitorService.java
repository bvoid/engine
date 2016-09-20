package org.bvoid.engine.gfx.window;

import static org.lwjgl.glfw.GLFW.glfwGetMonitors;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Named;

import org.lwjgl.PointerBuffer;

@Named
public class DefaultMonitorService implements MonitorService {

  @Override
  public Monitor getPrimaryMonitor() {
    final long handle = glfwGetPrimaryMonitor();
    return new Monitor(handle);
  }

  @Override
  public Collection<Monitor> getMonitors() {
    final Collection<Monitor> monitors = new ArrayList<>();

    final PointerBuffer handles = glfwGetMonitors();
    if (handles == null) {
      return null; // TODO see test
    }

    while (handles.hasRemaining()) {
      final long handle = handles.get();
      final Monitor monitor = new Monitor(handle);
      monitors.add(monitor);
    }

    return monitors;
  }

}
