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
     @param numsGroup will be the numbers of the groups for this {@code AcademicLoad}.
     * @param limitsOfStudents it will be the limit of students for this {@code AcademicLoad}.
     * @param typesGroup it will be the group type of each group of this {@code AcademicLoad}.
     * @param subjects it will be the subject of this {{@code AcademicLoad}}.
     */
    public AcademicLoad(int[] numsGroup, int[] limitsOfStudents, String[] typesGroup, Subject subject)
    {
        m_subject = subject;
        for (int i = 0; i < numsGroup.length; i++)
        {
            m_groups.add(new StudentGroup(GetSubject().GetCode() + "-" + numsGroup[i], numsGroup[i], limitsOfStudents[i], typesGroup[i]));
        }
    }

    /**
     * This method returns the {@code Subject} that this {@code AcademicLoad} has.
     * @return the {@code Subject} that this {@code AcademicLoad} has.
     */
    public Subject GetSubject()
    {
        return m_subject;
    }

    /**
     * This method returns the student groups that this {@code AcademicLoad} has.
     * @return the student groups that this {@code AcademicLoad} has.
     */
    public ArrayList<StudentGroup> GetGroups()
    {
        return m_groups;
    }

    /**
     * This method add a new {@code StudentGroup} for this {@code AcademicLoad}.
     * @param numGroup
     * @param limitOfStudents
     * @param typeGroup
     * @return {@code true}
     */
    public boolean AddStudentGroup(int numGroup, int limitOfStudents, String typeGroup)
    {
        StudentGroup studentGroup = new StudentGroup(GetSubject().GetCode() + "-" + numGroup, numGroup, limitOfStudents, typeGroup);
        if (m_groups.contains(studentGroup))
            return false;
        return m_groups.add(studentGroup);
    }

    /**
     * 
     * @param numGroup
     * @return
     */
    public boolean RemoveStudentGroup(int numGroup)
    {
        return false;
    }

    /**
     * 
     * @param numGroup
     * @return
     */
    private StudentGroup SearchGroup(int numGroup)
    {
        return null;
    }
}