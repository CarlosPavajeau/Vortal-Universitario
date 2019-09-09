/*
 * Copyright (C) 2019 Carlos Pavajeau
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
    
    private String name;
    private int credits;
    private int recommendedSemester;

     /**
     * Initialize a new {@code Subject} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param _code that is to be assigned to the object.
     * @param _name it will be the name of the subject.
     * @param _credits will be the number of credits of the subject.
     * @param recommended_semester will be te recommended semester of the subject.
     */
    public Subject(String _code, String _name, int _credits, int recommended_semester)
    {
        super(_code);
        name = _name;
        credits = _credits;
        recommendedSemester = recommended_semester;
    }

    /**
     * 
     * @param code
     */
    public Subject(String code)
    {
        this(code, "", 0, 0);
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
        return name;
    }

    /**
     * This method returns the credits that has this {@code Subject}.
     * @return the credits that has this {@code Subject}.
     */
    public int GetCredits()
    {
        return credits;
    }

    /**
     * This method returns the recommender semester that has this
     * {@code Subject}.
     * @return the recommender semester that has this {@code Subject}.
     */
    public int GetRecommendedSemester()
    {
        return recommendedSemester;
    }

    /**
     * This method sets a new name for this {@code Subject}.
     * @param _name will be a new name of this {@code Subject}.
     */
    public void SetName(String _name)
    {
        name = _name;
    }

    /**
     * This method sets a new credits for this {@code Subject}.
     * @param credits will be a new credits of this object {@code Subject}.
     */
    public void SetCredits(int _credits)
    {
        credits = _credits;
    }

    /**
     * This method sets a recommended new semester for this {@code Subject}.
     * @param recommended_semester will be a recommended new semester of 
     * this object {@code Subject}.
     */
    public void SetRecommendedSemester(int recommended_semester)
    {
        recommendedSemester = recommended_semester;
    }
}
