package org.bvoid.engine.gfx.window;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MonitorTest {

  private static final long SAMPLE_HANDLE = 0xDEAD;

  private final Monitor classUnderTest = new Monitor(SAMPLE_HANDLE);

  @Test
  public void testGetHandle() throws Exception {
    assertThat(classUnderTest.getHandle()).isEqualTo(SAMPLE_HANDLE);
  }

  @Test
  public void testGetName() throws Exception {
    assertThat(classUnderTest.getName()).isNull(); // TODO
  }

  // TODO @Test
  public void testGetSize() throws Exception {
    assertThat(classUnderTest.getSize()).isNull(); // TODO
  }

}
