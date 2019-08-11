/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class {@code AcademicLoad}, it represents an academic load. Its 
 * use is to store {@code StudentGroup}s and a {@code Subject} assigned to 
 * those {@code StudentGroup}s to be assigned to a {@code Professor}.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class AcademicLoad implements Comparable<AcademicLoad>, Serializable
{
    private static final long serialVersionUID = 8554588546116642636L;
    
    private List<StudentGroup> m_groups;
    private final Subject m_subject;

    /**
     * Initialize a new {@code AcademicLoad} with these characteristics.
     * @param groupNumbers will be the groups numbers for this {@code AcademicLoad}.
     * @param limitsOfStudents it will be the limit of students for this {@code AcademicLoad}.
     * @param typesGroup it will be the group type of each group of this {@code AcademicLoad}.
     * @param subjects it will be the subject of this {{@code AcademicLoad}}.
     */
    public AcademicLoad(int[] groupNumbers, int[] limitsOfStudents, TypeGroup[] typesGroup, Subject subject)
    {
        m_subject = subject;
        m_groups = new ArrayList<>();
    }

    /**
     * 
     * @param subject
     */
    public AcademicLoad(Subject subject)
    {
        this(null, null, null, subject);
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
    public List<StudentGroup> GetGroups()
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
    public boolean AddStudentGroup(int groupNumber, int limitOfStudents, TypeGroup typeGroup)
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
        StudentGroup studentGroup = new StudentGroup(GenerateStudentGroupCode(groupNumber));
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

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AcademicLoad other = (AcademicLoad) obj;
        if (GetSubject() == null) {
            if (other.GetSubject() != null)
                return false;
        } else if (!GetSubject().equals(other.GetSubject()))
            return false;
        return true;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((GetSubject() == null) ? 0 : GetSubject().hashCode());
        return result;
    }

    @Override
    public int compareTo(AcademicLoad o) 
    {
        return GetSubject().compareTo(o.GetSubject());
    }
}