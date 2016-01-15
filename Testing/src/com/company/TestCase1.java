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
        /*
        Call service method that should return mapped objects;
        E.g. in database we have 1 person with 2 cars and class structure described below.
        Person {
            private List<Car>
            private String FIO;
            ...
        }
        Car{
            private String number;
            private String tradeMark;
            ...
        }

        In THEN part we should check all data in all fields
         */
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
