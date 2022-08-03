package me.study.unittest;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {

    public final String text;
    public final String author;
    public final LocalDateTime dateCreated;

    public Comment(String text, String author, LocalDateTime dateCreated) {
        this.text = text;
        this.author = author;
        this.dateCreated = dateCreated;
    }

    public boolean equals(Comment comment) {
        return text.equals(comment.text) &&
               author.equals(comment.author) &&
               dateCreated.equals(comment.dateCreated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment)o;
        return text.equals(comment.text) &&
               author.equals(comment.author) &&
               dateCreated.equals(comment.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, author, dateCreated);
    }
}
