package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.OS.WINDOWS;

class ConditionalTest {

    @Test
    @Disabled("Issue #10 not closed yet.")
    void basicTest() {

    }

    @Test
    @EnabledOnOs(value = WINDOWS, disabledReason = "Only Windows OS supports the operation")
    void testForWindowsOnly() {
    }

    @Test
    @EnabledOnJre(value = JRE.JAVA_8, disabledReason = "Methods which were deprecated after JAVA8 used.")
    void testForJava8Only() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_10, disabledReason = "Java 8 features used.") //by default => min =  JRE.JAVA_8
    void testForMinJava10() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV", disabledReason = "Only for dev purposes.")
    void testForDevEnv() {
    }

    @Test
    @EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP", matches = "CI_CD_DEPLOY", disabledReason = "Only for deploy.")
    void testForSysProp() {
    }
}
