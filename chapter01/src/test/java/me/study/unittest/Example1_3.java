package me.study.unittest;

import org.junit.jupiter.api.Test;

public class Example1_3 {

    public static boolean isStringLong(String input) {
        return input.length() > 5;
    }

    @Test
    void test() throws Exception {
        boolean result1 = isStringLong("abc");
        boolean result2 = isStringLong("abcdef");
    }
}
