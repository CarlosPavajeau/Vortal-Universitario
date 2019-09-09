/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 */
public class DBConnectionHandler implements DataConnection
{
    private static final String CREATE_TABLE_COMMAND = "CREATE TABLE ";
    private static final String INSERT_COMMAND = "INSERT ";
    private static final String SELECT_COMMAND = "SELECT ";
    private static final String UPDATE_COMMAND = "UPDATE ";
    private static final String DELETE_COMMAND = "DELETE ";
    private static final String FROM_COMMAND = "FROM ";
    private static final String WHERE_COMMAND = "WHERE ";


    private Connection connection;
    
    /**
     * 
     */
    public DBConnectionHandler()
    {
        connection = null;
    }

    /**
     * 
     */
    public void CreateDB() throws SQLException, ClassNotFoundException
    {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connection = DriverManager.getConnection("jdbc:derby:DB/Derby.DB;create=true");
        if (connection != null)
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
        connection = DriverManager.getConnection("jdbc:derby:DB/Derby.DB");
        return connection != null;
    }

    /**
     * 
     * @return
     */
    public void CloseDB() throws SQLException
    {
        connection.close();
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
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.PERSON_TABLE.GetTableName() + TableFields.PERSON_TABLE_FIELDS.GetFields());
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateLoginTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.LOGIN_TABLE.GetTableName() + "");
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateAcademicLoadTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.ACADEMIC_LOAD_TABLE.GetTableName() + "");
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateStudentGroupTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.STUDENT_GROUP_TABLE.GetTableName() + "");
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateQualificationTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.QUALIFICATION_TABLE.GetTableName() + "");
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
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.PENSUM_TABLE.GetTableName() + "");
    }

    /**
     * 
     * @throws SQLException
     */
    private void CreateSubjectTable() throws SQLException
    {
        ExecuteCommand(CREATE_TABLE_COMMAND + TableNames.SUBJECT_TABLE.GetTableName() + "");
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
        PreparedStatement pst = connection.prepareStatement(command);
        pst.execute();
        pst.close();
    }

    @Override
    public boolean Insert(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public Object Select(Object anObject) throws SQLException, ClassNotFoundException 
    {
        return null;
    }

    @Override
    public boolean Update(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public boolean Delete(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public boolean IsItRegistered(Object anObject) throws SQLException 
    {
        return false;
    }

    @Override
    public boolean ThereIsRecords() throws SQLException 
    {
        return false;
    }

    @Override
    public void CreateDataConnection() throws SQLException, ClassNotFoundException, IOException 
    {

    }

    @Override
    public void CloseDataConnection() throws SQLException, IOException 
    {

    }

    @Override
    public boolean ConnectWithData() throws SQLException, IOException 
    {
        return false;
	}
}