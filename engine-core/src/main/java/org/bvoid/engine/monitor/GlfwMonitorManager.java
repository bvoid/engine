package org.bvoid.engine.monitor;

import static org.lwjgl.glfw.GLFW.glfwGetMonitors;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.lwjgl.PointerBuffer;

@Named
public class GlfwMonitorManager implements MonitorManager {

  @Override
  public Monitor getPrimaryMonitor() {
    final long handle = glfwGetPrimaryMonitor();
    return new GlfwMonitor(handle); // TODO
  }

  @Override
  public List<Monitor> getMonitors() {
    final List<Monitor> monitors = new ArrayList<>();

    final PointerBuffer handles = glfwGetMonitors();
    if (handles == null) {
      return null;
    }

    while (handles.hasRemaining()) {
      final long handle = handles.get();
      final Monitor monitor = new GlfwMonitor(handle);
      monitors.add(monitor);
    }

    return monitors;
  }

}
