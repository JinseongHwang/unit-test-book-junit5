package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Example4_5 {

    @Test
    void test() throws Exception {
        // Given
        final User sut = new User();

        // When
        sut.setName("John Smith");

        // Then
        assertThat(sut.getName()).isEqualTo("John Smith");
    }
}
