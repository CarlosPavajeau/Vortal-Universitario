package Model.DataConnectionHandler;

import Data.DBPeople;
import Data.IInsert;
import Model.Person;

public class DBPeopleConnection implements IInsert<Person>
{
    private DBPeople _dbPeople;

    public DBPeopleConnection()
    {
        _dbPeople = new DBPeople();
    }

    @Override
    public boolean Insert(Person data) 
    {
        return _dbPeople.Insert(data);
    }


}