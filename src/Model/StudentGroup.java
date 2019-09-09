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
    
    private final int groupNumber;
    private final int limitOfStudents;
    private ArrayList<Student> students;
    private TypeGroup typeGroup;

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
    public StudentGroup(String _code, int _groupNumber, int _limitOfStudents, TypeGroup _typeGroup, ArrayList<Student> _students)
    {
        super(_code);
        groupNumber = _groupNumber;
        limitOfStudents = _limitOfStudents;
        students = _students;
        typeGroup = _typeGroup;
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
        return groupNumber;
    }

    /**
     * This method returns the number group that this {@code StudentGroup} has. 
     * @return the number group that this {@code StudentGroup} has.
     */
    public int GetLimitOfStudents()
    {
        return limitOfStudents;
    }

    /**
     * This method returns students that this {@code StudentGroup} has. 
     * @return the students that this {@code StudentGroup} has.
     */
    public ArrayList<Student> GetStudents()
    {
        return students;
    }

    /**
     * This method returns the type of group that is this {@code StudentGroup}.
     * @return the the type of group that is this {@code StudentGroup}.
     */
    public String GetTypeGroup()
    {
        return typeGroup.GetTypeGroup();
    }

    /**
     * This method sets the type of group for this {@code StudentGroup}.
     * @param typeGroup the type of group to process.
     */
    public final void SetType(TypeGroup type_Group)
    {
        typeGroup = type_Group;
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
        students.clear();
    }

    /**
     * This method validate if this {@code StudentGroup} is empty.
     * @return {@code true} if this {@code StudentGroup} not contains 
     * students. {@code false} oterwise.
     */
    public boolean IsEmpty()
    {
        return students.isEmpty();
    }

    /**
     * This method validate if this {@code StudentGroup} is full.
     * @return {@code true} if this {@code StudentGroup} is full. {@code false}
     * otherwise.
     */
    public boolean IsFull()
    {
        return students.size() >= GetLimitOfStudents();
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + groupNumber;
        result = prime * result + limitOfStudents;
        result = prime * result + ((typeGroup == null) ? 0 : typeGroup.hashCode());
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
        if (groupNumber != other.groupNumber)
            return false;
        if (limitOfStudents != other.limitOfStudents)
            return false;
        if (typeGroup != other.typeGroup)
            return false;
        return true;
    }

    
}