/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code Professor}, represent a professor or a teacher. Derive of {@code Person}.
 * @see {@code Person}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Professor extends Person
{
    ArrayList<AcademicCharge> m_academicCharges;

    /**
     * Initialize a new {@code Professor} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Professor}.
     * @param firstName will be the first name that have this {@code Professor}.
     * @param secondName will be the second name that have this {@code Professor}.
     * @param lastName will be the last name that have this {@code Professor}.
     * @param secondLastName will be the second last name that have this {@code Professor}.
     * @param dateOfBorn will be the date of born that have this {@code Professor}.
     * @param sex will be the sex that have this {@code Professor}.
     */
    public Professor(String code, String firstName, String secondName, String lastName, String secondLastName,
                  String dateOfBorn, String sex)
    {
        this(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex, null, null, null, null);
    }

    /**
     * Initialize a new {@code Professor} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Professor}.
     * @param firstName will be the first name that have this {@code Professor}.
     * @param secondName will be the second name that have this {@code Professor}.
     * @param lastName will be the last name that have this {@code Professor}.
     * @param secondLastName will be the second last name that have this {@code Professor}.
     * @param dateOfBorn will be the date of born that have this {@code Professor}.
     * @param sex will be the sex that have this {@code Professor}.
     * @param numsGroup
     * @param limitsOfStudents
     * @param typesGroup
     * @param subjects
     */
    public Professor(String code, String firstName, String secondName, String lastName, String secondLastName,
                     String dateOfBorn, String sex, int[][] numsGroup, int[][] limitsOfStudents, String[][] typesGroup, 
                     Subject[] subjects)
    {
        super(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex);
        m_academicCharges = new ArrayList<>();
        if (subjects != null && subjects.length > 0)
        {
            for (int i = 0; i < subjects.length; ++i)
                m_academicCharges.add(new AcademicCharge(numsGroup[i], limitsOfStudents[i], typesGroup[i], subjects[i]));
        }
    }

    public ArrayList<AcademicCharge> GetAcademicCharges()
    {
        return m_academicCharges;
    }

    /**
     * 
     * @param numsGroup
     * @param limitsOfStudents
     * @param typesGroup
     * @param subject
     * @return
     */
    public boolean AddAcademicCharge(int[] numsGroup, int[] limitsOfStudents, String[] typesGroup, Subject subject)
    {
        AcademicCharge academicCharge = new AcademicCharge(numsGroup, limitsOfStudents, typesGroup, subject);
        if (GetAcademicCharges().contains(academicCharge))
            return false;
        return GetAcademicCharges().add(academicCharge);
    }

    /**
     * 
     * @param numGroup
     * @param limitOfStudents
     * @param typeGroup
     * @param subject
     * @return
     */
    public boolean RemoveAcademicCharge(int numGroup, int limitOfStudents, String typeGroup, Subject subject)
    {
        return false;
    }
}