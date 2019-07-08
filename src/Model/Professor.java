/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code Professor}, represents a university professor who in 
 * addition to the data of a person has academic loads. Derived from {@code Person}.
 * 
 * @see {@code Person}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Professor extends Person
{
    ArrayList<AcademicLoad> m_academicLoads;

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
     * @param numsGroup will be the numbers of the groups of academic charges.
     * @param limitsOfStudents it will be the limit of students in each group.
     * @param typesGroup it will be the group type of each group.
     * @param subjects it will be the subject of each group.
     */
    public Professor(String code, String firstName, String secondName, String lastName, String secondLastName,
                     String dateOfBorn, String sex, int[][] numGroups, int[][] limitOfStudents, String[][] typeGroups, 
                     Subject[] subjects)
    {
        super(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex);
        m_academicLoads = new ArrayList<>();
        if (subjects != null && subjects.length > 0)
        {
            for (int i = 0; i < subjects.length; ++i)
                m_academicLoads.add(new AcademicLoad(numGroups[i], limitOfStudents[i], typeGroups[i], subjects[i]));
        }
    }

    /**
     * This method returns the academic loads that this {@code Professor} has. 
     * @return the academic loads that this {@code Professor} has.
     */
    public ArrayList<AcademicLoad> GetAcademicLoads()
    {
        return m_academicLoads;
    }

    /**
     * This method assigns a new academic load for this {@code Professor}.
     * @param numsGroup will be the numbers of the groups of academic loads.
     * @param limitsOfStudents it will be the limit of students in each group.
     * @param typesGroup it will be the group type of each group.
     * @param subject it will be the subject in all groups.
     * @return {@code true} if this {@code Professor} did not have this {@code AcademicLoad}.
     * {@code false} otherwise.
     */
    public boolean AddAcademicLoad(int[] numsGroup, int[] limitsOfStudents, String[] typesGroup, Subject subject)
    {
        AcademicLoad academicCharge = new AcademicLoad(numsGroup, limitsOfStudents, typesGroup, subject);
        if (GetAcademicLoads().contains(academicCharge))
            return false;
        return GetAcademicLoads().add(academicCharge);
    }

    /**
     * This method eliminates an academic load from this {@code Professor}. 
     * Only deletes a {@code StudentGroup}, if you want to eliminate all the {@code AcademicLoad} related to a subject, 
     * look at the overloaded method.
     * @param numGroup it will be the number of the group to be eliminated.
     * @param subject it will be the subject related to the group to be eliminated.
     * @return {@code true} if this {@code Professor} have this {@code AcademicLoad}.
     * {@code false} otherwise.
     */
    public boolean RemoveAcademicLoad(int numGroup, Subject subject)
    {
        return false;
    }

    /**
     * This method eliminates an academic load from this {@code Professor}. 
     * delete all groups related to this subject.
     * @param subject it will be the subject related to the group to be eliminated.
     * @return {@code true} if this {@code Professor} have this {@code AcademicLoad}.
     * {@code false} otherwise.
     */
    public boolean RemoveAcademicLoad(Subject subject)
    {
        return false;
    }
}