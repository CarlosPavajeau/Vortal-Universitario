/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataConnectionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import Data.DBConnectionHandler;
import Data.DataConnection;
import Data.FileConnectionHandler;

/**
 * 
 */
public abstract class DataHandler implements DBHandler
{
    private DataConnection m_dataConnection;

    /**
     * @throws FileNotFoundException
     * 
     */
    public DataHandler(String fileName) throws FileNotFoundException
    {
        m_dataConnection = new FileConnectionHandler(fileName);
    }
    
    /**
     * 
     */
    public DataHandler()
    {
        m_dataConnection = new DBConnectionHandler();
    }

    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException
    {
        m_dataConnection.CreateDataConnection();
    }

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean ConnectWithDB() throws SQLException, ClassNotFoundException, IOException
    {
        return m_dataConnection.ConnectWithData();
    }

    /**
     * 
     * @throws SQLException
     */
    public void CloseDB() throws SQLException, IOException
    {
        m_dataConnection.CloseDataConnection();
    }
}