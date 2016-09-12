package com.gritzer.launcher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(final String[] args) {
		try (AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext()) {
			ctx.scan("com.gritzer");
			ctx.refresh();
		}
	}

}
