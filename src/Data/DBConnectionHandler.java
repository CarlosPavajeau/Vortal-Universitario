/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 */
public class DBConnectionHandler
{
    private static final String CREATE_TABLE_COMMAND = "CREATE TABLE ";

    private Connection m_connection;
    
    /**
     * 
     */
    public DBConnectionHandler()
    {
        m_connection = null;
    }

    /**
     * 
     */
    public void CreateDB() throws SQLException, ClassNotFoundException
    {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        m_connection = DriverManager.getConnection("jdbc:derby:\\DB\\Derby.DB;create=true");
        if (m_connection != null)
        {
            CreatePersonTable();
            CreateAcademicLoadTable();
            CreateAcademicSemesterTable();
            CreateLoginTable();
            CreatePensumTable();
            CreateSubjectTable();
            CreateQualificationTable();
            CreateMatriculateStudentTable();
            CreateStudentGroupTable();
        }
    }

    /**
     * 
     * @return
     */
    public boolean ConectWithDB() throws SQLException, ClassNotFoundException
    {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        m_connection = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB");
        return m_connection != null;
    }

    /**
     * 
     * @return
     */
    public void CloseDB() throws SQLException
    {
        m_connection.close();
    }

    /**
     * 
     * @param insertCommand
     * @return
     */
    public boolean Insert(String insertCommand) throws SQLException
    {
        return false;
    }

    /**
     * 
     * @param selectCommand
     * @return
     */
    public Object Select(String selectCommand) throws SQLException
    {
        return null;
    }

    /**
     * 
     * @param updateCommand
     * @return
     */
    public boolean Update(String updateCommand) throws SQLException
    {
        return false;
    }

    /**
     * 
     * @param deleteCommand
     * @return
     */
    public boolean Delete(String deleteCommand) throws SQLException
    {
        return false;
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreatePersonTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateLoginTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateAcademicLoadTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateStudentGroupTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateQualificationTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateMatriculateStudentTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreatePensumTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateSubjectTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateAcademicSemesterTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND);
    }

    /**
     * 
     * @param commnad
     */
    private void ExecuteCommand(String command) throws SQLException
    {
        PreparedStatement pst = m_connection.prepareStatement(command);
        pst.execute();
        pst.close();
    }
}