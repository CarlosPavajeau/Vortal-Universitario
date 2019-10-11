/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.io.Serializable;

public enum Sex implements Serializable
{
    MALE("Masculino"),
    FEMALE("Femenino"),
    OTHER("Otro");

    private final String sex;

    private Sex(String _sex)
    {
        sex = _sex;
    }

    public String GetSex()
    {
        return sex;
    }
}