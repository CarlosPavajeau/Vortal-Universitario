/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Data;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public interface DataConnection
{
    void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException;
    void CloseDataConnection() throws SQLException, ClassNotFoundException, IOException;
    boolean ConnectWithData() throws SQLException, ClassNotFoundException, IOException;
    boolean Insert(Object anObject) throws SQLException, IOException, ClassNotFoundException;
    Object Select(Object anObject) throws SQLException, IOException, ClassNotFoundException;
    boolean Update(Object anObject) throws SQLException, ClassNotFoundException, IOException;
    boolean Delete(Object anObject) throws SQLException, ClassNotFoundException, IOException;
    boolean IsItRegistered(Object anObject) throws SQLException, IOException, ClassNotFoundException;
    boolean ThereIsRecords() throws SQLException, ClassNotFoundException, IOException;
}