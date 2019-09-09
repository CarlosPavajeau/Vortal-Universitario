/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Data;

/**
 * 
 */
public enum TableNames
{
    PERSON_TABLE("People"),
    QUALIFICATION_TABLE("Student_Qualifications"),
    PENSUM_TABLE("Pensums"),
    SUBJECT_TABLE("Subjects"),
    LOGIN_TABLE("Login"),
    ACADEMIC_LOAD_TABLE("Academic_Loads"),
    STUDENT_GROUP_TABLE("Student_Groups"),
    STUDENTS_ENROLLED_TABLE("Student_Enrolled"),
    STUDENTS_ENROLLED_IN_GROUP("Student_Enrolled_In_Group")
    ;

    private final String name;

    private TableNames(String _tableName)
    {
        name = _tableName;
    }

    public String GetTableName()
    {
        return name;
    }
}