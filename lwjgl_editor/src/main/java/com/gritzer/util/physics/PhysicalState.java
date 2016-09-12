package com.gritzer.util.physics;

import java.io.Serializable;

public interface PhysicalState extends Serializable {

	PhysicalState update(double time);

	PhysicalState setDirection(double x, double y);

	PhysicalState relocate(double x, double y);

	PhysicalState decelerate(double d, double time);

	PhysicalState accelerate(Vector direction, double time);

	PhysicalState accelerate(double time);

	PhysicalState stop();

	PhysicalState correctMomentum(double time);

	Vector getDirection();

	Vector getMomentum();

	Vector getPosition();

	double getVelocity();

	double getTheta();

	double getX();

	double getY();

	double getThrust();

	double getMass();

	void setThrust(double thrust);

	void setDirection(Vector vector);

	void setMass(double i);

	void setTheta(double direction);

}
