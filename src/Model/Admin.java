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
    
    private Login login;

    /**
     * Initialize a new {@code Admin} with these characteristics.
     * @param code that is to be assigned to the object.
     * @param user that is to be assigned to the object.
     * @param password that is to be assigned to the object.
     */
    public Admin(String code, String user, String password)
    {
        super(code);
        login = new Login(user, password);
    }

    /**
     * This method returns the {@code Login} that this {@code Admin} has.
     * @return the {@code Login} that this {@code Admin} has.
     */
    public Login GetLogin()
    {
        return login;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = prime + ((login == null) ? 0 : login.hashCode());
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
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }
}