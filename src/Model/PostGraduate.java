/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code PostGraduate}, represent a Postgraduate pensum. 
 * Derive of {@code Pensum}.
 * @see {@code Pensum}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class PostGraduate extends Pensum
{
    private String m_requiredTitle;

    /**
     * Initialize a new {@code PostGraduate} with these characteristics.
     * As in {@code PostGraduate} the code is unique. 
     * @param code that is to be assigned to the object.
     * @param name it will be the name of the {@code PostGraduate}.
     * @param description will be the description of the {@code PostGraduate}.
     * @param campus it will be the campus where {@code PostGraduate} belongs.
     * @param semesters duration in semesters of {@code PostGraduate}.
     * @param credits minimum credits required or global credits of the {@code PostGraduate}.
     * @param subjects subjects that belong or will belong to this {@code PostGraduate}.
     * @param requiredTitle it will the required title.
     */
    public PostGraduate(String code, String name, String description, String campus, int semesters, int credits, ArrayList<Subject> subjects, String requiredTitle)
    {
        super(code, name, description, campus, semesters, credits, subjects);
        m_requiredTitle = requiredTitle;
    }

    /**
     * This method returns the required title that has this {@code PostGraduate}.
     * @return the required title that has this {@code PostGraduate}.
     */
    public String GetRequiredTitle()
    {
        return m_requiredTitle;
    }

    /**
     * This method sets a new required title for this object {@code PostGraduate}.
     * @param requiredTitle will be a new required title of this {@code PostGraduate}.
     */
    public void SetRequiredTitle(String requiredTitle)
    {
        m_requiredTitle = requiredTitle;
    }
}