package org.bvoid.engine.scene;

import java.io.Serializable;
import java.util.List;

public interface Entity extends Serializable {

  String getName();

  String getType();

  Transform getTransform();

  Shape getShape();

  List<Entity> getEntities();

}
