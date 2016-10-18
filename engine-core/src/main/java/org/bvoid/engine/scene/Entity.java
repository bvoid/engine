package org.bvoid.engine.scene;

import java.io.Serializable;
import java.util.List;

public interface Entity extends Serializable {

  public String getName();

  public String getType();

  public Transform getTransform();

  public List<BasicEntity> getEntities();

}
