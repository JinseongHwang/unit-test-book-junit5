package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Example3_05 {

    @Test
    void Sum_of_two_numbers() throws Exception {
        double first = 10;
        double second = 20;
        final Calculator sut = new Calculator();

        final double result = sut.sum(first, second);

        assertEquals(30, result);
    }
}
