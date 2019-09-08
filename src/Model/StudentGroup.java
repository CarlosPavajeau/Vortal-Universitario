/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code StudentGroup}, represents a group of students, which 
 * stores {@code Student}s that are enrolled in a subject.
 * Derived from {@code Entity}.
 * 
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class StudentGroup extends Entity
{
    private static final long serialVersionUID = 8673155443301130624L;
    
    private final int m_groupNumber;
    private final int m_limitOfStudents;
    private ArrayList<Student> m_students;
    private TypeGroup m_type;

    /**
     * Initialize a new {@code StudentGroup} with these characteristics.
     * @param code it will be the code that will have this {@code StudentGroup}.
     * @param groupNumber it will be the group number that will have this {@code StudentGroup}.
     * @param limitOfStudents will be the limit of students that will have this {@code StudentGroup}.
     * @param typeGroup will be the type of group that will have this {@code StudentGroup}.
     */
    public StudentGroup(String code, int groupNumber, int limitOfStudents, TypeGroup typeGroup)
    {
        this(code, groupNumber, limitOfStudents, typeGroup, new ArrayList<Student>());
    }

    /**
     * Initialize a new {@code StudentGroup} with these characteristics.
     * @param code will be the code that will have this {@code StudentGroup}.
     * @param groupNumber will be the group number that will have this {@code StudentGroup}.
     * @param limitOfStudents will be the limit of students that will have this {@code StudentGroup}.
     * @param typeGroup will be the type of group that will have this {@code StudentGroup}.
     * @param students it will be the students who will have this {@code StudentGroup}.
     */
    public StudentGroup(String code, int groupNumber, int limitOfStudents, TypeGroup typeGroup, ArrayList<Student> students)
    {
        super(code);
        m_groupNumber = groupNumber;
        m_limitOfStudents = limitOfStudents;
        m_students = students;
        m_type = typeGroup;
    }

    /**
     * Initialize a new {@code StudentGroup} with these characteristics.
     * this {@code Student Group} only has a code that identifies it.
     * @param code
     */
    public StudentGroup(String code)
    {
        this(code, 0, 0, TypeGroup.NONE);
    }

    /**
     * This method returns the number group that this {@code StudentGroup} has. 
     * @return the number group that this {@code StudentGroup} has.
     */
    public int GetGroupNumber()
    {
        return m_groupNumber;
    }

    /**
     * This method returns the number group that this {@code StudentGroup} has. 
     * @return the number group that this {@code StudentGroup} has.
     */
    public int GetLimitOfStudents()
    {
        return m_limitOfStudents;
    }

    /**
     * This method returns students that this {@code StudentGroup} has. 
     * @return the students that this {@code StudentGroup} has.
     */
    public ArrayList<Student> GetStudents()
    {
        return m_students;
    }

    /**
     * This method returns the type of group that is this {@code StudentGroup}.
     * @return the the type of group that is this {@code StudentGroup}.
     */
    public String GetType()
    {
        return m_type.GetType();
    }

    /**
     * This method sets the type of group for this {@code StudentGroup}.
     * @param type the type of group to process.
     */
    public final void SetType(TypeGroup type)
    {
        m_type = type;
    }

    /**
     * This method add one {@code Student} to this {@code StudentGroup}.
     * @param student the {@code Student} to add.
     * @return {@code true} if this {@code StudentGroup} isn't full or does not contains
     * the student. {@code false} otherwise.
     */
    public boolean AddStudent(Student student)
    {
        if (GetStudents().contains(student) || IsFull())
            return false;
        return GetStudents().add(student);
    }

    /**
     * This method remove one {@code Student} to this {@code StudentGroup}.
     * @param student the {@code Student} to remove.
     * @return {@code true} if this {@code StudentGroup} contains
     * the student. {@code false} otherwise.
     */
    public boolean DeleteStudent(Student student)
    {
        return GetStudents().remove(student);
    }

    /**
     * This method close this {@code StudentGroup}. Remove all students.
     */
    public void CloseGroup()
    {
        m_students.clear();
    }

    /**
     * This method validate if this {@code StudentGroup} is empty.
     * @return {@code true} if this {@code StudentGroup} not contains 
     * students. {@code false} oterwise.
     */
    public boolean IsEmpty()
    {
        return m_students.isEmpty();
    }

    /**
     * This method validate if this {@code StudentGroup} is full.
     * @return {@code true} if this {@code StudentGroup} is full. {@code false}
     * otherwise.
     */
    public boolean IsFull()
    {
        return m_students.size() >= GetLimitOfStudents();
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + m_groupNumber;
        result = prime * result + m_limitOfStudents;
        result = prime * result + ((m_type == null) ? 0 : m_type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentGroup other = (StudentGroup) obj;
        if (m_groupNumber != other.m_groupNumber)
            return false;
        if (m_limitOfStudents != other.m_limitOfStudents)
            return false;
        if (m_type != other.m_type)
            return false;
        return true;
    }

    
}