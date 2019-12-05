/**
 * 
 */

package Data;

import java.sql.*;

public class DbConnection
{
    private static final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static final String USERNAME = "vortal";
    private static final String PASSWORDNAME = "vortal";

    protected Connection _connection;

    public DbConnection()
    {
        _connection = null;
    }

    public void Open()
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            _connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORDNAME);

        } catch (Exception e) 
        {
        }
        
    }

    public void Close()
    {
        try 
        {
            _connection.close();

        } catch (SQLException e) 
        {

        }
    }

    public PreparedStatement PrepareStatement(String statement) throws SQLException
    {
        return _connection.prepareStatement(statement);
    }
}