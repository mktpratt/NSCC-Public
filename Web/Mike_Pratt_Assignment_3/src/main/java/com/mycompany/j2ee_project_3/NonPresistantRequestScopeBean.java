/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.j2ee_project_3;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

 
@RequestScoped
@Named("requestBean")
public class NonPresistantRequestScopeBean {

    @Inject
    SharedApplicationSingleton sharedApplicationSingleton;
    @Inject
    PlayerManagedSessionBean playerManagedSessionBean;


    public NonPresistantRequestScopeBean() {
        logit.log("NonPresistantRequestScopeBean created");
    }
       
    
    private int count = 0;
    private int guess = 0;
    private String name = "";
    private String guessResponse = "no response";

    
    public String startGame()
    {
        
        playerManagedSessionBean.setUnigueIdentifer(sharedApplicationSingleton.getUnigueIdentifier());
        logit.log("Game# for player set to : " + playerManagedSessionBean.getUnigueIdentifer());
        if(this.sharedApplicationSingleton.startGame())
        {
            playerManagedSessionBean.setCount(0);
            return "PlayGame.xhtml";
        }
        else
            return "PlayGame.xhtml";
    }
    
    

    public String doCheck() {
            playerManagedSessionBean.incCount();
  
            
    if(playerManagedSessionBean.getUnigueIdentifer() == sharedApplicationSingleton.getUnigueIdentifier())
    {
        if (getGuess() == sharedApplicationSingleton.getNumberToGuess()) {
            if(!sharedApplicationSingleton.isDone)
            {
            // Guess is correct
            setGuessResponse("Correct Guess");
            // Set other Bean values to show this person won
            sharedApplicationSingleton.setName(playerManagedSessionBean.getName());
            sharedApplicationSingleton.setCount(playerManagedSessionBean.getCount());
            sharedApplicationSingleton.isDone = true;
            sharedApplicationSingleton.AddWinner (playerManagedSessionBean.getName(), playerManagedSessionBean.getCount());
            }
            else
            {
               setGuessResponse("Game has finished");
            }
        } else  if (getGuess() < sharedApplicationSingleton.getNumberToGuess()) {
            //Guess is wrong
            setGuessResponse("Too low!");
        }else  if (getGuess() > sharedApplicationSingleton.getNumberToGuess()) {
            //Guess is wrong
            setGuessResponse("Too high!");
        }
        incCount();
        logit.log("=================================");
        logit.log("NonPresistantRequestScopeBean: Name:" + getName() + " Guess:"+getGuess()+ "  Count:" + getCount() + " Response:" + getGuessResponse());
        logit.log("playerManagedSessionBean: Name:" + playerManagedSessionBean.getName() +" Count:" + playerManagedSessionBean.getCount());
        logit.log("sharedApplicationSingleton: " + sharedApplicationSingleton.getName() + " Count:" + sharedApplicationSingleton.getCount() + " Guess This:" + sharedApplicationSingleton.getNumberToGuess());
        logit.log("=================================");

        if(!this.sharedApplicationSingleton.isDone){
            return "PlayGame.xhtml";
        } else{
            return "GameOver.xhtml";
        }
    }else 
    {
        logit.log("old game detected by id ending game");
        return "GameOver.xhtml";
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
        this.count = count;
    }
    
    public void incCount() {
        this.count++;
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
     * @return the guess
     */
    public int getGuess() {
        return guess;
    }

    /**
     * @param guess the guess to set
     */
    public void setGuess(int guess) {
        this.guess = guess;
    }

    /**
     * @return the guessResponse
     */
    public String getGuessResponse() {
        return guessResponse;
    }

    /**
     * @param guessResponse the guessResponse to set
     */
    public void setGuessResponse(String guessResponse) {
        this.guessResponse = guessResponse;
    }
}
