package com.ubs.opsit.interviews.junitformethod;
import org.junit.*;

import com.ubs.opsit.interviews.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testMain() {

        String[] args = {"12:30:30"};

        Main.main(args);

        String expected = "====== Berlin Clock ======\n" +
                "Y\n" +
                "RROO\n" +
                "RROO\n" +
                "YYRYYROOOOO\n" +
                "OOOO\n" +
                "==========================\n";

        assertEquals(expected, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
