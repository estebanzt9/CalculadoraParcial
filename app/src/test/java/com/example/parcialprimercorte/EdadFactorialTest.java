package com.example.parcialprimercorte;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdadFactorialTest {

    @Test
    public void factorial() {

        // Test para n = 1
        assertEquals("1", EdadFactorial.factorial(1, 1));

        // Test para n = 2
        assertEquals("2", EdadFactorial.factorial(2, 1));

        // Test para n = 3

        assertEquals("6", EdadFactorial.factorial(3, 1));

        // Test para n = 4
        assertEquals("24", EdadFactorial.factorial(4, 1));

        // Test para n = 5
        assertEquals("12", EdadFactorial.factorial(5, 1));

    }
}