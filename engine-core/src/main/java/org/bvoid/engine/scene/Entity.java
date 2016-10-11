package org.bvoid.engine.scene;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Entity implements Serializable {

  private static final long serialVersionUID = 0xA000000000000001L;

  private final List<Entity> entities = new ArrayList<>(); // TODO discuss final & init

  private String name;
  private Transform transform;

  public Entity() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Transform getTransform() {
    return transform;
  }

  public void setTransform(Transform transform) {
    this.transform = transform;
  }

  public List<Entity> getChildEntities() {
    return entities;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((entities == null) ? 0 : entities.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((transform == null) ? 0 : transform.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Entity other = (Entity) obj;
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
    if (transform == null) {
      if (other.transform != null)
        return false;
    } else if (!transform.equals(other.transform))
      return false;
    return true;
  }

}
