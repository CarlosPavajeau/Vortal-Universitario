/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.util.ArrayList;

import Model.Exceptions.ExceededCreditsException;

/**
 * This is the class {@code Student}, it represents a student with 
 * his attributes such as his qualifications, averages and other data that a
 * university student has. Derive of {@code Person}.
 * 
 * @see {@code Person}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Student extends Person implements SubjectHandler
{
    private static final long serialVersionUID = 188478517140819571L;
    
    private ArrayList<Qualification> qualifications;
    private ArrayList<Qualification> curseSubjects;
    private ArrayList<Float> semesterAverage;
    private float generalAverage;
    private int registeredCredits;
    private int currentSemester;
    private String isMatriculateIn;

    /**
     * Initialize a new {@code Student} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Student}.
     * @param first_name will be the first name that will have this {@code Student}.
     * @param second_name will be the second name that will have this {@code Student}.
     * @param last_name will be the last name that will have this {@code Student}.
     * @param secon_last_name will be the second last name that will have this {@code Student}.
     * @param date_of_born will be the date of born that will have this {@code Student}.
     * @param _sex will be the _sex that will have this {@code Student}.
     */
    public Student(String code, String first_name, String second_name, String last_name, String secon_last_name,
                   String date_of_born, Sex _sex)
    {
        this(code, first_name, second_name, last_name, secon_last_name, date_of_born, _sex, null, null, null, 0.0f, 0, 0, "");
    }

    /**
     * Initialize a new {@code Student} with these characteristics.
     * As in {@code Student} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Student}.
     * @param first_name will be the first name that will have this {@code Student}.
     * @param second_name will be the second name that will have this {@code Student}.
     * @param last_name will be the last name that will have this {@code Student}.
     * @param secon_last_name will be the second last name that will have this {@code Student}.
     * @param date_of_born will be the date of born that will have this {@code Student}.
     * @param _sex will be the _sex that will have this {@code Student}.
     * @param qualifications will be the qualificationx that will have this {@code Student}.
     * @param semesterAverage will be the semester average that will have this {@code Student}.
     * @param general_average will be the general average that will have this {@code Student}.
     * @param registered_credits will be the registered credits that will have this {@code Student}.
     * @param current_semester will be the current semester that will have this {@code Student}.
     * @param is_matriculate_in will be the pensum where this {@code Student} be matriculate.
     */
    public Student(String code, String first_name, String second_name, String last_name, String secon_last_name,
                   String date_of_born, Sex _sex, ArrayList<Qualification> qualifications, ArrayList<Qualification> curseSubjects, ArrayList<Float> semesterAverage,
                   float general_average, int registered_credits, int current_semester, String is_matriculate_in)
    {
        super(code, first_name, second_name, last_name, secon_last_name, date_of_born, _sex);
        qualifications = (qualifications != null) ? qualifications : new ArrayList<>();
        curseSubjects = (curseSubjects != null) ? curseSubjects : new ArrayList<>();
        semesterAverage = (semesterAverage != null) ? semesterAverage : new ArrayList<>();
        generalAverage = general_average;
        registeredCredits = registered_credits;
        currentSemester = current_semester;
        isMatriculateIn = is_matriculate_in;
    }

    /**
     * 
     * @param code
     */
    public Student(String code)
    {
        super(code);
    }

    /**
     * This method returns the general average that this {@code Student} has. 
     * @return the general average that this {@code Student} has.
     */
    public float GetGeneralAverage()
    {
        return generalAverage;
    }

    /**
     * This method returns the registered credits that this {@code Student} has. 
     * @return the registered credits that this {@code Student} has.
     */
    public int GetRegisteredCredits()
    {
        return registeredCredits;
    }

    /**
     * This method returns the current semester that this {@code Student} has. 
     * @return the current semester that this {@code Student} has.
     */
    public int GetCurrentSemester()
    {
        return currentSemester;
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
        return semesterAverage;
    }

    /**
     * This method returns one qualification that correspond with 
     * one {@code Subject} and one academic cut.
     * @return the current semester that this {@code Student} has.
     */
    public float GetQualification(Subject subject, int cort) throws IndexOutOfBoundsException
    {
        return qualifications.get(qualifications.indexOf(new Qualification(subject))).GetNote(cort);
    }

    /**
     * This method returns all cursed subjects if this {@code Student}.
     * @return all cursed subjects of this {@code Student}.
     */
    public ArrayList<Qualification> GetCurseSubjects()
    {
        return curseSubjects;
    }

    /**
     * 
     * @param general_average
     */
    public void SetGeneralAverage(float general_average)
    {
        generalAverage = general_average;
    }

    /**
     * This method registers this {@code Student} in a Pensum.
     * @param pensum it is the code of the Pensum where to register this {@code Student}
     * @return {@code true} if this {@code Student} was not registered in a Pensum.
     * {@code false} otherwise.
     */
    public boolean MatriculateIn(String pensum)
    {
        if (isMatriculateIn == null || !isMatriculateIn.isEmpty())
            return false;
        isMatriculateIn = pensum;
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
        return pensum.equals(isMatriculateIn);
    }

    @Override
    public boolean AddSubject(Subject subject) throws ExceededCreditsException
    {
        if (!CanAddThisSubject(subject))
            throw new ExceededCreditsException("Créditos insuficientes...");

        Qualification qualification = new Qualification(subject);
        if (qualifications.contains(qualification))
            return false;
        registeredCredits += qualification.GetSubject().GetCredits();
        return qualifications.add(qualification);
    }

    @Override
    public boolean RemoveSubject(Subject subject)
    {
        Qualification qualification = qualifications.get(qualifications.indexOf(new Qualification(subject)));
        if (qualification.HasNotes())
            return false;
        registeredCredits -= qualification.GetSubject().GetCredits();
        return qualifications.remove(qualification);
    }

    @Override
    public boolean CanAddThisSubject(Subject subject)
    {
        return subject.GetCredits() <= GetAvailableCredits();
    }

    @Override
    public int GetAvailableCredits()
    {
        AcademicSemester academicSemester = new AcademicSemester(GetCurrentSemester(), 0, 0);
        return academicSemester.GetMaximumCredits() - GetRegisteredCredits();
    }

    /**
     * This method updates the general average of this {@code Student}.
     */
    public void UpdateGeneralAverage()
    {
        float newAverage = 0.0f;
        for (Float average : semesterAverage)
            newAverage += average.floatValue();
        newAverage /= semesterAverage.size();
        SetGeneralAverage(newAverage);
    }

    /**
     * This method adds a new semester average for this {@code Student}.
     */
    public void AddNewSemesterAverage()
    {
        float newSemesterAverage = 0.0f;
        for (Qualification qualification : qualifications)
            newSemesterAverage += qualification.GetAverage() * (qualification.GetSubject().GetCredits() / GetRegisteredCredits());
        semesterAverage.add(Float.valueOf(newSemesterAverage));
    }

    /**
     * This method updates the current semester of this {@code Student}.
     */
    public void UpdateCurrentSemester()
    {
        ++currentSemester;
    }
}