package com.gritzer.mvc.view.lwjgl;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertexPointer;
import static org.lwjgl.stb.STBEasyFont.stb_easy_font_print;

import java.nio.ByteBuffer;

import javax.inject.Named;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import com.gritzer.mvc.view.render.Renderer;
import com.gritzer.util.math.Color;
import com.gritzer.util.math.Polygon;

@Named
public class LwjglRenderer implements Renderer {

  @Override
  public Renderer renderPolygon(Polygon p) {
    Color color = p.getColor();
    GL11.glColor3f(color.getR() / 255f, color.getG() / 255f, color.getB() / 255f);

    GL11.glBegin(GL11.GL_POLYGON);
    for (int i = 0; i < p.getxPoints().length; i++) {
      GL11.glVertex2f(p.getxPoints()[i], p.getyPoints()[i]);
    }
    GL11.glEnd();

    return this;
  }

  @Override
  public Renderer drawString(String text, float x, float y) {
    glPushMatrix();
    // TODO scale -> see EasyFont (google)
    // glScalef(2f, 2f, 1f);
    // glTranslatef(-150, -50, 0f);
    ByteBuffer charBuffer = BufferUtils.createByteBuffer(text.length() * 270 * 3);
    int quads = stb_easy_font_print(x, y, text, null, charBuffer);

    glVertexPointer(2, GL_FLOAT, 16, charBuffer);
    glColor3f(255f, 255f, 255f); // Text color
    glDrawArrays(GL_QUADS, 0, quads * 4);
    glPopMatrix();
    return this;
  }

  @Override
  public int getFontSize() {
    // TODO calculate Font size
    return 20;
  }

}
