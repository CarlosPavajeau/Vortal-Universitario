/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model.DataConnectionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public class PensumDataHandler extends EntityDataHandler
{
    public PensumDataHandler() throws FileNotFoundException
    {
        super("Pensum.dat");
    }
    
    @Override
    public boolean Insert(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Insert(anObject);
    }

    @Override
    public Object Select(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Select(anObject);
    }

    @Override
    public boolean Update(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Update(anObject);
    }

    @Override
    public boolean Delete(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Delete(anObject);
    }
}