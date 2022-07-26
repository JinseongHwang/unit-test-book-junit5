package me.study.unittest;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Example5_01 {

    @Mock
    IEmailGateway mock;

    @Test
    void Sending_a_greetings_email() throws Exception {
        // Given
        final String email = "user@email.com";
        final Controller sut = new Controller(mock);

        // When
        sut.greetUser(email);

        // Then
        then(mock).should(only()).sendGreetingsEmail(email);
    }
}
