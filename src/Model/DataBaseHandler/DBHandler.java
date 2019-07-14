/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.DataBaseHandler;

import java.sql.SQLException;

/**
 * 
 */
interface DBHandler
{
    String INSERT_COMMAND = "INSERT ";
    String SELECT_COMMAND = "SELECT ";
    String UPDATE_COMMAND = "UPDATE ";
    String DELETE_COMMAND = "DELETE ";

    String FROM_COMMAND = "FROM ";
    String WHERE_COMMAND = "WHERE ";

    /**
     * 
     * @return
     */
    boolean Insert(Object anObject) throws SQLException;

    /**
     * 
     * @return
     */
    Object Select(String objectID) throws SQLException;

    /**
     * 
     * @return
     */
    boolean Update(Object anObject) throws SQLException;

    /**
     * 
     * @return
     */
    boolean Delete(Object anObject) throws SQLException;
}