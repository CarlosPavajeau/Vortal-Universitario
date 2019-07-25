/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;


/**
 * This is the class {@code Login}. Its use is to store the access data 
 * of each user, this access data is his username and password.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Login
{
    private String m_user;
    private String m_password;

    /**
     * Initialize a new {@code Login} with these characteristics.
     * @param user that is to be assigned to the object.
     * @param password that is to be assigned to the object.
     */
    public Login(String user, String password)
    {
        m_user = user;
        m_password = password;
    }

    /**
     * This method returns the user that has this object {@code Login}.
     * @return the user that has the {@code Login}.
     */
    public String GetUser()
    {
        return m_user;
    }

    /**
     * This method returns the password that has this object {@code Login}.
     * @return the password that has the {@code Login}.
     */
    public String GetPassword()
    {
        return m_password;
    }

    /**
     * This method sets a new user for this object {@code Login}.
     * @param user will be a new user of this {@code Login}.
     */
    public void SetUser(String user)
    {
        m_user = user;
    }

    /**
     * This method sets a new password for this object {@code Login}.
     * @param password will be a new password of this {@code Login}.
     */
    public void SetPassword(String password)
    {
        m_password = password;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public static boolean ValidateLogin(Login a, Login b)
    {
        return a.GetUser().equals(b.GetUser()) && a.GetPassword().equals(b.GetPassword());
    }
}