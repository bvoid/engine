package org.bvoid.app.example.gritzer.view;

import javax.inject.Inject;
import javax.inject.Named;

import org.bvoid.engine.core.configuration.Initializer;


@Named
public class ModelInitializer implements Initializer {

  @Inject
  private DemoModel demoModel;

  @Override
  public void init() {
    demoModel.getObjects().add(new TestObject("Number 1 at 100,100", 100, 100));
    demoModel.getObjects().add(new TestObject("Number 2 at 100,200", 100, 200));
    demoModel.getObjects().add(new TestObject("Number 3 at 300,100", 300, 100));
    demoModel.getObjects().add(new TestObject("Number 4 at 300,300", 300, 300));
  }

  @Override
  public int getOrdinal() {
    return 0;
  }


}
