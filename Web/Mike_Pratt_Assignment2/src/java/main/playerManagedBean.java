
package main;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped      // this scope lasts as long as the user is logged in
public class playerManagedBean implements Serializable {

    // game variables
    private int guessed_number;
    private int points = 0;
    private int minGuess;
    private int maxGuess;
    private int winnerScore = 0;
    
  
    private String winner; 
    private String winnerString = "";
    private String name = "";
    
    // holds responose from the game
    private String guessResponse = "";
    
    
    // trach the game id to ensure sync
    private int gameId = 0;  
 
    
    /**
     * Creates a new instance of playerManagedBean
     */
    public playerManagedBean() {
        
    }

    public String startplayer() {
        this.points=0;

        /// launches a new game if one isnt launced already
        if (this.appscope.isIsDone())
        {
            logit.log("startplayer() : relaunching game");
            this.appscope.startGame();  
        }
 
        this.gameId = appscope.gameId;
          logit.log("startplayer() : STARTING GAME");
          logit.log("startplayer() : Name: " + this.name + "  Guess: " + this.guessed_number + "  Points: " + this.points);
        this.setMaxGuess(appscope.getMaxGuess());
        this.setMinGuess(appscope.getMinGuess());
        
        // check for a previous winner and update the bean variabels
        if(!this.appscope.getLastWinnerName().equals(""))
        {
            this.winner = this.appscope.getLastWinnerName();
            this.winnerScore = this.appscope.lastWinnerScore;
            logit.log("startplayer() : previous winner found");
            logit.log("startplayer() : Name: " + this.winner + "  Score: " + this.winnerScore);
        }
        else
        {
            logit.log("startplayer() : No winner found");
            this.winnerString = "No one";
        }
        this.winnerScore = appscope.lastWinnerScore;      
        return "PlayGame.xhtml";
    }

    public String checkguess() {
       logit.log("Before name: " + this.name + "  Guess: " + this.guessed_number + "  Points: " + this.points);
       this.points ++;
       this.guessResponse =  this.appscope.checkguess(this.gameId, this.guessed_number,this.points,this.name);
       logit.log("After name: " + this.name + "  Guess: " + this.guessed_number + "  Points: " + this.points);
       if(guessResponse.equals(""))
       {
           this.points = 0;
           this.winnerScore = this.getWinnerScore();
           this.winner = this.appscope.getLastWinnerName();
           return "GameOver.xhtml";
       }
       return "PlayGame.xhtml";
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
     * @return the guessed_number
     */
    public int getGuessed_number() {
        return guessed_number;
    }

    /**
     * @param guessed_number the guessed_number to set
     */
    public void setGuessed_number(int guessed_number) {
        this.guessed_number = guessed_number;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the guessResponse
     */
    public String getGuessResponse() {
        return guessResponse;
    }

    // insert appscope
    @ManagedProperty("#{appScope}")
    protected AppScope appscope;
    
    
    public void setAppscope(AppScope appscope)
    {
        this.appscope = appscope;
    }
    
    public AppScope getAppscope()
    {
        return  this.appscope ;
    }
    
    public String getWinner()
    {
          return this.winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * @return the gameId
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * @param gameId the gameId to set
     */
    public void setGameId(int gameId) {
        this.gameId = gameId;
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

    /**
     * @return the winnerScore
     */
    public int getWinnerScore() {
        return winnerScore;
    }

    /**
     * @param winnerScore the winnerScore to set
     */
    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    /**
     * @return the winnerString
     */
    public ArrayList getWinnersArrayList(){
        return this.appscope.getAllWinnersAsArrayList();
    }

    /**
     * @param winnerString the winnerString to set
     */
    public void setWinnerString(String winnerString) {
        this.winnerString = winnerString;
    }
    
}
