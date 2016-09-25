package com.mycompany.j2ee_project_3;

import java.util.ArrayList;
import java.util.Random;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named
public class SharedApplicationSingleton {

    private int count = 0;
    private int numberToGuess;
    private String name = "Singleton";
    public  boolean isDone = true;  
    public final int MAXGUESS = 1000;
    public final int MINGUESS = 0;
    String Winner = "";
    private ArrayList WinnersArrayList = new ArrayList();
    Random random = new Random();
    String lastWinner = "";
    
    public SharedApplicationSingleton() {
        logit.log("Shared application singleton created");
    }
    
    private int unigueIdentifier = 0;
    
      public boolean startGame()
     {       
        try
        {
            if(this.isDone)
            {
               this.numberToGuess = random.nextInt(this.MAXGUESS - this.MINGUESS) + this.MINGUESS;
               setUnigueIdentifier(getUnigueIdentifier() + 1);
               logit.log("Game number set to : " + unigueIdentifier);
               logit.log("startGame(): Starting a new game - Answer was: " + numberToGuess);
               this.isDone = false;
               return true;
            }
            else
            {
                logit.log("startGame()  : Answer is " + numberToGuess +" - Joining already exising game");
                logit.log("Game number is : " + unigueIdentifier);
            }
            return false;
        }
        catch(Exception e)
        {
            logit.log("startGame() E : " + e.toString());
            return false;
        }
    }
    
    
    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
           logit.log("Set Last winner count  : " + count);
           this.count = count;
           logit.log("Last winner count is now  : " + this.count);
    }

    public void incCount() {
        this.count++;
    }

    /**
     * @return the name
     */
    public String getName() {
        return getLastWinner();
    }
    
    public String getLastWinner(){
        if (this.lastWinner.isEmpty())
             return "Who will be the first to win??";
        else 
           return this.lastWinner;
    }
    

    /**
     * @param name the name to set
     */
    public void setName(String name) {
         logit.log("Setting winers name in singleton");
        this.name = name;
          this.lastWinner = name;
           logit.log("Last winner is now  : " + this.lastWinner);
    }

    /**
     * @return the numberToGuess
     */
    public int getNumberToGuess() {
        return numberToGuess;
    }

    /**
     * @param numberToGuess the numberToGuess to set
     */
    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

     public void AddWinner(String name, int score){
         WinnersArrayList.add(new Winner(name,score));
         logit.log("Winners array size : " + this.WinnersArrayList.size());
     }
    
    
    
    /**    public void AddWinner(String name, int score)
     * @return the WinnersArrayList
     */
    public ArrayList getWinnersArrayList() {
        return WinnersArrayList;
    }

    /**
     * @param WinnersArrayList the WinnersArrayList to set
     */
    public void setWinnersArrayList(ArrayList WinnersArrayList) {
        this.WinnersArrayList = WinnersArrayList;
    }

    /**
     * @return the unigueIdentifier
     */
    public int getUnigueIdentifier() {
        return unigueIdentifier;
    }

    /**
     * @param unigueIdentifier the unigueIdentifier to set
     */
    public void setUnigueIdentifier(int unigueIdentifier) {
        this.unigueIdentifier = unigueIdentifier;
    }

}
