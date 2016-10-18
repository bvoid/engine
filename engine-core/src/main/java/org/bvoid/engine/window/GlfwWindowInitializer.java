package org.bvoid.engine.window;

import static org.bvoid.engine.window.WindowConstants.DEFAULT_SIZE;
import static org.bvoid.engine.window.WindowConstants.DEFAULT_TITLE;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.input.InputService;
import org.bvoid.engine.monitor.GlfwMonitorManager;
import org.bvoid.engine.monitor.Monitor;
import org.bvoid.engine.view.View;

@Named
public class GlfwWindowInitializer implements Initializer {

  @Inject
  private WindowHolder windowHolder;
  @Inject
  private GlfwWindowFactory windowService;
  @Inject
  private GlfwMonitorManager monitorService;
  @Inject
  private InputService inputService;
  @Inject
  private View view;

  @Override
  public void init() {
    final Window mainWindow = windowService.createWindow(DEFAULT_SIZE, DEFAULT_TITLE);
    mainWindow.show();

    windowHolder.setMainWindow(mainWindow);
    view.setPrimaryWindow(mainWindow);

    final Monitor primaryMonitor = monitorService.getPrimaryMonitor();
    mainWindow.centralize(primaryMonitor);

    inputService.bindInputCallbacks(mainWindow);
  }

  @Override
  public int getOrdinal() {
    return 2;
  }

}
