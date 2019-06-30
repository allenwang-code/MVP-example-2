package com.mvp.example.util;

import org.junit.Test;

import static org.junit.Assert.*;


public class DateTimeUtilTest {

    @Test
    public void testLocalTimeConvertsToTheCorrectDateFormate() {
        String originalDate = "2017-11-25T22:00:00";

        String newDate = DateTimeUtil.convertDate(originalDate);

        assertEquals("Sat Nov 25 2017 22:00", newDate);
    }

}