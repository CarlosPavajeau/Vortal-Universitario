/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataConnectionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public class LoginDataHandler extends DataHandler
{
    public LoginDataHandler()
    {
        super();
    }

    public LoginDataHandler(String fileName) throws FileNotFoundException
    {
        super(fileName);
    }

    @Override
    public boolean Insert(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public Object Select(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Select(anObject);
    }

    @Override
    public boolean Update(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public boolean Delete(Object anObject) throws SQLException 
    {
        return false;
    }

    
}