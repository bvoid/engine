package org.bvoid.engine.core;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.List;

import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.bvoid.engine.gfx.view.View;
import org.bvoid.engine.input.InputService;
import org.bvoid.engine.window.GlfwWindowCloser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EngineTest {

  @InjectMocks
  private Engine classUnderTest;
  @Mock
  private List<Initializer> initializers;
  @Mock
  private GlfwWindowCloser windowCloser;
  @Mock
  private CameraUpdateService cameraUpdateSevice;
  @Mock
  private InputService inputService;
  @Mock
  private View view;

  private InOrder inOrder;

  @Before
  public void setUp() throws Exception {
    inOrder = inOrder(inputService, cameraUpdateSevice, view, windowCloser);
  }

  @Test
  public void testRunOnce() throws Exception {
    when(view.shouldClose()).thenReturn(false).thenReturn(true);

    classUnderTest.run();

    /**
     * UPDATE PHASE
     */
    inOrder.verify(inputService).update();
    inOrder.verify(cameraUpdateSevice).update();
    inOrder.verify(view).update();

    /**
     * CLOSING PHASE
     */
    inOrder.verify(windowCloser).close();
  }

  @Test
  public void testRunTwice() throws Exception {
    when(view.shouldClose()).thenReturn(false).thenReturn(false).thenReturn(true);

    classUnderTest.run();

    /**
     * UPDATE PHASE
     */
    inOrder.verify(inputService).update();
    inOrder.verify(cameraUpdateSevice).update();
    inOrder.verify(view).update();
    inOrder.verify(inputService).update();
    inOrder.verify(cameraUpdateSevice).update();
    inOrder.verify(view).update();

    /**
     * CLOSING PHASE
     */
    inOrder.verify(windowCloser).close();
  }

}
