/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Data;

/**
 * 
 */
public abstract class DBConnectionHandler implements DataConnection
{
    protected DbConnection _connection;
    
    /**
     * 
     */
    public DBConnectionHandler(DbConnection connection)
    {
        _connection = connection;
    }
}