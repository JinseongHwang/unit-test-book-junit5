package me.study.unittest;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;

import org.junit.jupiter.api.Test;

public class Example6_03 {

    @Test
    void Sending_a_greeting_email() throws Exception {
        // Given
        final String userEmail = "user@userEmail.com";
        final IEmailGateway emailGatewayMock = mock(IEmailGateway.class);
        final Controller sut = new Controller(emailGatewayMock);

        // When
        sut.greetUser(userEmail);

        // Then
        then(emailGatewayMock).should(only()).sendGreetingsEmail(userEmail);
    }
}
