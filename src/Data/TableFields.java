/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Data;

/**
 * 
 */
public enum TableFields
{
    PERSON_TABLE_FIELDS("(id varchar(20), firstName varchar(30), secondName varchar(30), " +
                        "lastName varchar(30), secondLastName varchar(30), yearOfBorn varchar(10), " +
                        "monthOfBorrn varchar(10), dayOfBorn varchar(10), sex varchar(15), type varchar(5))");
    ;

    private final String fields;

    private TableFields(String _fields)
    {
        fields = _fields;
    }

    public String GetFields()
    {
        return fields;
    }
}