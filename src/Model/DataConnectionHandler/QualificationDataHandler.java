/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataConnectionHandler;

import java.sql.SQLException;

/**
 * 
 */
public class QualificationDataHandler extends EntityDataHandler
{
    public QualificationDataHandler()
    {
        super();
    }

    @Override
    public boolean Insert(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public Object Select(Object anObject) throws SQLException 
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