package com.luv2code.junitdemo.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @Test
    @DisplayName("Divisible by both 3 and 5")
    @Order(3)
    void testDivisibleByBothThreeAndFive() {
        String expected = "FizzBuzz";
        int num = 15;
        assertEquals(expected, FizzBuzz.compute(num), "Should return FizzBuzz");
    }

    @Test
    @DisplayName("Not divisible by both 3 and 5")
    @Order(4)
    void testNotDivisibleByBothThreeAndFive() {
        int num = 13;
        String expected = String.valueOf(num);
        assertEquals(expected, FizzBuzz.compute(num), String.format("Should return the number itself: %d", num));
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/large-test-data.csv", "/medium-test-data.csv", "/small-test-data.csv"})
    @DisplayName("Test Against Small csv file")
    @Order(5)
    void testAgainstCsvFile(int num, String expected) {
        assertEquals(expected, FizzBuzz.compute(num));
    }
}
