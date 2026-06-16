package com.example.junit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
    

    List<String> tools = Arrays.asList("Selenium", "QTP", "TestComplete");
    @Test
    void test() {
        // fail("Not yet implemented");
        boolean test = tools.contains("Selenium");
        boolean test2 = tools.contains("Appium");

        assertEquals(true, test);
        assertTrue( "Selenium is in the list", test);
        assertFalse("Appium is not in the list", test2);
        assertEquals(3, tools.size(), "List size should be 3");

        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 3});
    }

}
