package com.luv2code.junitdemo.tdd;

public class FizzBuzz {
    public static String compute(int num) {
        if (num % 3 == 0) {
            return "Fizz";
        }
        else if (num % 5 == 0) {
            return "Buzz";
        }
        return null;
    }
}
