/*
 * Copyright (C) 2019 Carlos Pavajeau
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
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class FileConnectionHandler implements DataConnection, Serializable 
{
    private static final long serialVersionUID = -7926699142824489196L;

    private File m_file;
    private Record m_records;

    private class Record implements Serializable
    {
        private static final long serialVersionUID = -8020776646032448921L;
        private ArrayList<Object> m_record;

        public Record()
        {
            m_record = new ArrayList<>();
        }
        
        public boolean AddRecord(Object anObject)
        {
            return m_record.add(anObject);
        }

        public boolean UpdateRecord(Object anObject)
        {
            if (m_record.contains(anObject))
            {
                m_record.remove(anObject);
                return m_record.add(anObject);
            }
            return false;
        }

        public Object SelectRecord(Object anObject)
        {
            try
            {
                return m_record.get(m_record.indexOf(anObject));
            }
            catch(IndexOutOfBoundsException exception)
            {
                return null;
            } 
        }

        public boolean RemoveRecord(Object anObject)
        {
            return m_record.remove(anObject);
        }

        public boolean isEmpty()
        {
            return m_record.isEmpty();
        }
    }


    public FileConnectionHandler(String fileName) throws FileNotFoundException
    {
        m_file = new File(fileName);
        m_records = new Record();
    }

    @Override
    public boolean Insert(Object anObject) throws IOException, ClassNotFoundException
    {
        if (!IsItRegistered(anObject))
        {
            m_records.AddRecord(anObject);
            WriteRecords();
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
        m_records.UpdateRecord(anObject);
        WriteRecords();
        return true;
    }

    @Override
    public boolean Delete(Object anObject) throws IOException, ClassNotFoundException 
    {
        boolean result = m_records.RemoveRecord(anObject);
        if (result)
            WriteRecords();
        return result;
    }

    @Override
    public boolean IsItRegistered(Object anObject) throws IOException, ClassNotFoundException 
    {
        return SearchObject(anObject) != null;
    }

    @Override
    public boolean ThereIsRecords() throws IOException 
    {
        return !m_records.isEmpty();
	}

    @Override
    public void CreateDataConnection() throws ClassNotFoundException, IOException 
    {
        if (!m_file.exists())
        {
            
            try (FileOutputStream file = new FileOutputStream(m_file))
            {
            } 
            catch (IOException exception)
            {
                throw exception;
            }
        }
    }

    @Override
    public void CloseDataConnection() throws IOException 
    {

    }

    @Override
    public boolean ConnectWithData() throws IOException, ClassNotFoundException 
    {
        boolean res = true;

        try
        {
            ReadRecords();
        }
        catch (EOFException | FileNotFoundException exception)
        {
            res = false;
        }

        return res;
    }
    
    private Object SearchObject(Object anObject) throws IOException, ClassNotFoundException
    {
        return m_records.SelectRecord(anObject);
    }

    private void ReadRecords() throws ClassNotFoundException, IOException
    {
        try(FileInputStream fileInputStream = new FileInputStream(m_file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream))
        {
            m_records = (Record)inputStream.readObject();
        } 
        catch (IOException exception)
        {
            throw exception;
        }
    }

    private void WriteRecords() throws IOException
    {
        try(FileOutputStream fileOutputStream = new FileOutputStream(m_file); 
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(m_records);
        }
        catch (IOException exception)
        {
            throw exception;
        }
    }

}