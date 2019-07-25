/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

/**
 * This is the class {@code Subject}, represents a subject, has a code that 
 * represents it, in addition to the credits it grants when it is approved by 
 * a {@code Student} and the semester where it is recommended 
 * to a {@code Student } register it.
 * Derive of {@code Entity}.
 * 
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Subject extends Entity
{
    private static final long serialVersionUID = -3463036382757628148L;
    
    private String m_name;
    private int m_credits;
    private int m_recommendedSemester;

     /**
     * Initialize a new {@code Subject} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param code that is to be assigned to the object.
     * @param name it will be the name of the subject.
     * @param credits will be the number of credits of the subject.
     * @param recommendedSemester will be te recommended semester of the subject.
     */
    public Subject(String code, String name, int credits, int recommendedSemester)
    {
        super(code);
        m_name = name;
        m_credits = credits;
        m_recommendedSemester = recommendedSemester;
    }

    /**
     * Initialize a new {@code Subject} empty.
     */
    public Subject()
    {
        this("", "", 0, 0);
    }

    /**
     * This method returns the name that has this {@code Subject}.
     * @return the code that has this {@code Subject}.
     */
    public String GetName()
    {
        return m_name;
    }

    /**
     * This method returns the credits that has this {@code Subject}.
     * @return the credits that has this {@code Subject}.
     */
    public int GetCredits()
    {
        return m_credits;
    }

    /**
     * This method returns the recommender semester that has this
     * {@code Subject}.
     * @return the recommender semester that has this {@code Subject}.
     */
    public int GetRecommendedSemester()
    {
        return m_recommendedSemester;
    }

    /**
     * This method sets a new name for this {@code Subject}.
     * @param name will be a new name of this {@code Subject}.
     */
    public void SetName(String name)
    {
        m_name = name;
    }

    /**
     * This method sets a new credits for this {@code Subject}.
     * @param credits will be a new credits of this object {@code Subject}.
     */
    public void SetCredits(int credits)
    {
        m_credits = credits;
    }

    /**
     * This method sets a recommended new semester for this {@code Subject}.
     * @param recommendedSemester will be a recommended new semester of 
     * this object {@code Subject}.
     */
    public void SetRecommendedSemester(int recommendedSemester)
    {
        m_recommendedSemester = recommendedSemester;
    }
}
