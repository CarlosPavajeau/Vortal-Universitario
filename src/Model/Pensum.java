/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code Pensum}, represent a Pensum. Derive of {@code Entity}.
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Pensum extends Entity
{
    String m_name;
    String m_description;
    String m_campus;
    int m_semesters;
    int m_credits;
    ArrayList<Subject> m_subjects;

    /**
     * Initialize a new {@code Pensum} with these characteristics.
     * As in {@code Pensum} the code is unique. 
     * @param code that is to be assigned to the object
     * @param name it will be the name of the {@code Pensum}
     * @param description will be the description of the {@code Pensum}
     * @param campus it will be the campus where {@code Pensum} belongs
     * @param semesters duration in semesters of {@code Pensum}
     * @param credits minimum credits required or global credits of the {@code Pensum}
     * @param subjects subjects that belong or will belong to this {@code Pensum}
     */
    Pensum(String code, String name, String description, String campus, int semesters, int credits, ArrayList<Subject> subjects)
    {
        super(code);
        m_name = name;
        m_description = description;
        m_campus = campus;
        m_semesters = semesters;
        m_credits = credits;
        m_subjects = subjects;
    }

    /**
     * This method returns the name that has the object of type {@code Pensum}.
     * @return the code that has the {@code Pensum}
     */
    String GetName()
    {
        return m_name;
    }

    /**
     * This method returns the description that has the object of type {@code Pensum}.
     * @return the description that has the {@code Pensum}
     */
    String GetDescription()
    {
        return m_description;
    }

    /**
     * This method returns the campus that has the object of type {@code Pensum}.
     * @return the campus that has the {@code Pensum}
     */
    String GetCampus()
    {
        return m_campus;
    }

    /**
     * This method returns the semesters that has the object of type {@code Pensum}.
     * @return the semesters that has the {@code Pensum}
     */
    int GetSemesters()
    {
        return m_semesters;
    }

    /**
     * This method returns the credits that has the object of type {@code Pensum}.
     * @return the credits that has the {@code Pensum}
     */
    int GetCredits()
    {
        return m_credits;
    }

    /**
     * This method returns the subjects that has the object of type {@code Pensum}.
     * @return the subjects that has the {@code Pensum}
     */
    ArrayList<Subject> GetSubjects()
    {
        return m_subjects;
    }

    /**
     * This method sets a new name for this object {@code Pensum}
     * @param name will be a new name of this {@code Subject}
     */
    void SetName(String name)
    {
        m_name = name;
    }

    /**
     * This method sets a new description for this object {@code Pensum}
     * @param description will be a new description of this {@code Subject}
     */
    void SetDescription(String description)
    {
        m_description = description;
    }

    /**
     * This method sets a new campus for this object {@code Pensum}
     * @param campus will be a new campus of this {@code Subject}
     */
    void SetCampus(String campus)
    {
        m_campus = campus;
    }

    /**
     * This method sets a new semesters for this object {@code Pensum}
     * @param semesters will be a new semesters of this {@code Subject}
     */
    void SetSemesters(int semesters)
    {
        m_semesters = semesters;
    }

    /**
     * This method sets a new credits for this object {@code Pensum}
     * @param credits will be a new credits of this {@code Subject}
     */
    void SetCredits(int credits)
    {
        m_credits = credits;
    }
}