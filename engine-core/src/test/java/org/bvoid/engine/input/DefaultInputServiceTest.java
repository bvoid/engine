package org.bvoid.engine.input;

import org.bvoid.engine.window.Window;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DefaultInputServiceTest {

  @InjectMocks
  private DefaultInputService classUnderTest;

  @Mock
  private GLFWKeyCallback keyCallback;
  @Mock
  private GLFWCursorPosCallback cursorPosCallback;
  @Mock
  private GLFWMouseButtonCallback mouseButtonCallback;
  @Mock
  private GLFWScrollCallback scrollCallback;

  @Test
  public void testBindInputCallbacks() throws Exception {
    final Window windowMock = Mockito.mock(Window.class);

    classUnderTest.bindInputCallbacks(windowMock);

    Mockito.verify(windowMock).bindCursorPosCallback(cursorPosCallback);
    Mockito.verify(windowMock).bindKeyCallback(keyCallback);
    Mockito.verify(windowMock).bindMouseButtonCallback(mouseButtonCallback);
    Mockito.verify(windowMock).bindScrollCallback(scrollCallback);
  }

}
