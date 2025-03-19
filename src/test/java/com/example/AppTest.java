package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void linesAreEqual() {
        assertTrue("aaa".equals("aaa"));
    }
}
