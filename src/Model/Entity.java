/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.io.Serializable;

/**
 * This is the superclass of most classes of this software. Of course, 
 * this class is abstract, but abstract methods are not implemented. Represents 
 * a unique object that is represented by its code. This code is used for searches, 
 * updates and/or deletions. It is worth mentioning that the code is unique for each 
 * object {@code Entity}
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public abstract class Entity implements Comparable<Entity>, Serializable
{
    private static final long serialVersionUID = 274736873469220325L;
    private final String code;
    
    /**
     * Initialize a new {@code Entity} with it's code. 
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     * @param _code that is to be assigned to the object.
     */
    public Entity(String _code)
    {
        code = _code;
    }

    /**
     * Initialize a new {@code Entity} with other {@code Entity}, this is the copy constructor.
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     * @param anEntity
     */
    public Entity(Entity anEntity)
    {
        this(anEntity.GetCode());
    }

    /**
     * Initialize a new {@code Entity} empty.
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     */
    public Entity()
    {
        this("");
    }

    /**
     * This method returns the code that this {@code Entity} has.
     * @return the code that this {@code Entity} has.
     */
    public String GetCode()
    {
        return code;
    }

    @Override
    public boolean equals(Object anObject) 
    {
        if (this == anObject)
            return true;
        if (anObject == null)
            return false;
        if (!(anObject instanceof Entity))
            return false;
        Entity other = (Entity) anObject;
        if (GetCode() == null) {
            if (other.GetCode() != null)
                return false;
        } else if (!GetCode().equals(other.GetCode()))
            return false;
        return true;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((GetCode() == null) ? 0 : GetCode().hashCode());
        return result;
    }

    @Override
    public int compareTo(Entity anEntity)
    {
        return GetCode().compareTo(anEntity.GetCode());
    }
}
