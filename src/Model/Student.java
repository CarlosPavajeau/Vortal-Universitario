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
     * @param qualifications will be the qualification that will have this {@code Student}.
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

    public Student(String code)
    {
        super(code);
    }

    public float GetGeneralAverage()
    {
        return generalAverage;
    }

    public int GetRegisteredCredits()
    {
        return registeredCredits;
    }

    public int GetCurrentSemester()
    {
        return currentSemester;
    }

    public float GetSemesterAverage(int semester) throws IndexOutOfBoundsException
    {
        return GetSemesterAverage().get(semester-1);
    }

    public ArrayList<Float> GetSemesterAverage()
    {
        return semesterAverage;
    }

    public float GetQualification(Subject subject, int cort) throws IndexOutOfBoundsException
    {
        float[] notes = GetQualifications(subject);

        return notes == null ? 0.0f : notes[cort];
    }

    public float[] GetQualifications(Subject subject)
    {
        Qualification _qualification = qualifications.stream()
                .filter(qualification -> qualification.GetSubject().equals(subject))
                .findAny()
                .orElse(null);
        
        return _qualification == null ? null : _qualification.GetNotes();
    }

    public ArrayList<Qualification> GetCurseSubjects()
    {
        return curseSubjects;
    }

    public boolean MatriculateIn(String pensum)
    {
        if (isMatriculateIn == null || !isMatriculateIn.isEmpty())
            return false;
        isMatriculateIn = pensum;
        return true;
    }

    public boolean IsMatriculateIn(String pensum)
    {
        return pensum.equals(isMatriculateIn);
    }

    public String PensumCode()
    {
        return isMatriculateIn;
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
        return 0;
    }

    public void UpdateGeneralAverage()
    {
        float newAverage = 0.0f;
        newAverage = semesterAverage.stream().map((average) -> average).reduce(newAverage, (accumulator, _item) -> accumulator + _item);
        newAverage /= semesterAverage.size();
        generalAverage = newAverage;
    }

    public void AddNewSemesterAverage()
    {
        float newSemesterAverage = 0.0f;
        newSemesterAverage = qualifications.stream().map((qualification) -> 
                qualification.GetAverage() * (qualification.GetSubject().GetCredits() / GetRegisteredCredits()))
                .reduce(newSemesterAverage, (accumulator, _item) -> accumulator + _item);
        semesterAverage.add(newSemesterAverage);
    }

    public void UpdateCurrentSemester()
    {
        ++currentSemester;
    }
}