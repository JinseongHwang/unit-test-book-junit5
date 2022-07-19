package me.study.unittest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Example4_4 {

    @Test
    void Rendering_a_message() throws Exception {
        // Given
        final MessageRenderer sut = new MessageRenderer();
        final Message message = new Message();
        message.setHeader("h");
        message.setBody("b");
        message.setFooter("f");

        // When
        final String html = sut.render(message);

        // Then
        Assertions.assertThat(html).isEqualTo("<h1>h</h1><b>b</b><i>f</i>");
    }
}
