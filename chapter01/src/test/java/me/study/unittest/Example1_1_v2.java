package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class Example1_1_v2 {

    public static boolean isStringLong(String input) {
        return input.length() > 5;
    }

    @Test
    void test() throws Exception {
        boolean result = isStringLong("abc");
        assertFalse(result);
    }
}
