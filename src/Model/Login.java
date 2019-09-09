/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.io.Serializable;

/**
 * This is the class {@code Login}. Its use is to store the access data 
 * of each user, this access data is his username and password.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Login implements Serializable
{
    private static final long serialVersionUID = 6453223500086846374L;
    
    private String user;
    private String password;

    /**
     * Initialize a new {@code Login} with these characteristics.
     * @param _user that is to be assigned to the object.
     * @param _password that is to be assigned to the object.
     */
    public Login(String _user, String _password)
    {
        user = _user;
        password = _password;
    }

    /**
     * This method returns the user that has this object {@code Login}.
     * @return the user that has the {@code Login}.
     */
    public String GetUser()
    {
        return user;
    }

    /**
     * This method returns the password that has this object {@code Login}.
     * @return the password that has the {@code Login}.
     */
    public String GetPassword()
    {
        return password;
    }

    /**
     * This method sets a new user for this object {@code Login}.
     * @param _user will be a new user of this {@code Login}.
     */
    public void SetUser(String _user)
    {
        user = _user;
    }

    /**
     * This method sets a new password for this object {@code Login}.
     * @param password will be a new password of this {@code Login}.
     */
    public void SetPassword(String _password)
    {
        password = _password;
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

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Login other = (Login) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}