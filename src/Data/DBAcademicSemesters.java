package Data;

import Model.AcademicSemester;

import java.sql.PreparedStatement;

public class DBAcademicSemesters extends DbConnection implements IInsert<AcademicSemester>
{
    public DBAcademicSemesters()
    {
        super();
    }
    @Override
    public boolean Insert(AcademicSemester data) 
    {
        Open();
        try (PreparedStatement statement = PrepareStatement("INSERT INTO academic_semesters(semester_number, maximum_credits, minimun_credits) VALUES(?, ?, ?)")) 
        {
                statement.setInt(1, data.GetSemester());
                statement.setInt(2, data.GetMaximumCredits());
                statement.setInt(3, data.GetMinimumCredits());

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