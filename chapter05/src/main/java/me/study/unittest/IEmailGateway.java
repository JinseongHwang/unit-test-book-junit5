package me.study.unittest;

public interface IEmailGateway {

    void sendGreetingsEmail(String userEmail);

    void sendReceipt(String email, String productName, int quantity);
}
