package ru.otus.assertions;

import java.util.ArrayList;
import java.util.List;

public class Assertions {
    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertCheckFunction(List<Integer> expected, int actual) {
        boolean conteins = false;
        for(int i = 0; i < expected.size(); i++){
            if(expected.get(i) == actual) {
               conteins = true;
            }
        }
        if (!conteins) {
            throw new AssertionError(expected +"<=" +actual);
        }
    }



    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }


    public static void assertEquals(Class<? extends Throwable> expected, Class<? extends Throwable> actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }

    public static void assertThrows(Class<? extends Throwable> expected, Runnable code) {
        Throwable actual = null;
        try {
            code.run();
        } catch (Throwable e) {
            actual = e;
        }
        if (actual == null) {
            throw new AssertionError("Given code does not throw any exception");
        }

        if (!actual.getClass().equals(expected)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected.getSimpleName(), actual.getClass().getSimpleName()));
        }
    }

}
