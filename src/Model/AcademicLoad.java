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
    private final Subject m_subject;

    /**
     * Initialize a new {@code AcademicLoad} with these characteristics.
     * @param groupNumbers will be the groups numbers for this {@code AcademicLoad}.
     * @param limitsOfStudents it will be the limit of students for this {@code AcademicLoad}.
     * @param typesGroup it will be the group type of each group of this {@code AcademicLoad}.
     * @param subjects it will be the subject of this {{@code AcademicLoad}}.
     */
    public AcademicLoad(int[] groupNumbers, int[] limitsOfStudents, String[] typesGroup, Subject subject)
    {
        m_subject = subject;
        for (int i = 0; i < groupNumbers.length; i++)
        {
            m_groups.add(new StudentGroup(GenerateStudentGroupCode(groupNumbers[i]), groupNumbers[i], limitsOfStudents[i], typesGroup[i]));
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
     * @param groupNumber will be the group number for a new {@code StudentGroup}.
     * @param limitOfStudents will be the limit of students for a new {@code StudentGroup}.
     * @param typeGroup will be the type group for a new {@code StudentGroup}.
     * @return {@code true}
     */
    public boolean AddStudentGroup(int groupNumber, int limitOfStudents, String typeGroup)
    {
        StudentGroup studentGroup = new StudentGroup(GenerateStudentGroupCode(groupNumber), groupNumber, limitOfStudents, typeGroup);
        if (m_groups.contains(studentGroup))
            return false;
        return m_groups.add(studentGroup);
    }

    /**
     * This method remove one {@code StudentGroup} of this {@code AcademicLoad}.
     * @param groupNumber the group to remove.
     * @return {@code true} if this {@code AcademicLoad} contains the group. 
     * {@code false} otherwise.
     */
    public boolean RemoveStudentGroup(int groupNumber)
    {
        return m_groups.remove(new StudentGroup(GenerateStudentGroupCode(groupNumber)));
    }

    /**
     * 
     * @param groupNumber
     * @return
     */
    public StudentGroup SearchGroup(int groupNumber)
    {
        StudentGroup studentGroup = new StudentGroup(GenerateStudentGroupCode(groupNumber), groupNumber, 0, "Mañana");
        studentGroup = m_groups.get(m_groups.indexOf(studentGroup));
        return studentGroup;
    }

    /**
     * This method generates the code that has a {@code StudentGroup} from 
     * the code of this {@code Subject} and the group number.
     * @param groupNumber is the number of the group from which the code is generated.
     * @return a {@code String} that contains the generated code.
     */
    private String GenerateStudentGroupCode(int groupNumber)
    {
        return GetSubject().GetCode() + "-" + groupNumber;
    }
}