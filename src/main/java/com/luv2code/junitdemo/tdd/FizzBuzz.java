package com.luv2code.junitdemo.tdd;

public class FizzBuzz {
    private final static String fizz = "Fizz";
    private final static String buzz = "Buzz";
    private final static String fizzBuzz = "FizzBuzz";

    public static String compute(int num) {
        StringBuilder result = new StringBuilder();
        if (num % 3 == 0) {
            result.append(fizz);
        }
        if (num % 5 == 0) {
            result.append(buzz);
        }
        if (result.isEmpty()) {
            result.append(num);
        }
        return result.toString();
    }
    
    private static String compute2(int num) {
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
