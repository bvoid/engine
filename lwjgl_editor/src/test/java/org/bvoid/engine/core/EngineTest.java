package org.bvoid.engine.core;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.bvoid.engine.core.close.Closer;
import org.bvoid.engine.core.init.Initializer;
import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.bvoid.engine.gfx.view.View;
import org.bvoid.engine.input.InputService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

@RunWith(MockitoJUnitRunner.class)
public class EngineTest {

  private static final VerificationMode ONCE = times(1);

  @InjectMocks
  private Engine classUnderTest;
  @Mock
  private Initializer initializer;
  @Mock
  private Closer closer;
  @Mock
  private CameraUpdateService cameraUpdateSevice;
  @Mock
  private InputService inputService;
  @Mock
  private View view;

  private InOrder testOrder;

  @Before
  public void setUp() throws Exception {
    testOrder = Mockito.inOrder(initializer, inputService, cameraUpdateSevice, view, closer);
  }

  @Test
  public void testRunOnce() throws Exception {
    when(view.shouldClose()).thenReturn(false).thenReturn(true);

    classUnderTest.run();

    testOrder.verify(initializer, ONCE).init();
    testOrder.verify(inputService, ONCE).update();
    testOrder.verify(cameraUpdateSevice, ONCE).update();
    testOrder.verify(view, ONCE).update();
    testOrder.verify(closer, ONCE).close();
  }

  @Test
  public void testRunTwice() throws Exception {
    when(view.shouldClose()).thenReturn(false).thenReturn(false).thenReturn(true);

    classUnderTest.run();

    testOrder.verify(initializer, ONCE).init();
    testOrder.verify(inputService, ONCE).update();
    testOrder.verify(cameraUpdateSevice, ONCE).update();
    testOrder.verify(view, ONCE).update();
    testOrder.verify(inputService, ONCE).update();
    testOrder.verify(cameraUpdateSevice, ONCE).update();
    testOrder.verify(view, ONCE).update();
    testOrder.verify(closer, ONCE).close();
  }

}
