package Data;

import Model.Person;

import java.sql.Date;
import java.sql.PreparedStatement;

public class DBPeople extends DbConnection implements IInsert<Person>
{
    public DBPeople()
    {
        super();
    }

    @Override
    public boolean Insert(Person data) 
    {
        Open();
        try (PreparedStatement statement = _connection.prepareStatement("INSERT INTO people(person_id, first_name, second_name, last_name, second_last_name, sex, date_of_born) VALUES (?, ?, ?, ?, ?, ?, ?)")) 

        {
            statement.setString(1, data.GetCode());
            statement.setString(2, data.GerFirstName());
            statement.setString(3, data.GetSecondName());
            statement.setString(4, data.GetLastName());
            statement.setString(5, data.GetSecondLastName());
            statement.setString(6, String.valueOf(data.GetSex().charAt(0)));
            statement.setDate(7, Date.valueOf(data.GetDateOfBorn()));
            
            return !statement.execute();
            
        } catch (Exception e) 
        {
            return false;
        }
        finally
        {
            Close();
        }
    }
}