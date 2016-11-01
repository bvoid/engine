package org.bvoid.app.example.gritzer.view;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.model.Model;
import org.bvoid.engine.scene.Entity;
import org.bvoid.engine.scene.Scene;

@Named
public class SceneFactory implements Factory<List<Scene>> {

  @Inject
  private EntityTransformerHolder transformerHolder;

  @Inject
  private List<Model<?>> models;

  public List<Scene> create() {
    return models.stream().map(this::createScene).collect(Collectors.toList());
  }

  private Scene createScene(Model<?> model) {
    final EntityTransformer transformer = transformerHolder.getTransformer(model.getModelClass());
    final List<Entity> entities =
        model.getObjects().stream().map(transformer::transform).collect(Collectors.toList());
    final Scene scene = new Scene();
    scene.getEntities().addAll(entities);
    return scene;
  }
}
