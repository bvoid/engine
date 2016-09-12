package com.gritzer.mvc.view.camera;


public interface Camera {

	boolean isInView(ViewPort bounds, float x, float y);

	void move(int x, int y);

	void zoom(int direction, float x, float y);

	float translateXToModel(float x);

	float translateYToModel(float y);

	float translateXToView(float x);

	float translateYToView(float y);

	void centerView(float x, float y);

	float getZoom();

	void setZoom(float zoom);

	float getX();

	float getY();

	float getW();

	float getH();

	void setX(float x);

	void setY(float y);

	void setW(float w);

	void setH(float h);

	boolean isRendered(RenderSize renderSize);

	ViewPort translateToModel(ViewPort rect);

	boolean isInView(ViewPort bounds, ViewPort rectangle);

}
