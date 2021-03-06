package org.bvoid.engine.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicEntity implements Entity {

  private static final long serialVersionUID = 0xA000000000000001L;

  private final List<Entity> entities = new ArrayList<>();

  private String name;
  private String type;
  private Transform transform;
  private Shape shape;

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public Transform getTransform() {
    return transform;
  }

  public void setTransform(Transform transform) {
    this.transform = transform;
  }

  public List<Entity> getEntities() {
    return entities;
  }

  public Shape getShape() {
    return shape;
  }

  public void setShape(Shape shape) {
    this.shape = shape;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, transform, entities);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BasicEntity other = (BasicEntity) obj;
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
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }

}
