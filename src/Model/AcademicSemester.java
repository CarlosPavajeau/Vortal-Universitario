/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.io.Serializable;

/**
 *This is the class {@code AcademicSemester}. Represents an academic semester. its use
 * is to regulate the minimum and maximum credits that a {@code Student} can enroll
 * in a given semester, more precisely, the semester in which it is.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class AcademicSemester implements Comparable<AcademicSemester>, Serializable
{
    private static final long serialVersionUID = 1473598109107440457L;

    private final int semester;
    private int maximumCredits;
    private int minimumCredits;
    
    /**
     * Initialize a new {@code AcademicSemester} with these characteristics.
     * @param _semester that is to be assigned to the object.
     * @param maximum_credits that is to be assigned to the object.
     * @param minimum_credits that is to be assigned to the object.
     */
    public AcademicSemester(int _semester, int maximum_credits, int minimum_credits)
    {
        semester = _semester;
        maximumCredits = maximum_credits;
        minimumCredits = minimum_credits;
    }

    public AcademicSemester(int _semester)
    {
        this(_semester, 0, 0);
    }

    /**
     * This method returns the semester that this {@code AcademicSemester} has. 
     * @return the semester that this {@code AcademicSemester} has.
     */
    public int GetSemester()
    {
        return semester;
    }

    /**
     * This method returns the max credits that this {@code AcademicSemester} has. 
     * @return the max credits that this {@code AcademicSemester} has.
     */
    public int GetMaximumCredits()
    {
        return maximumCredits;
    }

    /**
     * This method returns the minimum credits that this {@code AcademicSemester} has. 
     * @return the minimum credits that this {@code AcademicSemester} has.
     */
    public int GetMinimumCredits()
    {
        return minimumCredits;
    }

    /**
     * This method sets a new max credits for this object {@code AcademicSemester}.
     * @param maximum_credits will be a new max credits of this {@code AcademicSemester}.
     */
    public void SetMaximumCredits(int maximum_credits)
    {
        maximumCredits = maximum_credits;
    }

    /**
     * This method sets a new minimum credits for this object {@code AcademicSemester}.
     * @param minimum_credits will be a new minimum credits of this {@code AcademicSemester}.
     */
    public void SetMinimunCredits(int minimum_credits)
    {
        minimumCredits = minimum_credits;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + GetSemester();
        return result;
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
        AcademicSemester other = (AcademicSemester) obj;
        if (GetSemester() != other.GetSemester())
            return false;
        return true;
    }
    
    @Override
    public int compareTo(AcademicSemester o) 
    {
        return Integer.compare(GetSemester(), o.GetSemester());
    }
}