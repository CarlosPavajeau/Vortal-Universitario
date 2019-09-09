/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

/**
 * This is the enum {@code TypeGroup}, represent one Type group.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public enum TypeGroup
{
    MORNING("Mañana"),
    AFTERNOON("Tarde"),
    EVENING("Noche"),
    NONE("NONE");

    private final String typeGroup;

    private TypeGroup(String type_group)
    {
        typeGroup = type_group;
    }

    public String GetTypeGroup()
    {
        return typeGroup;
    }
}