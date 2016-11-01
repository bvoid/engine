package org.bvoid.app.example.gritzer.view;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnableClientState;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.app.example.gritzer.view.canvas.CanvasHolder;
import org.bvoid.engine.core.configuration.Initializer;
import org.bvoid.engine.render.Renderer;
import org.bvoid.engine.scene.Entity;
import org.bvoid.engine.scene.Scene;
import org.bvoid.engine.view.DefaultView;
import org.lwjgl.opengl.GL11;
import org.springframework.context.annotation.Primary;


@Named
@Primary
public class DemoView extends DefaultView implements Initializer {

  @Inject
  private CanvasHolder canvasHolder;
  @Inject
  private Renderer renderer;
  @Inject
  private SceneFactory sceneFactory;

  @Override
  public void update() {
    if (primaryWindow.resized(true)) {
      init();
    }
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    renderModel();
    renderGui();
    super.update();
  }

  private void renderGui() {

  }

  private void renderModel() {
    sceneFactory.create().forEach(this::renderScene);
  }

  private void renderScene(Scene scene) {
    scene.getEntities().forEach(this::renderEntity);
  }

  private void renderEntity(Entity entity) {
    entity.getShape().render(renderer.setTransform(entity.getTransform()));
    entity.getEntities().forEach(this::renderEntity);
  }

  @Override
  public void init() {
    glEnableClientState(GL_VERTEX_ARRAY);
    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity();
    // TODO What values do we need here?
    GL11.glOrtho(0, 640, 480, 0, 1, -1);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    canvasHolder.layout(primaryWindow.getWidth(), primaryWindow.getHeight());
  }

  @Override
  public int getOrdinal() {
    // TODO Auto-generated method stub
    return 10;
  }
}
