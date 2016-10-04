package com.gritzer.mvc.controller;

import javax.inject.Inject;
import javax.inject.Named;

import com.gritzer.mvc.model.EditorModel;
import com.gritzer.mvc.model.PolygonBot;
import com.gritzer.mvc.view.camera.Camera;
import com.gritzer.mvc.view.canvas.PolygonBotInfoCanvas;
import com.gritzer.mvc.view.event.EventController;
import com.gritzer.mvc.view.event.InputConstants;
import com.gritzer.util.info.Info;

@Named
public class EditorEventController implements EventController {

  @Inject
  private EditorModel editorModel;
  @Inject
  private PolygonBotInfoCanvas infoCanvas;
  @Inject
  private Camera camera;
  private int pointerX;
  private int pointerY;

  @Override
  public void keyReleased(int inputConstant) {
    switch (inputConstant) {
      case InputConstants.A:
        camera.move(-100, 0);
        break;
      case InputConstants.S:
        camera.move(0, 100);
        break;
      case InputConstants.D:
        camera.move(100, 0);
        break;
      case InputConstants.W:
        camera.move(0, -100);
        break;
      case InputConstants.E:
        camera.zoom(1, pointerX, pointerY);
        break;
      case InputConstants.Q:
        camera.zoom(-1, pointerX, pointerY);
        break;
      default:
        break;
    }
  }

  @Override
  public void keyPressed(int inputConstant) {}

  @Override
  public void mouseMoved(double xpos, double ypos) {
    pointerX = (int) xpos;
    pointerY = (int) ypos;
    infoCanvas.renderMouse(toXModel(pointerX), toYModel(pointerY));
  }

  @Override
  public void mouseClicked(int inputConstant) {}

  @Override
  public void mouseReleased(int inputConstant) {
    switch (inputConstant) {
      case InputConstants.MOUSE_BUTTON_1:
        select();
        break;
      case InputConstants.MOUSE_BUTTON_2:
        moveTo();
        break;
      case InputConstants.MOUSE_BUTTON_3:
        break;
      default:
        break;
    }

  }

  private void moveTo() {
    editorModel
        .getBots()
        .stream()
        .forEach(
            b -> b.setTarget(camera.translateXToModel(pointerX), camera.translateYToModel(pointerY)));
  }

  private void select() {
    infoCanvas.setInfo(findSelected(), Info.PROPERTIES);
  }

  // private void rotate(float r) {
  // final PolygonBot selected = findSelected();
  // if (selected == null) {
  // return;
  // }
  // selected.setDirection(camera.translateXToModel(pointerX),
  // camera.translateYToModel(pointerY));
  // infoCanvas.checkUpdate(selected);
  // }

  private PolygonBot findSelected() {
    return editorModel.findBot(toXModel(pointerX), toYModel(pointerY));
  }

  private float toYModel(int y) {
    return camera.translateYToModel(y);
  }

  private float toXModel(int x) {
    return camera.translateXToModel(x);
  }

  @Override
  public void mouseWheelMoved(double wheelDirection) {
    camera.zoom((int) -wheelDirection, pointerX, pointerY);
  }

}
