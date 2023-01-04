package com.luv2code.junitdemo.tdd;

import com.luv2code.junitdemo.tdd.FizzBuzz;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
    @Test
    @DisplayName("Divisible by 3")
    @Order(1)
    void testDivisibleByThree() {
        String expected = "Fizz";
        int num = 3;
        assertEquals(expected, FizzBuzz.compute(num), "Should return Fizz");
    }

    @Test
    @DisplayName("Divisible by 5")
    @Order(2)
    void testDivisibleByFive() {
        String expected = "Buzz";
        int num = 5;
        assertEquals(expected, FizzBuzz.compute(num), "Should return Buzz");
    }
}
