/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.j2ee_project_3;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
 

@Named("PlayerBean")
@SessionScoped
public class PlayerManagedSessionBean implements Serializable {

    private String name = "";
    private int count;

    public PlayerManagedSessionBean() {
        logit.log("Player Managed Bean Created");
    }

    private int  unigueIdentifer;
    
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
        logit.log("PlayerManagedSessionBean Name Set : " + name );
    }

    /**
     * @return the guesses
     */
    public int getCount() {
        return count;
    }

    /**
     * @param guesses the guesses to set
     */
    public void setCount(int guesses) {
        this.count = guesses;
    }

    public void incCount() {
        this.count++;
    }

    /**
     * @return the unigueIdentifer
     */
    public int getUnigueIdentifer() {
        return unigueIdentifer;
    }

    /**
     * @param unigueIdentifer the unigueIdentifer to set
     */
    public void setUnigueIdentifer(int unigueIdentifer) {
        this.unigueIdentifer = unigueIdentifer;
    }
}
