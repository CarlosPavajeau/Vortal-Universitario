/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;


/**
 *This is the class {@code AcademicSemester}. Represents an academic semester. its use
 * is to regulate the minimum and maximum credits that a {@code Student} can enroll
 * in a given semester, more precisely, the semester in which it is.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class AcademicSemester
{
    private final int m_semester;
    private int m_maxCredits;
    private int m_minCredits;
    
    /**
     * Initialize a new {@code AcademicSemester} with these characteristics.
     * @param semester that is to be assigned to the object.
     * @param maxCredits that is to be assigned to the object.
     * @param minCredits that is to be assigned to the object.
     */
    public AcademicSemester(int semester, int maxCredits, int minCredits)
    {
        m_semester = semester;
        m_maxCredits = maxCredits;
        m_minCredits = minCredits;
    }

    /**
     * This method returns the semester that this {@code AcademicSemester} has. 
     * @return the semester that this {@code AcademicSemester} has.
     */
    public int GetSemester()
    {
        return m_semester;
    }

    /**
     * This method returns the max credits that this {@code AcademicSemester} has. 
     * @return the max credits that this {@code AcademicSemester} has.
     */
    public int GetMaxCredits()
    {
        return m_maxCredits;
    }

    /**
     * This method returns the minimum credits that this {@code AcademicSemester} has. 
     * @return the minimum credits that this {@code AcademicSemester} has.
     */
    public int GetMinCredits()
    {
        return m_minCredits;
    }

    /**
     * This method sets a new max credits for this object {@code AcademicSemester}.
     * @param maxCredits will be a new max credits of this {@code AcademicSemester}.
     */
    public void SetMaxCredits(int maxCredits)
    {
        m_maxCredits = maxCredits;
    }

    /**
     * This method sets a new minimum credits for this object {@code AcademicSemester}.
     * @param minCredits will be a new minimum credits of this {@code AcademicSemester}.
     */
    public void SetMinCredits(int minCredits)
    {
        m_minCredits = minCredits;
    }
}