package org.bvoid.engine.scene;

import java.util.ArrayList;
import java.util.List;

public class Entity {

  private String name;
  private final List<Entity> entities;
  // TODO example: private Transform transform; ---- optional? or abstract class?

  public Entity(String name) {
    this.name = name;
    this.entities = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Entity> getChildren() {
    return entities;
  }

}
