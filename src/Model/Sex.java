/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.io.Serializable;

/**
 * This is the enum {@code Sex}, represent one sex.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public enum Sex implements Serializable
{
    /**Male sex*/
    MALE("Masculino"),
    /**Female sex*/
    FEMALE("Femenino"),
    /**Other sex*/
    OTHER("Otro");

    private final String sex;

    /**
     * Initialize a new {@code Sex} 
     * @param sex will be a new sex.
     */
    private Sex(String _sex)
    {
        sex = _sex;
    }

    public String GetSex()
    {
        return sex;
    }
}