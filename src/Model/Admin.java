/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;


/**
 * This is the class {@code Admin}. Represent the superuser of the application that has
 * all control on this software.
 * Derive of {@code Entity}
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Admin extends Entity
{
    private static final long serialVersionUID = 3986258342534801127L;
    
    private final AccessData accessData;

    /**
     * Initialize a new {@code Admin} with these characteristics.
     * @param code that is to be assigned to the object.
     * @param user that is to be assigned to the object.
     * @param password that is to be assigned to the object.
     */
    public Admin(String code, String user, String password)
    {
        super(code);
        accessData = new AccessData(user, password);
    }

    /**
     * This method returns the {@code Login} that this {@code Admin} has.
     * @return the {@code Login} that this {@code Admin} has.
     */
    public AccessData GetLogin()
    {
        return accessData;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = prime + ((accessData == null) ? 0 : accessData.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Admin other = (Admin) obj;
        if (accessData == null) {
            if (other.accessData != null)
                return false;
        } else if (!accessData.equals(other.accessData))
            return false;
        return true;
    }
}