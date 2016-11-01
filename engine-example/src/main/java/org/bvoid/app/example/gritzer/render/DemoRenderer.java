package org.bvoid.app.example.gritzer.render;

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

import org.bvoid.engine.render.Renderer;
import org.bvoid.engine.scene.Transform;
import org.bvoid.engine.util.Polygon;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import com.gritzer.util.math.Color;
import com.gritzer.util.math.Colors;

@Named
public class DemoRenderer implements Renderer {

  private Transform transform;

  @Override
  public Renderer setTransform(Transform transform) {
    this.transform = transform;
    return this;
  }

  @Override
  public Renderer render(String text) {
    glPushMatrix();
    // TODO scale -> see EasyFont (google)
    // glScalef(2f, 2f, 1f);
    // glTranslatef(-150, -50, 0f);
    ByteBuffer charBuffer = BufferUtils.createByteBuffer(text.length() * 270 * 3);
    int quads =
        stb_easy_font_print(transform.getPos().getX(), transform.getPos().getY(), text, null,
            charBuffer);
    glVertexPointer(2, GL_FLOAT, 16, charBuffer);
    glColor3f(255f, 255f, 255f); // Text color
    glDrawArrays(GL_QUADS, 0, quads * 4);
    glPopMatrix();
    return this;
  }

  @Override
  public Renderer render(Polygon p) {
    Color color = Colors.DARK_GRAY;
    GL11.glColor3f(color.getR() / 255f, color.getG() / 255f, color.getB() / 255f);

    GL11.glBegin(GL11.GL_POLYGON);
    for (int i = 0; i < p.getXPoints().length; i++) {
      GL11.glVertex2f(p.getXPoints()[i], p.getYPoints()[i]);
    }
    // GL11.glVertex2f(100, 300);
    // GL11.glVertex2f(1000, 300);
    // GL11.glVertex2f(1000, 900);
    // GL11.glVertex2f(100, 900);
    GL11.glEnd();

    return this;
  }

}
