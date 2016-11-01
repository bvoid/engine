package org.bvoid.app.example.gritzer.view;

import org.bvoid.engine.scene.BasicEntity;
import org.bvoid.engine.scene.Entity;

public class TestObjectTransformer extends AbstractTransformer<TestObject> {

  @Override
  protected Entity doTransform(TestObject o) {
    final BasicEntity newEntity = newEntity();
    setPosition(newEntity, o.getPosition());
    addEntity(newEntity, newEntity(o.getName(), o.getPosition()));
    return newEntity;
  }

}
