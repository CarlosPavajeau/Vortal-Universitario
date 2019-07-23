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
    void CloseDataConnection() throws SQLException, IOException;
    boolean ConnectWithData() throws SQLException, IOException;
    boolean Insert(Object anObject) throws SQLException, IOException;
    Object Select(Object anObject) throws SQLException, IOException;
    boolean Update(Object anObject) throws SQLException, IOException;
    boolean Delete(Object anObject) throws SQLException, IOException;
    boolean IsItRegistered(Object anObject) throws SQLException, IOException;
    boolean ThereIsRecords() throws SQLException, IOException;
}