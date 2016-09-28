package org.bvoid.engine.gfx.render;

import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.glClearColor;

import org.bvoid.engine.core.configuration.Initializer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class OpenglInitializer implements Initializer {

  @Override
  public void init() {
    createCapabilities();
    glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);
  }

}
