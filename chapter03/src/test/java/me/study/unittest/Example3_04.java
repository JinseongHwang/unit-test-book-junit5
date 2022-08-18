package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Example3_04 {

    @Test
    void Sum_of_two_numbers() throws Exception {
        // Given
        double first = 10;
        double second = 20;
        final Calculator sut = new Calculator();

        // When
        final double result = sut.sum(first, second);

        // Then
        assertEquals(30, result);
    }
}
