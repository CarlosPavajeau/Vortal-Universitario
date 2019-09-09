/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code PostGraduate}, it represents a postgraduate pensum, in which 
 * a degree is previously required to be enrolled in it.
 * Derive of {@code Pensum}.
 * 
 * @see {@code Pensum}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class PostGraduate extends Pensum
{
    private static final long serialVersionUID = -7189561827535755483L;
    
    private String requiredTitle;

    /**
     * Initialize a new {@code PostGraduate} with these characteristics.
     * As in {@code PostGraduate} the code is unique. 
     * @param code that is to be assigned to the object.
     * @param name it will be the name of the {@code PostGraduate}.
     * @param description will be the description of the {@code PostGraduate}.
     * @param campus it will be the campus where {@code PostGraduate} belongs.
     * @param semesters duration in semesters of {@code PostGraduate}.
     * @param globalLessonLoad minimum credits required or global credits of the {@code PostGraduate}.
     * @param subjects subjects that belong or will belong to this {@code PostGraduate}.
     * @param requiredTitle it will the required title.
     */
    public PostGraduate(String code, String name, String description, String campus, int semesters, int globalLessonLoad, ArrayList<Subject> subjects, String required_title)
    {
        super(code, name, description, campus, semesters, globalLessonLoad, subjects);
        requiredTitle = required_title;
    }

    /**
     * This method returns the required title that has this {@code PostGraduate}.
     * @return the required title that has this {@code PostGraduate}.
     */
    public String GetRequiredTitle()
    {
        return requiredTitle;
    }

    /**
     * This method sets a new required title for this object {@code PostGraduate}.
     * @param required_title will be a new required title of this {@code PostGraduate}.
     */
    public void SetRequiredTitle(String required_title)
    {
        requiredTitle = required_title;
    }
}