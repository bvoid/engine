package org.bvoid.engine.scene;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

public class EntityTest {

  private final Entity classUnderTest = new Entity();

  @Test
  public void testIsSerializable() {
    final Entity copy = SerializationUtils.clone(classUnderTest);
    assertThat(classUnderTest).isEqualTo(copy);

    copy.setName("CHANGE");
    assertThat(classUnderTest).isNotEqualTo(copy);
  }

}
