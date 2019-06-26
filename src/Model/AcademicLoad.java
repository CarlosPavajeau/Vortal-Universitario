/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code AcademicLoad}, represent a academic charge.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class AcademicLoad
{
    private ArrayList<StudentGroup> m_groups;
    private Subject m_subject;

    /**
     * Initialize a new {@code AcademicLoad} with these characteristics.
     * @param numsGroup
     * @param limitsOfStudents
     * @param typesGroup
     * @param subject
     */
    public AcademicLoad(int[] numsGroup, int[] limitsOfStudents, String[] typesGroup, Subject subject)
    {
        m_subject = subject;
        for (int i = 0; i < numsGroup.length; i++)
        {
            m_groups.add(new StudentGroup(GetSubjet().GetCode() + "-" + numsGroup[i], numsGroup[i], limitsOfStudents[i], typesGroup[i]));
        }
    }

    /**
     * 
     * @return
     */
    public Subject GetSubjet()
    {
        return m_subject;
    }

    /**
     * 
     * @return
     */
    public ArrayList<StudentGroup> GetGroups()
    {
        return m_groups;
    }

    /**
     * 
     * @param studentGroup
     * @return
     */
    public boolean AddStudentGroup(StudentGroup studentGroup)
    {
        if (m_groups.contains(studentGroup))
            return false;
        return m_groups.add(studentGroup);
    }
}