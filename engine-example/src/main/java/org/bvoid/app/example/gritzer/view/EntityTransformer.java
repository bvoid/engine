package org.bvoid.app.example.gritzer.view;

import org.bvoid.engine.scene.Entity;

public interface EntityTransformer {

  <T> Entity transform(T object);
}
