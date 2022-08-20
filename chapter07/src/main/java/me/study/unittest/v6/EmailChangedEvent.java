package me.study.unittest.v6;

import java.util.Objects;
import lombok.Getter;

@Getter
public class EmailChangedEvent {

    public int userId;
    public String newEmail;

    public EmailChangedEvent(int userId, String newEmail) {
        this.userId = userId;
        this.newEmail = newEmail;
    }

    protected boolean equals(EmailChangedEvent other) {
        return this.userId == other.getUserId() &&
               this.newEmail.equals(other.getNewEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmailChangedEvent that = (EmailChangedEvent)o;
        return userId == that.userId && newEmail.equals(that.newEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, newEmail);
    }
}
