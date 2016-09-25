
package com.mycompany.j2ee_project_3;

import java.util.Calendar;



public class Winner {
    
    public Winner(String name, int score){
        this.name = name;
        this.score = score;
        // 1) create a java calendar instance
        Calendar calendar = Calendar.getInstance();
 
        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        java.util.Date now = calendar.getTime();
 
        // 3) a java current time (now) instance
        java.sql.Timestamp dateTime = new java.sql.Timestamp(now.getTime());
        this.timestamp = "" + dateTime;
    }
    
    private String name;
    private int score;
    private String timestamp;

    /**
     * @return the time
     */
    public String getTimestamp() {
        return timestamp;
    }
    
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
}
