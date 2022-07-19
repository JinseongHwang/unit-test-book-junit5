package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Example4_2 {

    @Test
    void MessageRenderer_uses_correct_sub_renderers() throws Exception {
        // Given
        final MessageRenderer sut = new MessageRenderer();

        // When
        final List<IRenderer> renderers = sut.getSubRenderers();

        // Then
        assertThat(renderers.size()).isEqualTo(3);
        assertThat(renderers.get(0)).isInstanceOf(HeaderRenderer.class);
        assertThat(renderers.get(1)).isInstanceOf(BodyRenderer.class);
        assertThat(renderers.get(2)).isInstanceOf(FooterRenderer.class);
    }
}
