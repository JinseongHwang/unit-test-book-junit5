package me.study.unittest;

import java.util.Objects;
import lombok.Getter;

@Getter
public class EmailChangedEvent {

    private int userId;
    private String newEmail;

    public EmailChangedEvent(int userId, String newEmail) {
        this.userId = userId;
        this.newEmail = newEmail;
    }

    protected boolean equals(EmailChangedEvent other) {
        return this.userId == other.userId &&
               this.newEmail.equals(other.newEmail);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((EmailChangedEvent)obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, newEmail);
    }
}
