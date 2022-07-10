package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class Example1_2 {

    public static boolean wasLastStringLong;

    public static boolean isStringLong(String input) {
        boolean result = input.length() > 5;
        wasLastStringLong = result;
        return result;
    }

    @Test
    void test() throws Exception {
        boolean result = isStringLong("abc");
        assertFalse(result);
    }
}
