/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

/**
 * This is the superclass of most major classes of software. Of course this 
 * class is abstract. But currently not implemented the abstract methods.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */

public abstract class Entity implements Comparable<Entity>
{
    private long m_code;
    
    /**
     * Initialize a new {@code Entity} with it's code. 
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     * @param code that is to be assigned to the object
     */
    public Entity(long code)
    {
        m_code = code;
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
        this(0);
    }

    /**
     * This method returns the code that has the object of the Entity class.
     * @return the code that has the {@code Entity} 
     */
    public long GetCode()
    {
        return m_code;
    }

    /**
     * This method returns {@code true} if the objects be {@code Entity} or the objects has
     * equals codes 
     * @param anObject The object to compare this {@code Entity} against
     * @return {@code true} if the given object represents a {@code Entity} with
     *  a equivalent code. {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject)
    {
        if (anObject != null && anObject instanceof Entity)
        {
            Entity anEntity = (Entity)anObject;
            return compareTo(anEntity) == 0;
        }
        return false;
    }

    /**
     * Compares the codes of two {@code Entity} objects
     * @param anEntity The object to compare this {@code Entity} against
     * @return the value {@code 0} if the code of this {@code Entity} is equal to the argument
     * {@code Entity}, a value less than {@code 0} if the code of this {@code Entity} is 
     * numerically less than the argument {@code Entity} and a value greater than {@code 0}
     * if the code of this {@code Entity} is numerically greater than the argument {@code Entity}
     */
    @Override
    public int compareTo(Entity anEntity)
    {
        return Long.valueOf(GetCode()).compareTo(anEntity.GetCode());
    }
}
