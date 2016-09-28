package org.bvoid.engine.core;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import org.bvoid.engine.gfx.camera.CameraUpdateService;
import org.bvoid.engine.gfx.render.OpenglInitializer;
import org.bvoid.engine.gfx.view.View;
import org.bvoid.engine.input.InputService;
import org.bvoid.engine.window.GlfwInitializer;
import org.bvoid.engine.window.GlfwWindowCloser;
import org.bvoid.engine.window.GlfwWindowInitializer;
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
  private GlfwInitializer glfwInitializer;
  @Mock
  private GlfwWindowInitializer glfwWindowInitializer;
  @Mock
  private OpenglInitializer openglInitializer;

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
    inOrder = inOrder(glfwInitializer, glfwWindowInitializer, openglInitializer, inputService,
        cameraUpdateSevice, view, windowCloser);
  }

  @Test
  public void testRunOnce() throws Exception {
    when(view.shouldClose()).thenReturn(false).thenReturn(true);

    classUnderTest.run();

    /**
     * INIT PHASE
     */
    inOrder.verify(glfwInitializer).init();
    inOrder.verify(glfwWindowInitializer).init();
    inOrder.verify(openglInitializer).init();

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
     * INIT PHASE
     */
    inOrder.verify(glfwInitializer).init();
    inOrder.verify(glfwWindowInitializer).init();
    inOrder.verify(openglInitializer).init();

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
