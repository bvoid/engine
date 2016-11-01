package org.bvoid.engine.model;

import java.util.Collection;

public interface Model<T> {

  void update(long miliseconds);

  Collection<T> getObjects();

  Class<T> getModelClass();
}
