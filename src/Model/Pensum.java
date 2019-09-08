/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.util.ArrayList;

import Model.Exceptions.ExceededCreditsException;

/**
 * This is the class {@code Pensum}, it represents a Pensum or an academic curriculum, in 
 * this {@code Pensum} there are stored {@code Subject}'s which must be given in a certain campus 
 * and with a certain number of semesters.
 * Note: The {@code Subject}'s may belong to different {@code Pensum} but these can only 
 * be added once.
 * 
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public abstract class Pensum extends Entity implements SubjectHandler
{
    private static final long serialVersionUID = -5371456265746468553L;
    
    private String m_name;
    private String m_description;
    private String m_campus;
    private int m_semesters;
    private int m_credits;
    private int m_globalLessonLoad;
    private ArrayList<Subject> m_subjects;

    /**
     * Initialize a new {@code Pensum} with these characteristics.
     * As in {@code Pensum} the code is unique. 
     * @param code that is to be assigned to the {@code Pensum}.
     * @param name it will be the name of the {@code Pensum}.
     * @param description will be the description of the {@code Pensum}.
     * @param campus it will be the campus where {@code Pensum} belongs.
     * @param semesters duration in semesters of {@code Pensum}.
     * @param globalLessonLoad minimum credits required or global credits of the {@code Pensum}.
     * @param subjects subjects that belong or will belong to this {@code Pensum}.
     */
    public Pensum(String code, String name, String description, String campus, int semesters, int globalLessonLoad, ArrayList<Subject> subjects)
    {
        super(code);
        m_name = name;
        m_description = description;
        m_campus = campus;
        m_semesters = semesters;
        m_globalLessonLoad = globalLessonLoad;
        m_credits = 0;
        m_subjects = (subjects != null) ? subjects : new ArrayList<>();
    }

    /**
     * This method returns the name that this {@code Pensum} has.
     * @return the name that this {@code Pensum} has.
     */
    public String GetName()
    {
        return m_name;
    }

    /**
     * This method returns the description that this {@code Pensum} has.
     * @return the description that this {@code Pensum} has.
     */
    public String GetDescription()
    {
        return m_description;
    }

    /**
     * This method returns the campus that this {@code Pensum} has.
     * @return the campus that this {@code Pensum} has.
     */
    public String GetCampus()
    {
        return m_campus;
    }

    /**
     * This method returns the semesters that this {@code Pensum} has.
     * @return the semesters that this {@code Pensum} has.
     */
    public int GetSemesters()
    {
        return m_semesters;
    }

    /**
     * This method returns the credits that this {@code Pensum} has.
     * @return the credits that this {@code Pensum} has.
     */
    public int GetCredits()
    {
        return m_credits;
    }

    /**
     * 
     * @return
     */
    public int GetGlobalLessonLoad()
    {
        return m_globalLessonLoad;
    }

    /**
     * This method returns the subjects that this {@code Pensum} has.
     * @return the subjects that this {@code Pensum} has.
     */
    public ArrayList<Subject> GetSubjects()
    {
        return m_subjects;
    }

    /**
     * This method sets a new name for this object {@code Pensum}.
     * @param name will be a new name of this {@code Pensum}.
     */
    public void SetName(String name)
    {
        m_name = name;
    }

    /**
     * This method sets a new description for this object {@code Pensum}.
     * @param description will be a new description of this {@code Pensum}.
     */
    public void SetDescription(String description)
    {
        m_description = description;
    }

    /**
     * This method sets a new campus for this object {@code Pensum}.
     * @param campus will be a new campus of this {@code Pensum}.
     */
    public void SetCampus(String campus)
    {
        m_campus = campus;
    }

    /**
     * This method sets a new semesters for this object {@code Pensum}.
     * @param semesters will be a new semesters of this {@code Pensum}.
     */
    public void SetSemesters(int semesters)
    {
        m_semesters = semesters;
    }

    /**
     * This method sets a new credits for this object {@code Pensum}.
     * @param globalLessonLoad will be a new credits of this {@code Pensum}.
     */
    public void SetGlobalLessonLoad(int globalLessonLoad)
    {
        m_globalLessonLoad = globalLessonLoad;
    }
    
    @Override
    public boolean AddSubject(Subject subject) throws ExceededCreditsException
    {
        if (!CanAddThisSubject(subject))
            throw new ExceededCreditsException("Créditos insufucientes...");
        else if (m_subjects.contains(subject))
            return false;
        m_credits += subject.GetCredits();
        return m_subjects.add(subject);
    }

    @Override
    public boolean RemoveSubject(Subject subject)
    {
        if (m_subjects.remove(subject))
        {
            m_credits -= subject.GetCredits();
            return true;
        }
        return false;
    }

    @Override
    public boolean CanAddThisSubject(Subject subject)
    {
        return subject.GetCredits() <= GetAvailableCredits();
    }

    @Override
    public int GetAvailableCredits()
    {
        return GetGlobalLessonLoad() - GetCredits();
    }
}