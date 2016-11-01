package org.bvoid.app.example.gritzer.view;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;

@Named
public class EntityTransformerHolder implements Initializer {
  private static final Map<Class<?>, EntityTransformer> TRANSFORMERS = new HashMap<>();

  @Override
  public void init() {
    TRANSFORMERS.put(TestObject.class, new TestObjectTransformer());
  }

  @Override
  public int getOrdinal() {
    return 0;
  }

  public EntityTransformer getTransformer(Class<?> clazz) {
    return TRANSFORMERS.get(clazz);
  }
}
