package com.company;

import org.junit.*;

/**
 * Created by Sergey on 21.12.2015.
 */
public class TestCase1 {
    @BeforeClass
    public static void init() {
        System.out.println("Initialization. Create connection");
    }

    @Before
    public void beforeMethod() {
        System.out.println("Before method. Insert data to database");
    }

    @Test
    public void testMe() {
        System.out.println("Test Me!!!");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @Test
    public void test3() {
        System.out.println("Test III");
    }

    @After
    public void afterMethod() {
        System.out.println("After method. Delete all data in all tables");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Teardown. Close connection");
    }

}
