package org.bvoid.engine.input;

public interface InputController {

  void keyReleased(int inputConstant);

  void keyPressed(int inputConstant);

  void mouseClicked(int inputConstant);

  void mouseReleased(int inputConstant);

  void mouseWheelMoved(double wheelDirection);

  void mouseMoved(double xpos, double ypos);

}
