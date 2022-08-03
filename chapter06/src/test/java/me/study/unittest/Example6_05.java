package me.study.unittest;

import static me.study.unittest.ArticleExtensions.shouldContainNumberOfComments;
import static me.study.unittest.ArticleExtensions.withComment;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class Example6_05 {

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
        shouldContainNumberOfComments(sut, 1);
        withComment(sut,text,author,now);
    }
}
