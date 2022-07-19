package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Example4_6 {

    @Test
    void getById_executes_correct_SQL_code() throws Exception {
        // Given
        final UserRepository sut = new UserRepository();

        // When
        final User user = sut.getById(5);

        // Then
        assertThat(sut.getLastExecutedSqlStatement()).isEqualTo("dummy SQL");
    }
}
