package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DemoUtils Test")
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.Random.class)
class DemoUtilsTest {
    private static DemoUtils demoUtils;

    @BeforeAll
    static void beforeAll() {
//        System.out.println("@BeforeAll running..");
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Test Timeout")
    void testTimeoutPreemptively() {
        long seconds = 3;
        assertTimeoutPreemptively(Duration.ofSeconds(seconds),
                () -> demoUtils.checkTimeout(),
                String.format("Should execute in %d seconds", seconds));
    }

    @Test
    @DisplayName("Test Throws")
    void testThrows() {
        Class<Exception> exceptionClass = Exception.class;
        assertThrowsExactly(Exception.class, () -> demoUtils.throwException(- 5),
                String.format("Should throw exactly: %s", exceptionClass));
    }

    @Test
    @DisplayName("Test Does Not Throws")
    void testDoesNotThrows() {
        assertDoesNotThrow(() -> demoUtils.throwException(5), "Should not throw exception.");
    }

    @Test
    @DisplayName("Test Timeout")
    @Order(1)
    void testTimeout() {
        long seconds = 3;
        assertTimeout(Duration.ofSeconds(seconds),
                () -> demoUtils.checkTimeout(),
                String.format("Should execute in %d seconds", seconds));
    }

    @Test
    @DisplayName("Test Same")
    void testSame() {
        String str1 = "Hello";
        String str2 = "Hello";
        String address1 = ((Object) str1).toString();
        String address2 = ((Object) str2).toString();
        assertSame(str1, str2, String.format("%s should be the same as %s", address1, address2));
    }

    @Test
    @DisplayName("Test Not Same")
    void testNotSame() {
        String str1 = "Hello";
        String str2 = new String("Hello");
        String address1 = ((Object) str1).toString();
        String address2 = ((Object) str2).toString();
        assertNotSame(str1, str2, String.format("%s should be the same as %s", address1, address2));
    }

    @Test
    @DisplayName("Test Array Equals")
    void testArrayEquals() {
        String[] greetings = {"Hello", "Salam", "Ciao"};
        String[] greetingsEqual = {"Hello", "Salam", "Ciao"};
        assertArrayEquals(greetings, greetingsEqual,
                String.format("%s\nshould be equal to:\n%s",
                        Arrays.toString(greetings),
                        Arrays.toString(greetingsEqual)));
    }

    @Test
    @DisplayName("Test Array Deep Equals")
    void testArrayDeepEquals() {
        String[][][] greetings = {{{"Hello", "Salam", "Ciao"}}};
        String[][][] greetingsEqual = {{{"Hello", "Salam", "Ciao"}}};
        assertArrayEquals(greetings, greetingsEqual,
                String.format("%s\nshould be equal to:\n%s",
                        Arrays.toString(greetings),
                        Arrays.toString(greetingsEqual)));
    }

    @Test
    @DisplayName("Test Iterables Equals")
    void testIterablesEquals() {
        List<String> greetings = List.of("Hello", "Salam", "Ciao");
        List<String> greetingsEqual = List.of("Hello", "Salam", "Ciao");
        assertIterableEquals(greetings, greetingsEqual,
                String.format("%s\nshould be equal to:\n%s", greetings, greetingsEqual));
    }

    @Test
    @DisplayName("Test Lines Match")
    void testLinesMatch() {
        List<String> greetings = List.of("Hello", "Salam", "Ciao");
        List<String> greetingsEqual = List.of("Hello", "Salam", "Ciao");
        assertLinesMatch(greetings, greetingsEqual,
                String.format("%s\n matches:\n%s", greetings, greetingsEqual));
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {
//        System.out.println("Running test: testEqualsAndNotEquals");
        assertEquals(10, demoUtils.add(3, 7), "3 + 7 should be 10.");
        assertNotEquals(5, demoUtils.add(3, 4), "3 + 4 should not be 5.");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {
//        System.out.println("Running test: testEqualsAndNotEquals");
        assertNull(demoUtils.checkNull(null), "Object should be null.");
        assertNotNull(demoUtils.checkNull(new Object()), "Object should not be null.");
    }

    @Test
    void testMultiplyTrue() {
        assertTrue(demoUtils.isGreater(2, 1));
    }

    @Test
    void testMultiplyFalse() {
        assertFalse(demoUtils.isGreater(1, 1));
    }
    /*@AfterAll
    static void afterAll() {
        System.out.println("@AfterAll running..");
        demoUtils = null;
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach running..");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach running..");
    }*/ //@Before, @After

}