package org.bvoid.engine.core.configuration;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DefaultInitializerSupplier implements Supplier<List<Initializer>> {

  @Inject
  private Comparator<Initializer> initializerComparator;
  @Inject
  private List<Initializer> initializers;

  @Override
  public List<Initializer> get() {
    final List<Initializer> sortedList = new ArrayList<>(initializers);
    Collections.sort(sortedList, initializerComparator);
    return sortedList;

  }

}
