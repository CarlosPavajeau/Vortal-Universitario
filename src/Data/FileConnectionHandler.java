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

    private File file;
    private Record records;

    private class Record implements Serializable
    {
        private static final long serialVersionUID = -8020776646032448921L;
        private ArrayList<Object> record;

        public Record()
        {
            record = new ArrayList<>();
        }
        
        public boolean AddRecord(Object anObject)
        {
            return record.add(anObject);
        }

        public boolean UpdateRecord(Object anObject)
        {
            if (record.contains(anObject))
            {
                record.remove(anObject);
                return record.add(anObject);
            }
            return false;
        }

        public Object SelectRecord(Object anObject)
        {
            try
            {
                return record.get(record.indexOf(anObject));
            }
            catch(IndexOutOfBoundsException exception)
            {
                return null;
            } 
        }

        public boolean RemoveRecord(Object anObject)
        {
            return record.remove(anObject);
        }

        public boolean isEmpty()
        {
            return record.isEmpty();
        }
    }


    public FileConnectionHandler(String fileName) throws FileNotFoundException
    {
        file = new File(fileName);
        records = new Record();
    }

    @Override
    public boolean Insert(Object anObject) throws IOException, ClassNotFoundException
    {
        if (!IsItRegistered(anObject))
        {
            records.AddRecord(anObject);
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
        records.UpdateRecord(anObject);
        WriteRecords();
        return true;
    }

    @Override
    public boolean Delete(Object anObject) throws IOException, ClassNotFoundException 
    {
        boolean result = records.RemoveRecord(anObject);
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
        return !records.isEmpty();
	}

    @Override
    public void CreateDataConnection() throws ClassNotFoundException, IOException 
    {
        if (!file.exists())
        {
            
            try (FileOutputStream fileToCreatre = new FileOutputStream(file))
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
        return records.SelectRecord(anObject);
    }

    private void ReadRecords() throws ClassNotFoundException, IOException
    {
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream))
        {
            records = (Record)inputStream.readObject();
        } 
        catch (IOException exception)
        {
            throw exception;
        }
    }

    private void WriteRecords() throws IOException
    {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file); 
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(records);
        }
        catch (IOException exception)
        {
            throw exception;
        }
    }

}