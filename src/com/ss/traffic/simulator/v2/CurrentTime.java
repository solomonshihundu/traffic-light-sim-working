package com.ss.traffic.simulator.v2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime implements Runnable {

    private boolean isRunning;
    private String timePattern = "hh:mm:ss a";
    private SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
    Date date = new Date(System.currentTimeMillis());

    public CurrentTime() {
        this.isRunning = Thread.currentThread().isAlive();
    }

    public String getTime() {
        date = new Date(System.currentTimeMillis());
        return timeFormat.format(date);
    }

    @Override
    public void run() {
        //While running, constantly update current time
        while (isRunning) {

            Main.timeTxt.setText(getTime());
        }
    }

}
