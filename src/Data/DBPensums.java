package Data;

import Model.Pensum;
import Model.UnderGraduate;

import java.sql.PreparedStatement;

public class DBPensums extends DbConnection implements IInsert<Pensum>
{
    public DBPensums()
    {
        super();
    }
    @Override
    public boolean Insert(Pensum data) 
    {
        Open();
        try (PreparedStatement statement = PrepareStatement("INSERT INTO pensums(pensum_code, pensum_name, description, semesters, credits, pensum_type, title, campus_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) 
        {
            statement.setString(1, data.GetCode());
            statement.setString(2, data.GetName());
            statement.setString(3, data.GetDescription());
            statement.setInt(4, data.GetSemesters());
            statement.setInt(5, data.GetGlobalLessonLoad());
            statement.setString(6, (data instanceof UnderGraduate) ? "U" : "P");
            statement.setString(7, data.GetTitle());
            statement.setString(8, data.GetCampus());

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