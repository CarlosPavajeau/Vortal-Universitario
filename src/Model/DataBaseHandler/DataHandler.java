/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataBaseHandler;

import java.sql.SQLException;

import Data.DBConnectionHandler;;

/**
 * 
 */
public abstract class DataHandler implements DBHandler
{
    private DBConnectionHandler m_database;

    /**
     * 
     */
    public DataHandler()
    {
        m_database = new DBConnectionHandler();
    }

    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void CreateDB() throws SQLException, ClassNotFoundException
    {
        m_database.CreateDB();
    }

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean ConnectWithDB() throws SQLException, ClassNotFoundException
    {
        return m_database.ConectWithDB();
    }

    /**
     * 
     * @throws SQLException
     */
    public void CloseDB() throws SQLException
    {
        m_database.CloseDB();
    }
}