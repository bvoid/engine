package org.bvoid.engine.scene;

import java.util.ArrayList;
import java.util.List;

public class Scene {

  private String name;
  private final List<Entity> entities;

  public Scene(String name) {
    this.name = name;
    this.entities = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Entity> getRootEntities() {
    return entities;
  }

}
