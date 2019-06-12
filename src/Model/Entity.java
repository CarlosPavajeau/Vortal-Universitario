/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

/**
<<<<<<< HEAD
 * This is the superclass of most major classes of software. Of course this 
 * class is abstract. But currently not implemented the abstract methods.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
=======
 *
 * @author carlos and @ejcalvo
>>>>>>> 50acc4e93f883fad31a6884a8f887714375f2600
 */

public abstract class Entity 
{
    private String m_code;
    
    /**
     * Initialize a new {@code Entity} with it's code. 
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     * @param The code that is to be assigned to the object
     */
    public Entity(String code)
    {
        m_code = code;
    }

    /**
     * This method returns the code that has the object of the Entity class.
     * @return the code 
     */
    public String GetCode()
    {
        return m_code;
    }
}
