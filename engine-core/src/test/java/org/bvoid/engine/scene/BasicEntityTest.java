package org.bvoid.engine.scene;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

public class BasicEntityTest {

  private final BasicEntity classUnderTest = new BasicEntity();

  @Test
  public void testIsSerializable() {
    final BasicEntity copy = SerializationUtils.clone(classUnderTest);
    assertThat(classUnderTest).isEqualTo(copy);

    copy.setName("CHANGE");
    assertThat(classUnderTest).isNotEqualTo(copy);
  }

}
