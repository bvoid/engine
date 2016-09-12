package com.gritzer.mvc.view.canvas;

import java.util.function.Consumer;

import com.gritzer.mvc.view.camera.ViewPort;
import com.gritzer.mvc.view.render.Renderer;

public interface Canvas extends Consumer<Renderer> {

	boolean contains(int x, int y);

	void layout(int x, int y, int w, int h);

	void setActive(boolean b);

	boolean isActive();

	ViewPort getBounds();

}
