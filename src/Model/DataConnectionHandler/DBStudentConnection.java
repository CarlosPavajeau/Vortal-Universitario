package Model.DataConnectionHandler;

import Data.DBStudent;
import Data.IInsert;
import Model.Student;;

public class DBStudentConnection implements IInsert<Student>
{
    private DBStudent _dbStudents;

    public DBStudentConnection()
    {
        _dbStudents = new DBStudent();
    }

    @Override
    public boolean Insert(Student data) 
    {
        return _dbStudents.Insert(data);
    }


}