package com.gritzer.util.info;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import com.gritzer.mvc.model.PolygonBot;

public class Info {
  /**
   * Retrieves properties of the given Polygon.
   */
  public static final Function<PolygonBot, Map<String, String>> PROPERTIES =
      initPropertiesFunction();

  private static Function<PolygonBot, Map<String, String>> initPropertiesFunction() {
    return (p) -> {
      if (p == null) {
        return null;
      }
      final Map<String, String> properties = new LinkedHashMap<>();
      properties.put("type", "" + p.getClass().getSimpleName());
      properties.put("x", "" + p.getX());
      properties.put("y", "" + p.getY());

      properties.put("r", "" + calculateDegrees(p.getTheta()));
      properties.put("w", "" + p.getW());
      properties.put("h", "" + p.getH());

      return properties;
    };
  }

  private static String calculateDegrees(float theta) {

    long degrees = Math.round(Math.toDegrees(theta));
    if (degrees < 0) {
      return "" + (180 + (180 + degrees));
    }
    return "" + degrees;

  }

}
