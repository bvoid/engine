package org.bvoid.engine.render;

import static org.lwjgl.opengl.GL11.GL_COLOR_ARRAY;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glColorPointer;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.opengl.GL11.glVertexPointer;
import static org.lwjgl.opengl.GL12.glDrawRangeElements;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class ExperimentalService {

  public static void vertexBufferData(int id, FloatBuffer buffer) {
    glBindBuffer(GL_ARRAY_BUFFER, id);
    glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
  }

  public static void indexBufferData(int id, IntBuffer buffer) {
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
  }

  public static void render() {
    final int vertexBufferID = 0; // TODO
    final int colourBufferID = 0; // TODO
    final int numberIndices = 0; // TODO
    final int indexBufferID = 0; // TODO
    final int maxIndex = 0; // TODO

    glEnableClientState(GL_VERTEX_ARRAY);
    glBindBuffer(GL_ARRAY_BUFFER, vertexBufferID);
    glVertexPointer(3, GL_FLOAT, 0, 0);

    glEnableClientState(GL_COLOR_ARRAY);
    glBindBuffer(GL_ARRAY_BUFFER, colourBufferID);
    glColorPointer(4, GL_FLOAT, 0, 0);

    // If you are not using IBOs:
    glDrawArrays(GL_TRIANGLES, 0, numberIndices);

    // If you are using IBOs:
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBufferID);
    glDrawElements(GL_TRIANGLES, numberIndices, GL_UNSIGNED_INT, 0);

    // The alternate glDrawElements.
    glDrawRangeElements(GL_TRIANGLES, 0, maxIndex, numberIndices, GL_UNSIGNED_INT, 0);
  }

  public static int createVAO() {
    final int vaoId = glGenVertexArrays();

    glBindVertexArray(vaoId);
    // TODO Do something with it
    glBindVertexArray(0);

    return vaoId;
  }

  public static int createVBO() {
    final int vboId = glGenBuffers();

    glBindBuffer(GL_ARRAY_BUFFER, vboId);
    // TODO Do something with it
    glBindBuffer(GL_ARRAY_BUFFER, 0);

    return vboId;
  }

}
