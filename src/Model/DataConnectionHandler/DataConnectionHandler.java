/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataConnectionHandler;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public interface DataConnectionHandler
{
    String CONNECTION_WITH_FILES = "Files";
    String CONNECTION_WITH_DATABASE = "DB";

    String DEFAULT_CONNECTION_MODE = CONNECTION_WITH_FILES;

    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException;

    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    void CloseDataConnection() throws SQLException, ClassNotFoundException, IOException;

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    boolean ConnectWithData() throws SQLException, ClassNotFoundException, IOException;
    /**
     * 
     * @return
     */
    boolean Insert(Object anObject) throws ClassNotFoundException, SQLException, IOException;

    /**
     * 
     * @return
     */
    Object Select(Object anObject) throws ClassNotFoundException, SQLException, IOException;

    /**
     * 
     * @return
     */
    boolean Update(Object anObject) throws ClassNotFoundException, SQLException, IOException;

    /**
     * 
     * @return
     */
    boolean Delete(Object anObject) throws ClassNotFoundException, SQLException, IOException ;
}