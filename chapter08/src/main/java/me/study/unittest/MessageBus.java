package me.study.unittest;

public class MessageBus {

    private Bus bus;

    public void sendEmailChangeMessage(int userId, String newEmail) {
        bus.send(String.format("Subject: USER; Type: EMAIL CHANGED; Id: %d; NewEmail: %s", userId, newEmail));
    }
}
