/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.j2ee_project_4a;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clone38
 */
@Stateless
public class GuessesFacade extends AbstractFacade<Guesses> {
    @PersistenceContext(unitName = "com.mycompany_J2EE_Project_4a_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuessesFacade() {
        super(Guesses.class);
    }
    
}
