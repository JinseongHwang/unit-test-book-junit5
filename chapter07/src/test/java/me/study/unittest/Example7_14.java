package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import me.study.unittest.v6.Company;
import me.study.unittest.v6.EmailChangedEvent;
import me.study.unittest.v6.User;
import org.junit.jupiter.api.Test;

public class Example7_14 {

    @Test
    void Changing_email_from_corporate_to_non_corporate() throws Exception {
        // Given
        final Company company = new Company("mycorp.com", 1);
        final User sut = new User(1, "user@mycorp.com", UserType.EMPLOYEE, false);

        // When
        sut.changeEmail("new@gmail.com", company);

        // Then
        assertThat(company.getNumberOfEmployees()).isEqualTo(0);
        assertThat(sut.getEmail()).isEqualTo("new@gmail.com");
        assertThat(sut.getType()).isEqualTo(UserType.CUSTOMER);
        assertThat(sut.getEmailChangedEvents()).containsExactly(
            new EmailChangedEvent(1, "new@gmail.com")
        );
    }
}
