/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 */
public class FileConnectionHandler implements DataConnection 
{
    private File m_file;
    private FileOutputStream m_fileOutputStream;
    private FileInputStream m_fileInputStream;
    private ObjectOutputStream m_objectOutputStream;
    private ObjectInputStream m_objectInputStream;

    public FileConnectionHandler(String fileName) throws FileNotFoundException
    {
        m_file = new File(fileName);
    }

    @Override
    public boolean Insert(Object anObject) throws IOException, ClassNotFoundException
    {
        if (!IsItRegistered(anObject))
        {
            m_objectOutputStream.writeObject(anObject);
            return true;
        }
        return false;
    }

    @Override
    public Object Select(Object anObject) throws IOException, ClassNotFoundException 
    {
        return SearchObject(anObject);
    }

    @Override
    public boolean Update(Object anObject) throws IOException, ClassNotFoundException 
    {
        File tempFile = new File("temp.temp");
        FileOutputStream tempFileOutput = new FileOutputStream(tempFile);
        ObjectOutputStream tempOutput = new ObjectOutputStream(tempFileOutput);
        Object otherObject = null;

        otherObject = m_objectInputStream.readObject();
        while (true)
        {
            try
            {
                if (anObject.equals(otherObject))
                {
                    tempOutput.writeObject(anObject);
                }
                else
                    tempOutput.writeObject(otherObject);
                otherObject = m_objectInputStream.readObject();

            } catch (EOFException exception)
            {
                break;
            }
        }

        tempOutput.close();
        tempFile.renameTo(m_file);

        return true;
    }

    @Override
    public boolean Delete(Object anObject) throws IOException, ClassNotFoundException 
    {
        File tempFile = new File("temp.temp");
        FileOutputStream tempFileOutput = new FileOutputStream(tempFile);
        ObjectOutputStream tempOutput = new ObjectOutputStream(tempFileOutput);
        Object otherObject = null;

        otherObject = m_objectInputStream.readObject();
        while (true)
        {
            try
            {
                if (!anObject.equals(otherObject))
                {
                    tempOutput.writeObject(otherObject);
                }
                otherObject = m_objectInputStream.readObject();

            } catch (EOFException exception)
            {
                break;
            }
        }

        tempOutput.close();
        tempFile.renameTo(m_file);

        return true;
    }

    @Override
    public boolean IsItRegistered(Object anObject) throws IOException, ClassNotFoundException 
    {
        return SearchObject(anObject) != null;
    }

    @Override
    public boolean ThereIsRecords() throws IOException 
    {
        return false;
	}

    @Override
    public void CreateDataConnection() throws ClassNotFoundException, IOException 
    {
        m_fileOutputStream = new FileOutputStream(m_file);
        m_fileInputStream = new FileInputStream(m_file);
    }

    @Override
    public void CloseDataConnection() throws IOException 
    {
        if (m_fileOutputStream != null)
            m_fileOutputStream.close();
        if (m_fileInputStream != null)
            m_fileInputStream.close();
        if (m_objectOutputStream != null)
            m_objectOutputStream.close();
        if (m_fileInputStream != null)
            m_objectInputStream.close();
    }

    @Override
    public boolean ConnectWithData() throws IOException 
    {
        m_objectOutputStream = new ObjectOutputStream(m_fileOutputStream);
        m_objectInputStream = new ObjectInputStream(m_fileInputStream);
        return true;
    }
    
    private Object SearchObject(Object anObject) throws IOException, ClassNotFoundException
    {
        Object otherObject = null;

        try
        {
            otherObject = m_objectInputStream.readObject();
            while (!otherObject.equals(anObject))
                otherObject = m_objectInputStream.readObject();

        }catch(EOFException exception)
        {
            return null;
        }
        
        return otherObject;
    }

}