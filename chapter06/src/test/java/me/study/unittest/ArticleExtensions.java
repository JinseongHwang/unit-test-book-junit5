package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleExtensions {

    public static void shouldContainNumberOfComments(Article article, int commentCount) {
        assertThat(article.comments().size()).isEqualTo(1);
    }

    public static void withComment(Article article, String text, String author, LocalDateTime dateCreated) {
        final List<Comment> comments = article.comments();
        final Comment comment = getSingleOrDefault(comments, text, author, dateCreated);
        assertThat(comment).isNotNull();
    }

    private static Comment getSingleOrDefault(List<Comment> comments, String text, String author, LocalDateTime dateCreated) {
        if (comments.size() > 1) {
            throw new IllegalStateException();
        }
        if (comments.isEmpty()) {
            return new Comment(text, author, dateCreated);
        }
        return comments.get(0);
    }
}
