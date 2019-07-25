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
public  class DataHandler implements DataConnectionHandler
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
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void CloseDB() throws SQLException, IOException, ClassNotFoundException
    {
        m_dataConnection.CloseDataConnection();
    }

    @Override
    public boolean Insert(Object anObject) throws ClassNotFoundException, SQLException, IOException
    {
        return m_dataConnection.Insert(anObject);
    }

    @Override
    public Object Select(Object anObject) throws ClassNotFoundException, SQLException, IOException 
    {
        return m_dataConnection.Select(anObject);
    }

    @Override
    public boolean Update(Object anObject) throws ClassNotFoundException, SQLException, IOException 
    {
        return m_dataConnection.Update(anObject);
    }

    @Override
    public boolean Delete(Object anObject) throws ClassNotFoundException, SQLException, IOException 
    {
        return m_dataConnection.Delete(anObject);
    }

    @Override
    public void CloseDataConnection() throws SQLException, ClassNotFoundException, IOException 
    {
        m_dataConnection.CloseDataConnection();
    }

    @Override
    public boolean ConnectWithData() throws SQLException, ClassNotFoundException, IOException 
    {
        return m_dataConnection.ConnectWithData();
    }

    @Override
    public void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException 
    {
        m_dataConnection.CreateDataConnection();
    }
    
}