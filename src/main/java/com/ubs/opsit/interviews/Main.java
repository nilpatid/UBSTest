package com.ubs.opsit.interviews;
public class Main {

    public static void main(String[] args) {

        TimeConverter clock = new BerlinClock();

        System.out.println("====== Berlin Clock ======");
        System.out.println(clock.convertTime(args[0]));
        System.out.println("==========================");
        System.out.println("==========================");
    }

}
