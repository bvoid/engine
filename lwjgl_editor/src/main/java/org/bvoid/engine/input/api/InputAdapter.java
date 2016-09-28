package org.bvoid.engine.input.api;

import javax.inject.Named;

import org.bvoid.engine.input.InputController;

@Named
public class InputAdapter implements InputController {

  @Override
  public void keyReleased(int inputConstant) {
    // System.out.println("key released");
  }

  @Override
  public void keyPressed(int inputConstant) {
    // System.out.println("keyPressed");
  }

  @Override
  public void mouseClicked(int inputConstant) {
    // System.out.println("mouseClicked");
  }

  @Override
  public void mouseReleased(int inputConstant) {
    // System.out.println("mouseReleased");
  }

  @Override
  public void mouseWheelMoved(double wheelDirection) {
    // System.out.println("mouseWheelMoved");
  }

  @Override
  public void mouseMoved(double xpos, double ypos) {
    // System.out.println("mouseMoved");
  }

}
