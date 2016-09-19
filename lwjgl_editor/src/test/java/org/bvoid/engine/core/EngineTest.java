package org.bvoid.engine.core;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.bvoid.engine.core.close.Closer;
import org.bvoid.engine.core.init.Initializer;
import org.bvoid.engine.core.state.EngineState;
import org.bvoid.engine.core.state.EngineStateHolder;
import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

@RunWith(MockitoJUnitRunner.class)
public class EngineTest {
  private static final VerificationMode ONCE = times(1);
  private static final VerificationMode TWICE = times(2);

  @InjectMocks
  private Engine classUnderTest;
  @Mock
  private Initializer initializer;
  @Mock
  private Closer closer;
  @Mock
  private CameraUpdateService cameraUpdateSevice;
  @Mock
  private EngineStateHolder engineStateHolder;

  @Test
  public void testRunOnce() throws Exception {
    when(engineStateHolder.getState()).thenReturn(EngineState.PAUSED);

    classUnderTest.run();

    verify(initializer, ONCE).init();
    verify(cameraUpdateSevice, ONCE).update();
    verify(closer, ONCE).close();
  }

  @Test
  public void testRunTwice() throws Exception {
    when(engineStateHolder.getState()).thenReturn(EngineState.RUNNING).thenReturn(
        EngineState.PAUSED);

    classUnderTest.run();

    verify(initializer, ONCE).init();
    verify(cameraUpdateSevice, TWICE).update();
    verify(closer, ONCE).close();
  }
}
