
package main;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
 
@ManagedBean(eager = true)
@ApplicationScoped


public class AppScope {

    // game variables
    private int guess;
    private int minGuess = 0;
    private int maxGuess = 1000;
    
    // protected String lastWinner = null;
    private String lastWinnerName= "No one has one yet";
    protected int lastWinnerScore = 0;  
    protected ArrayList winner = new ArrayList();
  
    // used to track the game acreoos sessions
    protected int gameId = 0 ; 
    
    // Flag used to restart ghame
    private boolean isDone = true;
   
    Random r = new Random();
 
 
    
    /**
     * starts the game or returns false if game is already in progress
     * @return boolean
     */
    public boolean startGame()
    {
        try
        {
            if(this.isIsDone())
            {
               this.guess = r.nextInt(this.maxGuess-this.minGuess) + this.minGuess;
                
               this.isDone=false;
               logit.log("startGame(): The answer is: " + guess);
               return true;
            }else
            {
                logit.log("startGame(): Answer is: " + guess +" - Joining already exising game");
            }
            return false;
        }
        catch(Exception e)
        {
            logit.log("startGame() E : " + e.toString());
            return false;
        }
    }
    
     public String checkguess(int gameId, int guessed_number, int points , String name)
    {
        try
        {
            // make sure the game id's match 
            if(gameId != this.gameId ||this.isDone)
                return "";

           String guessResponse;
           guessResponse = null;
           logit.log("Before name: " + name + "  Guess: " + guessed_number);

           // response depending on the guess
           if (guessed_number > this.guess) {
               guessResponse = "Too high!";
           }
           if (guessed_number < this.guess) {
               guessResponse = "Too low!";
           }
           if (guessed_number == this.guess ) {
               guessResponse = "YOU WIN!";
               logit.log("Game won by " + name);
            
               this.isDone = true;
               this.gameId++;
               this.lastWinnerScore = points;
               this.lastWinnerName = name;
            
               // add the winner to the winners array
               this.winner.add(new winner(name,points));

               int i =0;
                for (Object winner1 : this.winner) {
                    winner temp = (winner) winner1;
                    logit.log("Winner: " + i + "   = " + temp.getName() + " Score: " +  temp.getScore())  ;
                    i++;
                }
           }
           logit.log("checkguess() in AppScope - After name: " + name + " Guess: " + guessed_number + "  Points: " + guessResponse);
           return guessResponse;
        
        }catch(Exception e)
        {
            logit.log("checkguess() : " + e.toString());
        }
    return null;
    }   
        
    public int getGuesss()
    {
        return this.getGuess();
    }

    /**
     * @return the guess
     */
    public int getGuess() {
        return guess;
    }

    /**
     * @return the minGuess
     */
    public int getMinGuess() {
        return minGuess;
    }

    /**
     * @param minGuess the minGuess to set
     */
    public void setMinGuess(int minGuess) {
        this.minGuess = minGuess;
    }

    /**
     * @return the maxGuess
     */
    public int getMaxGuess() {
        return maxGuess;
    }

    /**
     * @param maxGuess the maxGuess to set
     */
    public void setMaxGuess(int maxGuess) {
        this.maxGuess = maxGuess;
    }
    
    public  ArrayList   getAllWinnersAsArrayList()
    {
        return  this.winner;
    }

    /**
     * @return the isDone
     */
    public boolean isIsDone() {
        return isDone;
    }

    /**
     * @param isDone the isDone to set
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * @return the lastWinnerName
     */
    public String getLastWinnerName() {
        return this.lastWinnerName;
    }

    /**
     * @param lastWinnerName the lastWinnerName to set
     */
    public void setLastWinnerName(String lastWinnerName) {
        this.lastWinnerName = lastWinnerName;
    }
}
