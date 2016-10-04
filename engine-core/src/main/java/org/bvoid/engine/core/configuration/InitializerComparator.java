package org.bvoid.engine.core.configuration;

import java.util.Comparator;

import javax.inject.Named;

@Named
public class InitializerComparator implements Comparator<Initializer> {

  @Override
  public int compare(Initializer o1, Initializer o2) {
    if (o1.getOrdinal() > o2.getOrdinal()) {
      return 1;
    }
    if (o1.getOrdinal() < o2.getOrdinal()) {
      return -1;
    }
    return 0;
  }

}
