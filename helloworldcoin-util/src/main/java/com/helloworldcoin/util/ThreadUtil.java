package com.helloworldcoin.util;

/**
 *
 * @author x.king xdotking@gmail.com
 */
public class ThreadUtil {

    public static void millisecondSleep(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (Exception e) {
            throw new RuntimeException("sleep failed.",e);
        }
    }
}
