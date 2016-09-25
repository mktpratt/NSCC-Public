/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.j2ee_project_4a;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clone38
 */
@Entity
@Table(name = "GUESSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guesses.findAll", query = "SELECT g FROM Guesses g"),
    @NamedQuery(name = "Guesses.findByName", query = "SELECT g FROM Guesses g WHERE g.name = :name"),
    @NamedQuery(name = "Guesses.findByGuesscount", query = "SELECT g FROM Guesses g WHERE g.guesscount = :guesscount"),
    @NamedQuery(name = "Guesses.findByGuessed", query = "SELECT g FROM Guesses g WHERE g.guessed = :guessed")})
public class Guesses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GUESSCOUNT")
    private short guesscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GUESSED")
    private short guessed;

    public Guesses() {
    }

    public Guesses(String name) {
        this.name = name;
    }

    public Guesses(String name, short guesscount, short guessed) {
        this.name = name;
        this.guesscount = guesscount;
        this.guessed = guessed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getGuesscount() {
        return guesscount;
    }

    public void setGuesscount(short guesscount) {
        this.guesscount = guesscount;
    }

    public short getGuessed() {
        return guessed;
    }

    public void setGuessed(short guessed) {
        this.guessed = guessed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guesses)) {
            return false;
        }
        Guesses other = (Guesses) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.j2ee_project_4a.Guesses[ name=" + name + " ]";
    }

}
