package com.ubs.opsit.interviews.junitformethod;
import org.junit.*;

import com.ubs.opsit.interviews.BerlinClock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testMinValidBerlinClock() {
        new BerlinClock().convertTime("00:00:00");
    }

    @Test
    public void testMaxValidBerlinClock() {
    	new BerlinClock().convertTime("23:59:59");
    }

    @Test
    public void testPrintClock() {
        BerlinClock clock = new BerlinClock();
        clock.convertTime("12:30:30");

        String expected = "Y\n" +
                "RROO\n" +
                "RROO\n" +
                "YYRYYROOOOO\n" +
                "OOOO\n";

        assertEquals(expected, outContent.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidHours() {
    	new BerlinClock().convertTime("25:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidMinutes() {
    	new BerlinClock().convertTime("00:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidSeconds() {
    	new BerlinClock().convertTime("00:00:60");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidHours() {
    	new BerlinClock().convertTime("-01:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidMinutes() {
    	new BerlinClock().convertTime("00:-01:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidSeconds() {
    	new BerlinClock().convertTime("00:00:-01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidString() {
    	new BerlinClock().convertTime("00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullString() {
    	new BerlinClock().convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyString() {
    	new BerlinClock().convertTime("");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
