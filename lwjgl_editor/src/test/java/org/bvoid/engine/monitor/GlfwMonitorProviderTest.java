package org.bvoid.engine.monitor;

import static org.assertj.core.api.Assertions.assertThat;

import org.bvoid.engine.monitor.GlfwMonitorProvider;
import org.bvoid.engine.monitor.MonitorProvider;
import org.junit.Test;
import org.mockito.InjectMocks;

public class GlfwMonitorProviderTest {

  @InjectMocks
  private MonitorProvider classUnderTest = new GlfwMonitorProvider();

  @Test
  public void testGetPrimaryMonitor() throws Exception {
    assertThat(classUnderTest.getPrimaryMonitor()).isNotNull(); // TODO
  }

  @Test
  public void testGetMonitors() throws Exception {
    assertThat(classUnderTest.getMonitors()).isNull(); // TODO
  }

}
