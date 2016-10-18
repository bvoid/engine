package org.bvoid.engine.scene;

import javax.inject.Named;

@Named
public class SceneManager {

  private Scene scene;

  public SceneManager() {}

  public Scene getScene() {
    return scene;
  }

  public void setScene(Scene scene) {
    this.scene = scene;
  }

}
