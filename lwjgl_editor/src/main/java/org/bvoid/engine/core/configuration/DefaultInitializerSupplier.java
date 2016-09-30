package org.bvoid.engine.core.configuration;


import java.util.List;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DefaultInitializerSupplier implements Supplier<List<Initializer>> {

  @Inject
  private List<Initializer> initializers;

  @Override
  public List<Initializer> get() {
    return initializers;
  }

}
