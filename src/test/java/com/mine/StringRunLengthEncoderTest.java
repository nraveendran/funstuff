package com.mine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringRunLengthEncoderTest {

    @Test public void testRunLegthEncoder() throws Exception {

        StringRunLengthEncoder stringRunLengthEncoder = new StringRunLengthEncoder();
        assertEquals("4a2b", stringRunLengthEncoder.encode("aaaabb"));

        assertEquals("4a3b1z", stringRunLengthEncoder.encode("aaaabbbz"));

        assertEquals("1a", stringRunLengthEncoder.encode("a"));

    }

}