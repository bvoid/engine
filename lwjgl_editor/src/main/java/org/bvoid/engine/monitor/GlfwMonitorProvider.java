package org.bvoid.engine.monitor;

import static org.lwjgl.glfw.GLFW.glfwGetMonitors;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Named;

import org.lwjgl.PointerBuffer;

@Named
public class GlfwMonitorProvider implements MonitorProvider {

  @Override
  public Monitor getPrimaryMonitor() {
    final long handle = glfwGetPrimaryMonitor();
    return new GlfwMonitor(handle); // TODO
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
      final Monitor monitor = new GlfwMonitor(handle);
      monitors.add(monitor);
    }

    return monitors;
  }

}
