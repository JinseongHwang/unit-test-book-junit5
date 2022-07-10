package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class Example1_1_v1 {

    public static boolean isStringLong(String input) {
        if (input.length() > 5) {
            return true;
        }
        return false;
    }

    @Test
    void test() throws Exception {
        boolean result = isStringLong("abc");
        assertFalse(result);
    }
}
