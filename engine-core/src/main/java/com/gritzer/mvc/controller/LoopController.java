package com.gritzer.mvc.controller;

import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.gritzer.mvc.model.Model;
import com.gritzer.mvc.view.View;

@Named
public class LoopController implements Consumer<Double> {

  @Inject
  private LoopGenerator loopGenerator;
  @Inject
  private View view;
  @Inject
  private Model model;

  @PostConstruct
  public void init() {
    loopGenerator.init();
    model.init();
    view.init();
    loopGenerator.startLoop(this);
  }

  @Override
  public void accept(Double time) {
    model.update(time);
    view.render();
  }

}
