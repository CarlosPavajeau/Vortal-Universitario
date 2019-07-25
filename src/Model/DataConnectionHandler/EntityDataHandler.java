/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataConnectionHandler;

import java.io.FileNotFoundException;

/**
 * 
 */
public abstract class EntityDataHandler extends DataHandler
{
    public EntityDataHandler()
    {
        super();
    }

    public EntityDataHandler(String fileName) throws FileNotFoundException
    {
        super(fileName);
    }
}