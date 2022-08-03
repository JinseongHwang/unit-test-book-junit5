package me.study.unittest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Article {

    private final List<Comment> comments = new ArrayList<>();

    public List<Comment> comments() {
        return Collections.unmodifiableList(comments);
    }

    public void addComment(String text, String author, LocalDateTime now) {
        comments.add(new Comment(text, author, now));
    }

    public Article shouldContainNumberOfComments(int i) {
        return this;
    }
}
