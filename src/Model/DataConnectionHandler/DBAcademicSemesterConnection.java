package Model.DataConnectionHandler;

import Data.DBAcademicSemesters;
import Data.IInsert;
import Model.AcademicSemester;

public class DBAcademicSemesterConnection implements IInsert<AcademicSemester>
{
    private DBAcademicSemesters _AcademicSemesters;

    public DBAcademicSemesterConnection()
    {
        _AcademicSemesters = new DBAcademicSemesters();
    }

    @Override
    public boolean Insert(AcademicSemester data) 
    {
        return _AcademicSemesters.Insert(data);
    }
}