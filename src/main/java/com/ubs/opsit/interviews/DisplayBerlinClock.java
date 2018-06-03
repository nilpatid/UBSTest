package com.ubs.opsit.interviews;
import java.util.Arrays;
import java.util.Collections;


public class DisplayBerlinClock implements TimeConverter{

    private static final String NEW_LINE_CHAR = System.getProperty("line.separator");

    

	@Override
	public String convertTime(String time) {
        if(time == null) throw new IllegalArgumentException("Invalid Input");
        String[] times = time.split(":", 3);
        if(times.length != 3) throw new IllegalArgumentException("Invalid Input");
        int hours, minutes, seconds = 0;
       
        try {
            hours = Integer.parseInt(times[0]);
            minutes = Integer.parseInt(times[1]);
            seconds = Integer.parseInt(times[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Input");
        }

        if (hours < 0 || hours > 24) throw new IllegalArgumentException("Invalid Input");
        if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("Invalid Input");
        if (seconds < 0 || seconds > 59) throw new IllegalArgumentException("Invalid Input");

        return convertBerlinTime(hours, minutes, seconds);
    }

    
    private String convertBerlinTime(int hours, int minutes, int seconds) {

        String line1 = (seconds % 2 == 0) ? "Y" : "O";
        String line2 = buildRow(hours / 5, 4, "R");
        String line3 = buildRow(hours % 5, 4, "R");
        String line4 = buildRow(minutes / 5, 11, "Y").replaceAll("YYY", "YYR");
        String line5 = buildRow(minutes % 5, 4, "Y");

        return String.join(NEW_LINE_CHAR, Arrays.asList(line1, line2, line3, line4, line5));

    }
    
    private String buildRow(int onPoint, int rowMemberCnt, String color) {

        int offPoint = rowMemberCnt - onPoint;
        String on = String.join("", Collections.nCopies(onPoint, color));
        String off = String.join("", Collections.nCopies(offPoint, "O"));

        return on + off;
    }



}
