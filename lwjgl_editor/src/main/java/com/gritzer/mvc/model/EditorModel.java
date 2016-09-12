package com.gritzer.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.gritzer.util.math.Polygon;
import com.gritzer.util.math.Polygons;
import com.gritzer.util.math.Rectangle;
import com.gritzer.util.math.Square;
import com.gritzer.util.math.Triangle;

@Named
public class EditorModel implements Model {

	private final List<PolygonBot> bots = new ArrayList<>();

	@Override
	public void init() {
		final Polygon poly = new Rectangle(200, 100);
		poly.setX(-50);
		poly.setY(-50);
		final PolygonBot bot = new PolygonBot(poly);
		bot.setPosition(100f, 300f);
		bot.setTarget(bot.getX(), bot.getY());
		bots.add(bot);

		final Polygon poly2 = new Square(100);
		poly2.setX(-50);
		poly2.setY(-50);
		final PolygonBot bot2 = new PolygonBot(poly2);
		bot2.setPosition(100f, 500f);
		bot2.setTarget(bot2.getX(), bot2.getY());
		bots.add(bot2);

		final Polygon poly3 = new Triangle(100, 100);
		poly3.setX(-50);
		poly3.setY(-50);
		final PolygonBot bot3 = new PolygonBot(poly3);
		bot3.setPosition(100f, 700f);
		bot3.setTarget(bot3.getX(), bot3.getY());
		bots.add(bot3);
	}

	@Override
	public void update(Double t) {
		bots.stream().forEach(bot -> bot.accept(t));
	}

	public PolygonBot findBot(float x, float y) {
		return bots
				.stream()
				.filter(b -> Polygons.containsInBounds(b.getPolygon(),
						x - b.getX(), y - b.getY())).findFirst().orElse(null);
	}

	public List<PolygonBot> getBots() {
		return bots;
	}
}
