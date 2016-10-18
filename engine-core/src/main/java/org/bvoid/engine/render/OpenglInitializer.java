package org.bvoid.engine.render;

import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.glClearColor;

import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;

@Named
public class OpenglInitializer implements Initializer {

  @Override
  public void init() {
    createCapabilities();
    glClearColor((float) Math.random(), 0.0f, 0.0f, 0.0f);
  }

  @Override
  public int getOrdinal() {
    return 3;
  }

}
