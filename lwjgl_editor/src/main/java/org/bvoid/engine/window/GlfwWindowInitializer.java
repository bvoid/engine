package org.bvoid.engine.window;

import static org.bvoid.engine.window.WindowConstants.DEFAULT_SIZE;
import static org.bvoid.engine.window.WindowConstants.DEFAULT_TITLE;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.monitor.GlfwMonitorProvider;
import org.bvoid.engine.monitor.Monitor;

@Named
public class GlfwWindowInitializer implements Initializer {

  @Inject
  private WindowHolder windowHolder;

  @Inject
  private GlfwWindowFactory windowService;

  @Inject
  private GlfwMonitorProvider monitorService;

  @Override
  public void init() {
    final Window mainWindow = windowService.createWindow(DEFAULT_SIZE, DEFAULT_TITLE);

    windowHolder.setMainWindow(mainWindow);

    final Monitor primaryMonitor = monitorService.getPrimaryMonitor();
    mainWindow.centralize(primaryMonitor);
  }

}
