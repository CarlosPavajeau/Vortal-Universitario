/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public class FileConnectionHandler implements DataConnection 
{
    private File m_file;

    public FileConnectionHandler(String fileName) throws FileNotFoundException
    {
        m_file = new File(fileName);
    }

    @Override
    public boolean Insert(Object anObject) throws IOException 
    {
        return false;
    }

    @Override
    public Object Select(Object anObject) throws IOException 
    {
        return null;
    }

    @Override
    public boolean Update(Object anObject) throws IOException 
    {
        return false;
    }

    @Override
    public boolean Delete(Object anObject) throws IOException 
    {
        return false;
    }

    @Override
    public boolean IsItRegistered(Object anObject) throws IOException 
    {
        return false;
    }

    @Override
    public boolean ThereIsRecords() throws IOException 
    {
		return false;
	}

    @Override
    public void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException 
    {

    }

    @Override
    public void CloseDataConnection() throws SQLException, IOException 
    {

    }

    @Override
    public boolean ConnectWithData() throws SQLException, IOException 
    {
        return false;
	}

}