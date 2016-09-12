package com.gritzer.mvc.view.event;

public interface EventController {

	void keyReleased(int inputConstant);

	void keyPressed(int inputConstant);

	void mouseClicked(int inputConstant);

	void mouseReleased(int inputConstant);

	void mouseMoved(double xpos, double ypos);

}