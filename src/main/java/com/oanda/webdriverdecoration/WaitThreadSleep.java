package com.oanda.webdriverdecoration;

/**
 * Created by Evgeny  on 04.04.2016 7:43
 * .
 */
public class WaitThreadSleep {

    public static void waitForSomeTime(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
