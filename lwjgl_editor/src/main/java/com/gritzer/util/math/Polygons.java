package com.gritzer.util.math;

import java.awt.geom.AffineTransform;
import java.util.function.BiConsumer;

public class Polygons {
  private static final AffineTransform at = new AffineTransform();
  private static final Polygon polygonToRender = new Polygon();
  public static final BiConsumer<Polygon, Double> ROTATE_BY_DEGREES = createRotationConsumer();

  private Polygons() {

  }

  public static Polygon transform(Polygon p, float x, float y, float theta, float zoom) {
    polygonToRender.setX(p.getX());
    polygonToRender.setY(p.getY());
    polygonToRender.setColor(p.getColor());
    polygonToRender.setxPoints(new float[p.getxPoints().length]);
    polygonToRender.setYPoints(new float[p.getxPoints().length]);

    final float[] originalPoints = extractPoints(p);
    final float[] newPoints = new float[originalPoints.length];

    reset();
    at.rotate(theta, -p.getX(), -p.getY());
    transform(originalPoints, newPoints, p.getxPoints().length);
    setPoints(polygonToRender, newPoints, x, y, zoom);

    return polygonToRender;

  }

  private static BiConsumer<Polygon, Double> createRotationConsumer() {
    return (p, degrees) -> {
      if (p == null) {
        return;
      }

      final float[] originalPoints = extractPoints(p);

      final float[] newPoints = new float[originalPoints.length];

      reset();
      rotate(p, degrees);
      transform(originalPoints, newPoints, p.getxPoints().length);

      setPoints(p, newPoints);
      setRotation(p, degrees);
    };
  }

  public static boolean containsInBounds(Polygon p, float x, float y) {
    // TODO Bounds should be a square or this will not work correctly for
    // rotated polygons
    final boolean contains =
        p.getX() <= x && p.getY() <= y && (p.getX() + p.getW()) >= x && (p.getY() + p.getH()) >= y;

    return contains;
  }

  private static void reset() {
    at.setToIdentity();
  }

  private static void rotate(Polygon p, Double degrees) {
    at.rotate(Math.toRadians(degrees), p.getW() / 2, p.getH() / 2);
  }

  private static void transform(float[] originalXYPoints, float[] newXYPoints, int length) {
    at.transform(originalXYPoints, 0, newXYPoints, 0, length);
  }

  private static void setRotation(Polygon p, Double degrees) {
    p.setR(degrees.floatValue());
  }

  private static float[] extractPoints(Polygon p) {
    int xIndex = 0;
    int yIndex = 0;
    final float[] originalXYPoints = new float[p.getxPoints().length + p.getyPoints().length];
    for (int i = 0; i < originalXYPoints.length; i++) {
      if (i % 2 == 0) {
        originalXYPoints[i] = p.getxPoints()[xIndex];
        xIndex++;
      } else {
        originalXYPoints[i] = p.getyPoints()[yIndex];
        yIndex++;
      }
    }
    return originalXYPoints;
  }

  private static void setPoints(Polygon p, float[] newPoints) {
    int xIndex = 0;
    int yIndex = 0;
    for (int i = 0; i < newPoints.length; i++) {
      if (i % 2 == 0) {
        p.getxPoints()[xIndex] = newPoints[i];
        xIndex++;
      } else {
        p.getyPoints()[yIndex] = newPoints[i];
        yIndex++;
      }
    }

  }

  private static void setPoints(Polygon p, float[] newPoints, float x, float y, float zoom) {
    int xIndex = 0;
    int yIndex = 0;
    for (int i = 0; i < newPoints.length; i++) {
      if (i % 2 == 0) {
        p.getxPoints()[xIndex] = newPoints[i] * zoom + x;
        xIndex++;
      } else {
        p.getyPoints()[yIndex] = newPoints[i] * zoom + y;
        yIndex++;
      }
    }
  }

}
