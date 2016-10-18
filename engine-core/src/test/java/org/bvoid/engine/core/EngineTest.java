package org.bvoid.engine.core;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.function.Supplier;

import org.assertj.core.util.Lists;
import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.input.InputService;
import org.bvoid.engine.scene.camera.CameraUpdateService;
import org.bvoid.engine.view.View;
import org.bvoid.engine.window.GlfwWindowCloser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EngineTest {

  @InjectMocks
  private Engine classUnderTest;
  @Mock
  private Supplier<List<Initializer>> initializerSupplier;
  @Mock
  private GlfwWindowCloser windowCloser;
  @Mock
  private CameraUpdateService cameraUpdateSevice;
  @Mock
  private InputService inputService;
  @Mock
  private View view;

  private List<Initializer> initializers;
  private Initializer initMock1;
  private Initializer initMock2;

  private InOrder inOrder;

  @Before
  public void setUp() throws Exception {
    initMock1 = Mockito.mock(Initializer.class);
    initMock2 = Mockito.mock(Initializer.class);
    initializers = Lists.newArrayList(initMock1, initMock2);
    when(initializerSupplier.get()).thenReturn(initializers);

    inOrder = inOrder(initMock2, initMock1, inputService, cameraUpdateSevice, view, windowCloser);
  }

  @Test
  public void testRunOnce() throws Exception {
    when(view.shouldClose()).thenReturn(false).thenReturn(true);

    classUnderTest.run();

    /**
     * INIT PHASE
     */
    inOrder.verify(initMock1).init();
    inOrder.verify(initMock2).init();

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
    inOrder.verify(initMock1).init();
    inOrder.verify(initMock2).init();

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
