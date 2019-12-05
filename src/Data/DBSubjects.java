package Data;

import Model.Subject;

import java.sql.PreparedStatement;

public class DBSubjects extends DbConnection implements IInsert<Subject>
{
    public DBSubjects()
    {
        super();
    }
    @Override
    public boolean Insert(Subject data) 
    {
        Open();
        try (PreparedStatement statement = PrepareStatement("INSERT INTO subjects(subject_code, subject_name, credits, recommended_semester) VALUES(?, ?, ?, ?)")) 
        {
                statement.setString(1, data.GetCode());
                statement.setString(2, data.GetName());
                statement.setInt(3, data.GetCredits());
                statement.setInt(4, data.GetRecommendedSemester());

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