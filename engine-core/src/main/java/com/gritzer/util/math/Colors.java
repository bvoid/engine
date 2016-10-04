package com.gritzer.util.math;

public enum Colors {
  ;
  public static final Color RED = new Color(255, 0, 0);
  public static final Color GREEN = new Color(0, 255, 0);
  public static final Color BLUE = new Color(0, 0, 255);
  public static final Color PINK = new Color(255, 0, 255);
  public static final Color TURQ = new Color(0, 255, 255);
  public static final Color YELLOW = new Color(255, 255, 0);
  public static final Color WHITE = new Color(255, 255, 255);
  public static final Color LIGHT_GRAY = new Color(200, 200, 200);
  public static final Color GRAY = new Color(150, 150, 150);
  public static final Color DARK_GRAY = new Color(60, 60, 60);
  public static final Color BLACK = new Color(0, 0, 0);

  public static final Color[] COLORS =
      new Color[] {RED, GREEN, BLUE, PINK, TURQ, YELLOW, WHITE, LIGHT_GRAY, GRAY, DARK_GRAY};

  public static Color random() {
    final int red = (int) (((Math.random() * 255) + 255) / 2);
    final int green = (int) (((Math.random() * 255) + 255) / 2);
    final int blue = (int) (((Math.random() * 255) + 255) / 2);
    return new Color(red, green, blue);
  }

}
