package org.bvoid.engine.monitor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GlfwMonitorTest {

  private static final long SAMPLE_HANDLE = 0xDEAD;

  private final GlfwMonitor classUnderTest = new GlfwMonitor(SAMPLE_HANDLE);

  @Test
  public void testGetName() throws Exception {
    assertThat(classUnderTest.getName()).isNull(); // TODO
  }

  // TODO @Test
    public void testGetResolution() throws Exception {
      assertThat(classUnderTest.getResolution()).isNull(); // TODO
    }

}
