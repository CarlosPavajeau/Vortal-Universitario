package Data;

import Model.Student;

import java.sql.PreparedStatement;

public class DBStudent extends DbConnection implements IInsert<Student>
{
    public DBStudent()
    {
        super();
    }
    @Override
    public boolean Insert(Student data) 
    {
        Open();
        try (PreparedStatement statementStudent = PrepareStatement("INSERT INTO students(person_id, pensum_code) VALUES(?, ?)")) 
        {
            DBPeople people = new DBPeople();
            
            if (!people.Insert(data))
                return false;

                statementStudent.setString(1, data.GetCode());
                statementStudent.setString(2, data.PensumCode());

            return !statementStudent.execute();

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