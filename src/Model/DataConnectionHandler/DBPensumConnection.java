package Model.DataConnectionHandler;

import Data.DBPensums;
import Data.IInsert;
import Model.Pensum;

public class DBPensumConnection implements IInsert<Pensum>
{
    private DBPensums _dbPensum;

    public DBPensumConnection()
    {
        _dbPensum = new DBPensums();
    }

    @Override
    public boolean Insert(Pensum data) 
    {
        return _dbPensum.Insert(data);
    }


}