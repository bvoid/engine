package org.bvoid.app.example.gritzer.scene;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.app.example.gritzer.view.canvas.DemoCanvas;
import org.bvoid.engine.scene.Scene;
import org.bvoid.engine.scene.SceneManager;
import org.bvoid.engine.scene.camera.Camera;
import org.springframework.context.annotation.Primary;


@Named
@Primary
public class DemoSceneInitializer extends SceneInitializer {

  @Inject
  private SceneManager sceneManager;
  @Inject
  private DemoCanvas demoCanvas;

  @Override
  public void init() {
    super.init();
    sceneManager.setScene(initScene());
  }

  private Scene initScene() {
    final Scene demoScene = new Scene();
    demoCanvas.setCamera(new Camera());
    return demoScene;
  }


}
