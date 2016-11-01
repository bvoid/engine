package org.bvoid.app.example.gritzer.view;

import org.bvoid.app.example.gritzer.scene.TextShape;
import org.bvoid.engine.geom.Point2D;
import org.bvoid.engine.scene.BasicEntity;
import org.bvoid.engine.scene.Entity;
import org.bvoid.engine.scene.Shape;
import org.bvoid.engine.scene.Transform;

public abstract class AbstractTransformer<U> implements EntityTransformer {
  private static final Shape EMPTY_SHAPE = new EmptyShape();

  @Override
  public Entity transform(Object object) {
    return doTransform((U) object);
  }

  protected BasicEntity newEntity() {
    final BasicEntity entity = new BasicEntity();
    entity.setShape(EMPTY_SHAPE);
    entity.setTransform(new Transform());
    return entity;
  }

  protected BasicEntity newEntity(String name, Point2D position) {
    final BasicEntity newEntity = newEntity();
    setPosition(newEntity, position);
    setName(newEntity, name);
    return newEntity;
  }

  protected AbstractTransformer<U> setPosition(BasicEntity newEntity, Point2D position) {
    newEntity.setTransform(new Transform(position));
    return this;
  }


  protected AbstractTransformer<U> setName(BasicEntity entity, String name) {
    TextShape textShape = new TextShape(name);
    entity.setShape(textShape);
    return this;
  }

  public void addEntity(Entity entity, Entity other) {
    entity.getEntities().add(other);
  }

  protected abstract Entity doTransform(U o);



}
