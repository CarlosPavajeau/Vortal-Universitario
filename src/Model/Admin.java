/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;


/**
 * This is the class {@code Admin}. Represent the superuser of the application.
 * Derive of {@code Entity}
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Admin extends Entity
{
    private Login m_login;

    /**
     * Initialize a new {@code Admin} with these characteristics.
     * @param code that is to be assigned to the object.
     * @param user that is to be assigned to the object.
     * @param password that is to be assigned to the object.
     */
    public Admin(String code, String user, String password)
    {
        super(code);
        m_login = new Login(user, password);
    }

    /**
     * This method returns the {@code Login} that this {@code Admin} has.
     * @return the {@code Login} that this {@code Admin} has.
     */
    public Login GetLogin()
    {
        return m_login;
    }
}