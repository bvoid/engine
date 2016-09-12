package com.gritzer.mvc.model;

import com.gritzer.util.math.Polygon;
import com.gritzer.util.physics.BasicPhysicalState;
import com.gritzer.util.physics.PhysicalState;

public class PolygonBot implements Simulatable {

  private Polygon polygon;
  private BasicPhysicalState physicalState = new BasicPhysicalState(1d);
  private double distance;
  private boolean moving;
  private float targetX;
  private float targetY;

  public PolygonBot(Polygon p) {
    this.polygon = p;
    physicalState.setThrust(50);
  }

  @Override
  public void accept(Double t) {
    move(targetX, targetY, t);
  }

  public Polygon getPolygon() {
    return polygon;
  }

  public void setPolygon(Polygon polygon) {
    this.polygon = polygon;
  }

  protected void accelerate(PhysicalState state, double time) {
    state.accelerate(time);
  }

  protected void rotate(PhysicalState state, double x, double y) {
    state.setDirection(x, y);
  }

  protected void calculateDistance(double x1, double y1, double x2, double y2) {
    distance = distanceTo(x1, y1, x2, y2);
  }

  public double distanceTo(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(Math.abs((x2) - (x1)), 2) + Math.pow(Math.abs((y2) - (y1)), 2));
  }

  public void move(double x, double y, double time) {

    calculateDistance(x, y, this.getX(), this.getY());

    if (distance < 1) {
      moving = false;
      physicalState.stop();
      return;
    }
    physicalState.update(time);
    physicalState.setDirection(BasicPhysicalState.normalize(physicalState.getMomentum()));

    rotate(physicalState, x, y);
    accelerate(physicalState, time);

  }

  protected boolean targetReached(PhysicalState state, double x, double y) {
    calculateDistance(state.getX(), state.getY(), x, y);
    return distance < 10 && state.getVelocity() < 10;
  }

  public void setTarget(float x, float y) {
    targetX = x;
    targetY = y;
  }

  public float getX() {
    return (float) physicalState.getX();
  }

  public float getY() {
    return (float) physicalState.getY();
  }

  public float getW() {
    // TODO get from poly
    return 10;
  }

  public float getH() {
    // TODO get from poly
    return 10;
  }

  public float getTheta() {
    return (float) physicalState.getTheta();
  }

  public void setPosition(float x, float y) {
    physicalState.relocate(x, y);
  }

  public void setDirection(float translateXToModel, float translateYToModel) {
    physicalState.setDirection(translateXToModel, translateYToModel);
  }

  public float getTargetX() {
    return targetX;
  }

  public void setTargetX(float targetX) {
    this.targetX = targetX;
  }

  public float getTargetY() {
    return targetY;
  }

  public void setTargetY(float targetY) {
    this.targetY = targetY;
  }

  /**
   * push this object towards a give angle for a given time (using its thrust)
   * 
   * @param degrees
   * @param time
   */
  public void push(float degrees, float time) {
    physicalState.accelerate(BasicPhysicalState.getDirection(Math.toRadians(degrees)), time);
  }

  public boolean isMoving() {
    return moving;
  }

}
