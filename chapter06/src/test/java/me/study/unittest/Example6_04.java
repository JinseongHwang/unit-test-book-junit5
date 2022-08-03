package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class Example6_04 {

    @Test
    void Adding_a_comment_to_an_article() throws Exception {
        // Given
        final Article sut = new Article();
        final String text = "Comment text";
        final String author = "John Doe";
        final LocalDateTime now = LocalDateTime.now();

        // When
        sut.addComment(text,author,now);

        // Then
        assertThat(sut.comments().size()).isEqualTo(1);
        assertThat(sut.comments().get(0).text).isEqualTo(text);
        assertThat(sut.comments().get(0).author).isEqualTo(author);
        assertThat(sut.comments().get(0).dateCreated).isEqualTo(now);
    }
}
