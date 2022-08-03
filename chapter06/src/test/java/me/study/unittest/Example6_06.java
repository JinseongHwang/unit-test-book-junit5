package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class Example6_06 {

    @Test
    void Adding_a_comment_to_an_article() throws Exception {
        // Given
        final Article sut = new Article();
        final Comment comment = new Comment(
            "Comment text",
            "John Doe",
            LocalDateTime.now()
        );

        // When
        sut.addComment(comment.text, comment.author, comment.dateCreated);

        // Then
        assertThat(sut.comments()).containsExactly(comment);
    }
}
