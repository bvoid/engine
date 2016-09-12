package com.gritzer.mvc.view.lwjgl;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Named;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import com.gritzer.mvc.controller.LoopGenerator;

@Named
public class LwjglLoopGenerator implements LoopGenerator {

	private static final String TITLE = "LWJGL SPACE";

	private static final int SCREEN_WIDTH = 1920;
	private static final int SCREEN_HEIGHT = 1025;

	@Inject
	private GLFWKeyCallback keyCallback;
	@Inject
	private GLFWCursorPosCallback mouseCallback;
	@Inject
	private GLFWMouseButtonCallback mouseButtonCallback;

	private long window;

	private void prepareOPENGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, SCREEN_WIDTH, SCREEN_HEIGHT, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

	}

	@Override
	public void init() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if (!glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		// Configure our window
		glfwDefaultWindowHints(); // optional, the current window hints are
									// already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden
													// after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window will be
													// resizable

		int WIDTH = SCREEN_WIDTH;
		int HEIGHT = SCREEN_HEIGHT;

		// Create the window
		window = glfwCreateWindow(WIDTH, HEIGHT, TITLE, NULL, NULL);
		if (window == NULL)
			throw new RuntimeException("Failed to create the GLFW window");

		glfwSetKeyCallback(window, keyCallback);
		glfwSetCursorPosCallback(window, mouseCallback);
		org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback(window, mouseButtonCallback);

		// Get the resolution of the primary monitor
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Center our window
		glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);

		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);

		// Make the window visible
		glfwShowWindow(window);

	}

	@Override
	public void startLoop(final Consumer<Double> consumer) {
		// This line is critical for LWJGL's interoperation with GLFW's
		// OpenGL context, or any context that is managed externally.
		// LWJGL detects the context that is current in the current thread,
		// creates the GLCapabilities instance and makes the OpenGL
		// bindings available for use.
		GL.createCapabilities();
		prepareOPENGL();
		// Set the clear color
		glClearColor(1, 1, 1, 1);
		double delta;
		long lastTime;
		long nowTime = java.lang.System.currentTimeMillis();
		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.

		glEnableClientState(GL_VERTEX_ARRAY);

		glClearColor(43f / 255f, 43f / 255f, 43f / 255f, 0f); // BG color

		while (!glfwWindowShouldClose(window)) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			lastTime = nowTime;
			delta = 0d;

			nowTime = java.lang.System.currentTimeMillis();
			delta = nowTime - lastTime;

			consumer.accept(delta / 1000d);

			glfwSwapBuffers(window);

			glfwPollEvents();
		}
	}

	@Override
	public void stopLoop() {
		Callbacks.glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
		// TODO ??? glfwSetErrorCallback(null).release();
	}

}