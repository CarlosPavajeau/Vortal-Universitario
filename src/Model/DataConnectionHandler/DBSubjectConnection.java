package Model.DataConnectionHandler;

import Data.DBSubjects;
import Data.IInsert;
import Model.Subject;

public class DBSubjectConnection implements IInsert<Subject>
{
    private DBSubjects _DbSubjects;

    public DBSubjectConnection()
    {
        _DbSubjects = new DBSubjects();
    }

    @Override
    public boolean Insert(Subject data) 
    {
        return _DbSubjects.Insert(data);
    }
}