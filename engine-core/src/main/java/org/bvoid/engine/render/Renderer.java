package org.bvoid.engine.render;

import org.bvoid.engine.scene.Transform;
import org.bvoid.engine.util.Polygon;

public interface Renderer {

  Renderer setTransform(Transform transform);

  Renderer render(String string);

  Renderer render(Polygon polygon);
}
