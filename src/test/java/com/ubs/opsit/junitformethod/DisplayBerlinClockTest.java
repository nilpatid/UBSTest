package com.ubs.opsit.junitformethod;
import org.junit.*;

import com.ubs.opsit.interviews.DisplayBerlinClock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DisplayBerlinClockTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testMinValidBerlinClock() {
        new DisplayBerlinClock().convertTime("00:00:00");
    }

    @Test
    public void testMaxValidBerlinClock() {
    	new DisplayBerlinClock().convertTime("23:59:59");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidHours() {
    	new DisplayBerlinClock().convertTime("25:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidMinutes() {
    	new DisplayBerlinClock().convertTime("00:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidSeconds() {
    	new DisplayBerlinClock().convertTime("00:00:60");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidHours() {
    	new DisplayBerlinClock().convertTime("-01:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidMinutes() {
    	new DisplayBerlinClock().convertTime("00:-01:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidSeconds() {
    	new DisplayBerlinClock().convertTime("00:00:-01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidString() {
    	new DisplayBerlinClock().convertTime("00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullString() {
    	new DisplayBerlinClock().convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyString() {
    	new DisplayBerlinClock().convertTime("");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
