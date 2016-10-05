package org.bvoid.app.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(final String[] args) {
    try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
      ctx.scan("org.bvoid.engine", "org.bvoid.app.example");
      ctx.refresh();
    }
  }

}
