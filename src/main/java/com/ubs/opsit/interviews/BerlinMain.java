package com.ubs.opsit.interviews;
public class BerlinMain {

    public static void main(String[] args) {

        TimeConverter clock = new DisplayBerlinClock();

        System.out.println("#### converted Berlin Clock ####");
        System.out.println(clock.convertTime(args[0]));
    }

}
