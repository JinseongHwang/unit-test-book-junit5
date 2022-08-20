package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import me.study.unittest.v4.Company;
import me.study.unittest.v4.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Chapter 7.3
public class Tests {

    @Test
    void Changing_email_without_changing_user_type() throws Exception {
        // Given
        Company company = new Company("mycorp.com", 1);
        User sut = new User(1, "user@mycorp.com", UserType.EMPLOYEE);

        // When
        sut.changeEmail("new@mycorp.com", company);

        // Then
        assertThat(company.getNumberOfEmployees()).isEqualTo(1);
        assertThat(sut.getEmail()).isEqualTo("new@mycorp.com");
        assertThat(sut.getType()).isEqualTo(UserType.EMPLOYEE);
    }

    @Test
    void Changing_email_from_corporate_to_non_corporate() throws Exception {
        // Given
        Company company = new Company("mycorp.com", 1);
        User sut = new User(1, "user@mycorp.com", UserType.EMPLOYEE);

        // When
        sut.changeEmail("new@gmail.com", company);

        // Then
        assertThat(company.getNumberOfEmployees()).isEqualTo(0);
        assertThat(sut.getEmail()).isEqualTo("new@gmail.com");
        assertThat(sut.getType()).isEqualTo(UserType.CUSTOMER);
    }

    @Test
    void Changing_email_from_non_corporate_to_corporate() throws Exception {
        // Given
        Company company = new Company("mycorp.com", 1);
        User sut = new User(1, "user@gmail.com", UserType.CUSTOMER);

        // When
        sut.changeEmail("new@mycorp.com", company);

        // Then
        assertThat(company.getNumberOfEmployees()).isEqualTo(2);
        assertThat(sut.getEmail()).isEqualTo("new@mycorp.com");
        assertThat(sut.getType()).isEqualTo(UserType.EMPLOYEE);
    }

    @Test
    void Changing_email_to_the_same_one() throws Exception {
        // Given
        Company company = new Company("mycorp.com", 1);
        User sut = new User(1, "user@gmail.com", UserType.CUSTOMER);

        // When
        sut.changeEmail("user@gmail.com", company);

        // Then
        assertThat(company.getNumberOfEmployees()).isEqualTo(1);
        assertThat(sut.getEmail()).isEqualTo("user@gmail.com");
        assertThat(sut.getType()).isEqualTo(UserType.CUSTOMER);
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void Differentiates_a_corporate_email_from_non_corporate(
        String domain, String email, boolean expectedResult
    ) throws Exception {
        // Given
        Company sut = new Company(domain, 0);

        // When
        boolean isEmailCorporate = sut.isEmailCorporate(email);

        // Then
        assertThat(isEmailCorporate).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("mycorp.com", "email@mycorp.com", true),
            Arguments.of("mycorp.com", "email@gmail.com", false)
        );
    }
}
