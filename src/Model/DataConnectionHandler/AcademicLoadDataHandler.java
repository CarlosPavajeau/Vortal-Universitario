/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataConnectionHandler;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * 
 */
public class AcademicLoadDataHandler extends EntityDataHandler
{
    public AcademicLoadDataHandler()
    {
        super();
    }

    public AcademicLoadDataHandler(String fileName) throws FileNotFoundException
    {
        super(fileName);
    }

    @Override
    public boolean Insert(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public Object Select(Object objectID) throws SQLException 
    {
        return null;
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