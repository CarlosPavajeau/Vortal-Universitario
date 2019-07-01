/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.ArrayList;

/**
 * This is the class {@code Student}, represent a Student. Derive of {@code Person}.
 * @see {@code Person}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Student extends Person
{
    private ArrayList<Qualification> m_qualifications;
    private ArrayList<Float> m_semesterAverage;
    private float m_generalAverage;
    private int m_registeredCredits;
    private int m_currentSemester;
    private String m_isMatriculateIn;

    /**
     * Initialize a new {@code Student} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Student}.
     * @param firstName will be the first name that will have this {@code Student}.
     * @param secondName will be the second name that will have this {@code Student}.
     * @param lastName will be the last name that will have this {@code Student}.
     * @param secondLastName will be the second last name that will have this {@code Student}.
     * @param dateOfBorn will be the date of born that will have this {@code Student}.
     * @param sex will be the sex that will have this {@code Student}.
     */
    public Student(String code, String firstName, String secondName, String lastName, String secondLastName,
                   String dateOfBorn, String sex)
    {
        this(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex, null, null, 0.0f, 0, 0, "");
    }

    /**
     * Initialize a new {@code Student} with these characteristics.
     * As in {@code Student} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Student}.
     * @param firstName will be the first name that will have this {@code Student}.
     * @param secondName will be the second name that will have this {@code Student}.
     * @param lastName will be the last name that will have this {@code Student}.
     * @param secondLastName will be the second last name that will have this {@code Student}.
     * @param dateOfBorn will be the date of born that will have this {@code Student}.
     * @param sex will be the sex that will have this {@code Student}.
     * @param qualifications will be the qualificationx that will have this {@code Student}.
     * @param semesterAverage will be the semester average that will have this {@code Student}.
     * @param generalAverage will be the general average that will have this {@code Student}.
     * @param registeredCredits will be the registered credits that will have this {@code Student}.
     * @param currentSemester will be the current semester that will have this {@code Student}.
     * @param isMatriculateIn will be the pensum where this {@code Student} be matriculate.
     */
    public Student(String code, String firstName, String secondName, String lastName, String secondLastName,
                   String dateOfBorn, String sex, ArrayList<Qualification> qualifications, ArrayList<Float> semesterAverage,
                   float generalAverage, int registeredCredits, int currentSemester, String isMatriculateIn)
    {
        super(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex);
        m_qualifications = (qualifications != null) ? qualifications : new ArrayList<>();
        m_semesterAverage = (semesterAverage != null) ? semesterAverage : new ArrayList<>();
        m_generalAverage = generalAverage;
        m_registeredCredits = registeredCredits;
        m_currentSemester = currentSemester;
        m_isMatriculateIn = isMatriculateIn;
    }

    /**
     * This method returns the general average that this {@code Student} has. 
     * @return the general average that this {@code Student} has.
     */
    public float GetGeneralAverage()
    {
        return m_generalAverage;
    }

    /**
     * This method returns the registered credits that this {@code Student} has. 
     * @return the registered credits that this {@code Student} has.
     */
    public int GetRegisteredCredits()
    {
        return m_registeredCredits;
    }

    /**
     * This method returns the current semester that this {@code Student} has. 
     * @return the current semester that this {@code Student} has.
     */
    public int GetCurrentSemester()
    {
        return m_currentSemester;
    }

    /**
     * This method returns the average of a semester that has this {@code Student}.
     * @param semester corresponds to the semester where you want to consult the average.
     * @return The average of the specified semester 
     * that has this {@code Student}, if it has it.
     * @throws IndexOutOfBoundsException
     */
    public float GetSemesterAverage(int semester) throws IndexOutOfBoundsException
    {
        return GetSemesterAverage().get(semester-1).floatValue();
    }

    /**
     * This method returns all the semester averages that this {@code Student} has. 
     * @return All the semester averages that this {@code Student} has.
     */
    public ArrayList<Float> GetSemesterAverage()
    {
        return m_semesterAverage;
    }

    /**
     * This method returns one qualification that correspond with 
     * one {@code Subject} and one academic cut.
     * @return the current semester that this {@code Student} has.
     */
    public float GetQualification(Subject subject, int cort) throws IndexOutOfBoundsException
    {
        return m_qualifications.get(m_qualifications.indexOf(new Qualification(subject))).GetNote(cort);
    }

    /**
     * 
     * @param generalAverage
     */
    public void SetGeneralAverage(float generalAverage)
    {
        m_generalAverage = generalAverage;
    }

    /**
     * This method registers this {@code Student} in a Pensum.
     * @param pensum it is the code of the Pensum where to register this {@code Student}
     * @return {@code true} if this {@code Student} was not registered in a Pensum.
     * {@code false} otherwise.
     */
    public boolean MatriculateIn(String pensum)
    {
        if (m_isMatriculateIn == null || !m_isMatriculateIn.isEmpty())
            return false;
        m_isMatriculateIn = pensum;
        return true;
    }

    /**
     * This method validates if this {@code Student} belongs to this Pensum. 
     * @param pensum is the Pensum code to validate.
     * @return {@code true} if this {@code Student} is registered in the Pensum. 
     * {@code false} otherwise.
     */
    public boolean IsMatriculateIn(String pensum)
    {
        return pensum.equals(m_isMatriculateIn);
    }

    /**
     * This method adds a new {@code Subject} for this {@code Student}.
     * @param subject the {@code Subject} to add.
     * @return {@code true} if this {@code Student} does not have the {@code Subject} 
     * and can register the {@code Subject}, that is, have credits available.
     * {@code false} otherwise.
     */
    public boolean MatriculateSubject(Subject subject)
    {
        Qualification qualification = new Qualification(subject);
        if (m_qualifications.contains(qualification) || !CanRegisterThisSubject(subject))
            return false;
        m_registeredCredits += qualification.GetSubject().GetCredits();
        return m_qualifications.add(qualification);
    }

    /**
     * This method removes one {@code Subject} that has this {@code Student}.
     * @param subject the {@code Subject} to remove.
     * @return {@code true} if this {@code Student} has the subject. 
     * {@code false} otherwise.
     */
    public boolean CancelSubject(Subject subject)
    {
        Qualification qualification = m_qualifications.get(m_qualifications.indexOf(new Qualification(subject)));
        if (qualification.HasNotes())
            return false;
        m_registeredCredits -= qualification.GetSubject().GetCredits();
        return m_qualifications.remove(qualification);
    }

    /**
     * This method updates the general average of this {@code Student}.
     */
    public void UpdateGeneralAverage()
    {
        float newAverage = 0.0f;
        for (Float average : m_semesterAverage)
            newAverage += average.floatValue();
        newAverage /= m_semesterAverage.size();
        SetGeneralAverage(newAverage);
    }

    /**
     * This method adds a new semester average for this {@code Student}.
     */
    public void AddNewSemesterAverage()
    {
        float newSemesterAverage = 0.0f;
        for (Qualification qualification : m_qualifications)
            newSemesterAverage += qualification.GetAverage() * (qualification.GetSubject().GetCredits() / GetRegisteredCredits());
        m_semesterAverage.add(Float.valueOf(newSemesterAverage));
    }

    /**
     * This method updates the current semester of this {@code Student}.
     */
    public void UpdateCurrentSemester()
    {
        ++m_currentSemester;
    }

    /**
     * This method validates if this {@code Student} can register a more {@code Subject}.
     * @param subject the {@code Subject} to validate.
     * @return {@code true} if this {@code Student} has available credits.
     * {@code false} otherwise. 
     */
    private boolean CanRegisterThisSubject(Subject subject)
    {
        return subject.GetCredits() <= GetAvailableCredits();
    }

    /**
     * This method returns the available credits that has this {@code Student}.
     * @return the available credits tha has this {@code Student}.
     */
    private int GetAvailableCredits()
    {
        AcademicSemester academicSemester = new AcademicSemester(GetCurrentSemester(), 0, 0);
        return academicSemester.GetMaxCredits() - GetRegisteredCredits();
    }
}