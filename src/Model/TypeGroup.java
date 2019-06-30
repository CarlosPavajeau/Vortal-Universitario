/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
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

    private final String m_type;

    private TypeGroup(String type)
    {
        m_type = type;
    }

    public String GetType()
    {
        return m_type;
    }
}