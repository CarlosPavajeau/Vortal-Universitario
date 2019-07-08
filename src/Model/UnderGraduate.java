/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code UnderGraduate}, it represents an undergraduate pensum, in which 
 * a degree is awarded when it is approved in its entirety.
 * 
 * Derive of {@code Pensum}.
 * 
 * @see {@code Pensum}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class UnderGraduate extends Pensum
{
    private String m_titleToGrand;

    /**
     * Initialize a new {@code UnderGraduate} with these characteristics.
     * As in {@code UnderGraduate} the code is unique. 
     * @param code that is to be assigned to the object.
     * @param name it will be the name of the {@code UnderGraduate}.
     * @param description will be the description of the {@code UnderGraduate}.
     * @param campus it will be the campus where {@code UnderGraduate} belongs.
     * @param semesters duration in semesters of {@code UnderGraduate}.
     * @param globalLessonLoad minimum credits required or global credits of the {@code UnderGraduate}.
     * @param subjects subjects that belong or will belong to this {@code UnderGraduate}.
     * @param titleToGrand it will the title to grand.
     */
    public UnderGraduate(String code, String name, String description, String campus, int semesters, int globalLessonLoad, ArrayList<Subject> subjects, String titleToGrand)
    {
        super(code, name, description, campus, semesters, globalLessonLoad, subjects);
        m_titleToGrand = titleToGrand;
    }

    /**
     * This method returns the title to grand that has this {@code UnderGraduate}.
     * @return the title to grand that has the {@code UnderGraduate}.
     */
    public String GetTitleToGrand()
    {
        return m_titleToGrand;
    }

    /**
     * This method sets a new title to grand for this object {@code UnderGraduate}.
     * @param titleToGrand will be a new title to grand of this {@code UnderGraduate}.
     */
    public void SetTitleToGrand(String titleToGrand)
    {
        m_titleToGrand = titleToGrand;
    }
}