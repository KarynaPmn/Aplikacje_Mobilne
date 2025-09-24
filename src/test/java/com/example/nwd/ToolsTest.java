package com.example.nwd;

import junit.framework.TestCase;
public class ToolsTest extends TestCase {
    Tools t;

    public void setUp() throws Exception {
        super.setUp();
        t = new Tools();
    }

    public void testNWD() {
        int w = t.NWD(12, 16);
        assertEquals(4, w);
    }

    public void testSumaCyfr() {
        int w = t.SumaCyfr(123);
        assertEquals(6, w);
    }
}