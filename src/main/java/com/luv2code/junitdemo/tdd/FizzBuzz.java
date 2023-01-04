package com.luv2code.junitdemo.tdd;

public class FizzBuzz {
    private final static String fizzBuzz = "FizzBuzz";
    private final static String fizz = "Fizz";
    private final static String buzz = "Buzz";
    public static String compute(int num) {
        if (num % 3 == 0) {
            if (num % 5 == 0) return fizzBuzz;
            return fizz;
        }
        else if (num % 5 == 0) {
            return buzz;
        }
        else {
            return String.valueOf(num);
        }
    }
}
