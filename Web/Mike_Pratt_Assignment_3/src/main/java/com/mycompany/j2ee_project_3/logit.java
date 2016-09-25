/*
 * logit: A handy logging utility, that can 
 * be extended to log timestamp and other handy 
 * bits.
 */
package com.mycompany.j2ee_project_3;

/**
 *
 * @author J2EE
 */
public class logit {

    public void logit() {
        //Constructor not called if using static version
        // if static, open log file if necessary when logging
        System.out.println("Start logging");
    }

    private static int logNumber = 0;

    public static void log(String textToLog) {
        
        // if using a log file, open it, if not opened already
        // if you want to log a deployed J2EE applicaion
        // then create a log file naming process so you don't
        // overwrite logs.
        
        // logs from your deployed system are critical to finding errors 
        // that are near impossible to find otherwise.
        
        logNumber++;
        System.out.println("log # " + logNumber + " # " + textToLog);
    }
}
