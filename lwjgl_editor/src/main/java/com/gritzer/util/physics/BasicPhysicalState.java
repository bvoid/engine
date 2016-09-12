package com.gritzer.util.physics;

import java.awt.Point;

//First attempt on physics
public class BasicPhysicalState implements PhysicalState {

	private static final long serialVersionUID = 1L;
	private static final double epsilon = Double.MIN_VALUE;
	private Vector position;
	private Vector direction;
	private double velocity;
	private Vector momentum;
	private Vector force;
	private double acceleration;
	private double mass;
	private double thrust;

	// private Point lastPoint = new Point();
	// private double avrgVelo;

	public BasicPhysicalState(double mass) {
		this.mass = mass;
		init();
	}

	private void init() {
		position = new Vector();
		direction = new Vector();
		momentum = new Vector();
		force = new Vector();
	}

	@Override
	public BasicPhysicalState update(double time) {
		position = position.add(momentum.multiply(time));
		// TODO calculate velocity and average velocity here?

		// final Point currentPoint = new Point((int) position.getX2(),
		// (int) position.getY2());
		// velocity = lastPoint.distance(currentPoint) / time;
		// lastPoint = currentPoint;
		// if (velocity > 1) {
		// avrgVelo = (velocity + avrgVelo) / 2;
		// }
		return this;
	}

	@Override
	public BasicPhysicalState setDirection(double x, double y) {
		direction = normalize((new Vector(0, 0, x - position.x2, y
				- position.y2)));
		return this;
	}

	@Override
	public BasicPhysicalState accelerate(double time) {
		return accelerate(direction, time);
	}

	@Override
	public BasicPhysicalState accelerate(Vector direction, double time) {
		momentum = momentum.add(normalize(direction).multiply(
				thrust / mass * time));
		return this;
	}

	@Override
	public BasicPhysicalState decelerate(double f, double time) {
		// force = new Vector(direction.multiply(-1));
		// force = force.multiply((f * time / mass));
		// momentum = momentum.add(force);
		momentum = momentum.add(normalize(direction.multiply(-1)).multiply(f));
		return this;
	}

	@Override
	public double getTheta() {
		return getTheta(direction);
	}

	@Override
	public void setTheta(double theta) {
		setDirection(getDirection(theta));
	}

	public static double getTheta(Vector v) {
		return Math.atan2(v.x2 - v.x1, -v.y2 + v.y1);
	}

	@Override
	public Vector getPosition() {
		return position;
	}

	public static Vector getDirection(double theta) {
		final Vector dir = normalize(new Vector(0, 0, 0, -10));
		double x = Math.cos(theta) * dir.x2 - Math.sin(theta) * dir.y2;
		double y = Math.sin(theta) * dir.x2 + Math.cos(theta) * dir.y2;
		return normalize(new Vector(0, 0, x, y));
	}

	public static Vector normalize(Vector v1) {
		final Vector v = new Vector(v1);
		v.x1 = 0;
		v.y1 = 0;
		if (v.x2 < epsilon && v.x2 > -epsilon && v.y2 < epsilon
				&& v.y2 > -epsilon) {
			v.x2 = (1.0f);
			v.y2 = (0.0f);
		} else {
			final double length = Math.sqrt(v.x2 * v.x2 + v.y2 * v.y2);
			v.x2 = (v.x2 / length);
			v.y2 = (v.y2 / length);

		}
		return v;
	}

	@Override
	public PhysicalState relocate(double x, double y) {
		position.x2 = x;
		position.y2 = y;
		return this;
	}

	@Override
	public PhysicalState stop() {
		momentum = new Vector();
		update(0d);
		return this;
	}

	// TODO refactor
	@Override
	public PhysicalState correctMomentum(double time) {
		// Vector v = normalize(calculateAbweichungsVector(velocity,
		// direction));
		momentum = momentum.add(momentum.multiply(-time)).add(
				normalize(direction).multiply(time));
		// momentum = momentum.add(normalize(direction).multiply(time));
		return this;

	}

	@Override
	public Vector getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Vector vector) {
		direction = vector;
	}

	@Override
	public void setMass(double i) {
		this.mass = i;
	}

	@Override
	public double getMass() {
		return mass;
	}

	public Vector getMomentum() {
		return momentum;
	}

	public void setMomentum(Vector momentum) {
		this.momentum = momentum;
	}

	public Vector getForce() {
		return force;
	}

	public void setForce(Vector force) {
		this.force = force;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	@Override
	public double getX() {
		return position.x2;
	}

	@Override
	public double getY() {
		return position.y2;
	}

	@Override
	public double getThrust() {
		return thrust;
	}

	@Override
	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	@Override
	public double getVelocity() {
		return velocity;
	}

}
