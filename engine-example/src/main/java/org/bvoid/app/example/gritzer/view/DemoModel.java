package org.bvoid.app.example.gritzer.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Named;

import org.bvoid.engine.model.Model;
import org.springframework.context.annotation.Primary;

@Named
@Primary
public class DemoModel implements Model<TestObject> {
  private final List<TestObject> testObjects = new ArrayList<>();


  @Override
  public void update(long miliseconds) {

  }

  @Override
  public Collection<TestObject> getObjects() {
    return testObjects;
  }

  @Override
  public Class<TestObject> getModelClass() {
    return TestObject.class;
  }



}
