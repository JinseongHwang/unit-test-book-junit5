package me.study.unittest.v1;

import me.study.unittest.IBus;

public class MessageBus {

    private static IBus bus;

    public static void sendEmailChangeMessage(int userId, String newEmail) {
        bus.send(String.format("Subject: USER; Type: EMAIL CHANGED; Id: %d; NewEmail: %s", userId, newEmail));
    }
}
