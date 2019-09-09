/*
 * Copyright (C) 2019 Carlos Pavajeau
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
    private DataConnection dataConnection;

    /**
     * @throws FileNotFoundException
     * 
     */
    public DataHandler(String fileName) throws FileNotFoundException
    {
        SetModeConnection(fileName);    
    }

    /**
     * 
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void CloseDB() throws SQLException, IOException, ClassNotFoundException
    {
        dataConnection.CloseDataConnection();
    }

    @Override
    public boolean Insert(Object anObject) throws ClassNotFoundException, SQLException, IOException
    {
        return dataConnection.Insert(anObject);
    }

    @Override
    public Object Select(Object anObject) throws ClassNotFoundException, SQLException, IOException 
    {
        return dataConnection.Select(anObject);
    }

    @Override
    public boolean Update(Object anObject) throws ClassNotFoundException, SQLException, IOException 
    {
        return dataConnection.Update(anObject);
    }

    @Override
    public boolean Delete(Object anObject) throws ClassNotFoundException, SQLException, IOException 
    {
        return dataConnection.Delete(anObject);
    }

    @Override
    public void CloseDataConnection() throws SQLException, ClassNotFoundException, IOException 
    {
        dataConnection.CloseDataConnection();
    }

    @Override
    public boolean ConnectWithData() throws SQLException, ClassNotFoundException, IOException 
    {
        return dataConnection.ConnectWithData();
    }

    @Override
    public void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException 
    {
        dataConnection.CreateDataConnection();
    }

    private void SetModeConnection(String fileName) throws FileNotFoundException
    {
        if (DEFAULT_CONNECTION_MODE.equals(CONNECTION_WITH_FILES))
            dataConnection = new FileConnectionHandler(fileName);
        else
            dataConnection = new DBConnectionHandler();
    }
    
}