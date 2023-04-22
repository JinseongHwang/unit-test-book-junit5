package me.study.unittest;

public class Precondition {

    public static void requires(boolean precondition, String message) throws Exception {
        if (precondition == false) {
            throw new Exception(message);
        }
    }

    public static void requires(boolean precondition) throws Exception {
        requires(precondition, null);
    }
}
