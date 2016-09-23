package org.bvoid.engine.window;

import javax.inject.Named;

import org.bvoid.engine.core.configuration.Closer;

@Named
public class WindowCloser implements Closer {

  @Override
  public void close() {
    System.out.println("WINDOW::CLOSER"); // TODO
  }

}
