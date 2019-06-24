/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code StudentGroup}, represent a Student group. Derive of {@code Entity}.
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class StudentGroup extends Entity
{
    private int m_numGroup;
    private int m_limitOfStudents;
    private ArrayList<Student> m_students;
    private TypeGroup m_type;

    /**
     * Initialize a new {@code StudentGroup} with these characteristics.
     * @param code
     * @param numGroup
     * @param limitOfStudents
     * @param typeGroup
     */
    public StudentGroup(String code, int numGroup, int limitOfStudents, String typeGroup)
    {
        this(code, numGroup, limitOfStudents, typeGroup, new ArrayList<Student>());
    }

    /**
     * Initialize a new {@code StudentGroup} with these characteristics.
     * @param code
     * @param numGroup
     * @param limitOfStudents
     * @param typeGroup
     * @param students
     */
    public StudentGroup(String code, int numGroup, int limitOfStudents, String typeGroup, ArrayList<Student> students)
    {
        super(code);
        m_numGroup = numGroup;
        m_limitOfStudents = limitOfStudents;
        m_students = students;
        SetType(typeGroup);
    }

    /**
     * This method returns the number group that this {@code StudentGroup} has. 
     * @return the number group that this {@code StudentGroup} has.
     */
    public int GetNumGroup()
    {
        return m_numGroup;
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
     * 
     * @param limitOfStudents
     */
    public void SetLimitOfStudent(int limitOfStudents)
    {
        m_limitOfStudents = limitOfStudents;
    }

    /**
     * 
     * @param student
     * @return
     */
    public boolean AddStudent(Student student)
    {
        if (m_students.contains(student))
            return false;
        return m_students.add(student);
    }

    /**
     * 
     * @param student
     * @return
     */
    public boolean DeleteStudent(Student student)
    {
        return m_students.remove(student);
    }

    /**
     * 
     * @param type
     */
    private void SetType(String type)
    {
        if (TypeGroup.MORNING.GetType().toUpperCase().equals(type.toUpperCase()))
            m_type = TypeGroup.MORNING;
        else if (TypeGroup.AFTERNOON.GetType().toUpperCase().equals(type.toUpperCase()))
            m_type = TypeGroup.AFTERNOON;
        else
            m_type = TypeGroup.EVENING;
    }


}