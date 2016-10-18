package org.bvoid.engine.scene;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene implements Serializable {

  private static final long serialVersionUID = 0xA000000000000001L;

  private final List<Entity> entities = new ArrayList<>();

  private String name;

  public Scene() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Entity> getEntities() {
    return entities;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, entities);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Scene other = (Scene) obj;
    if (entities == null) {
      if (other.entities != null)
        return false;
    } else if (!entities.equals(other.entities))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
