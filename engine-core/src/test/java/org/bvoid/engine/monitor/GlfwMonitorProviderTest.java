package org.bvoid.engine.monitor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;

public class GlfwMonitorProviderTest {

  @InjectMocks
  private MonitorProvider classUnderTest = new GlfwMonitorProvider();

  @Test
  public void testGetPrimaryMonitor() throws Exception {
    // TODO how to mock ... without powermock
    assertThat(classUnderTest.getPrimaryMonitor()).isNotNull();
  }

  @Test
  public void testGetMonitors() throws Exception {
    // TODO how to mock ... without powermock
    assertThat(classUnderTest.getMonitors()).isNull();
  }

}
