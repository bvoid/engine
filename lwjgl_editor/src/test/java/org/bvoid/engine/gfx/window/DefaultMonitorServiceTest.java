package org.bvoid.engine.gfx.window;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;

public class DefaultMonitorServiceTest {

  @InjectMocks
  private MonitorService classUnderTest = new DefaultMonitorService();

  @Test
  public void testGetPrimaryMonitor() throws Exception {
    assertThat(classUnderTest.getPrimaryMonitor()).isNotNull(); // TODO
  }

  @Test
  public void testGetMonitors() throws Exception {
    assertThat(classUnderTest.getMonitors()).isNull(); // TODO
  }

}
