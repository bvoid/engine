package org.bvoid.engine.core;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.bvoid.engine.core.state.EngineState;
import org.bvoid.engine.core.state.EngineStateHolder;
import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.bvoid.engine.window.WindowCloser;
import org.bvoid.engine.window.WindowInitializer;
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
  private WindowInitializer windowInitializer;

  @Mock
  private WindowCloser windowCloser;

  @Mock
  private CameraUpdateService cameraUpdateSevice;
  @Mock
  private EngineStateHolder engineStateHolder;

  @Test
  public void testRunOnce() throws Exception {
    when(engineStateHolder.getState()).thenReturn(EngineState.PAUSED);

    classUnderTest.run();

    verify(windowInitializer, ONCE).init();
    verify(cameraUpdateSevice, ONCE).update();
    verify(windowCloser, ONCE).close();
  }

  @Test
  public void testRunTwice() throws Exception {
    when(engineStateHolder.getState()).thenReturn(EngineState.RUNNING)
        .thenReturn(EngineState.PAUSED);

    classUnderTest.run();

    verify(windowInitializer, ONCE).init();
    verify(cameraUpdateSevice, TWICE).update();
    verify(windowCloser, ONCE).close();
  }

}
