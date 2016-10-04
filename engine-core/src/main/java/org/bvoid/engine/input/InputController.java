package org.bvoid.engine.input;

public interface InputController {

  public void keyReleased(final int inputConstant);

  public void keyPressed(final int inputConstant);

  public void mouseClicked(final int inputConstant);

  public void mouseReleased(final int inputConstant);

  public void mouseWheelMoved(final double wheelDirection);

  public void mouseMoved(final double xpos, final double ypos);

}
