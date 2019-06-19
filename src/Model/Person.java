/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This is the class {@code Person}, represent a Person. Derive of {@code Entity}.
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Person extends Entity
{
    private String m_firstName;
    private String m_secondName;
    private String m_lastName;
    private String m_secondLastName;
    private byte m_age;
    private Calendar m_dateOfBorn;
    private Sex m_sex;
    private Login m_login;

    /**
     * Initialize a new {@code Person} with these characteristics.
     * As in {@code Person} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Person}.
     * @param firstName will be the first name that have this {@code Person}.
     * @param secondName will be the second name that have this {@code Person}.
     * @param lastName will be the last name that have this {@code Person}.
     * @param secondLastName will be the second last name that have this {@code Person}.
     * @param dateOfBorn will be the date of born that have this {@code Person}.
     * @param sex will be the sex that have this {@code Person}.
     */
    public Person(String code, String firstName, String secondName, String lastName, String secondLastName,
                  String dateOfBorn, String sex)
    {
        super(code);
        m_firstName = firstName;
        m_secondName = secondName;
        m_lastName = lastName;
        m_secondLastName = secondLastName;
        GenerateDateOfBorn(dateOfBorn);
        SetAge();
        m_sex = GenerateSex(sex);
        m_login = new Login(code, code);
    }

    /**
     * This method returns the first name that this {@code Person} has. 
     * @return the first name that this {@code Person} has.
     */
    public String GerFirstName()
    {
        return m_firstName;
    }

    /**
     * This method returns the second name that this {@code Person} has. 
     * @return the second name that this {@code Person} has.
     */
    public String GetSecondName()
    {
        return m_secondName;
    }

    /**
     * This method returns the last name that this {@code Person} has. 
     * @return the last name that this {@code Person} has.
     */
    public String GetLastName()
    {
        return m_lastName;
    }

    /**
     * This method returns the second last name that this {@code Person} has. 
     * @return the second last name that this {@code Person} has.
     */
    public String GetSecondLastName()
    {
        return m_secondLastName;
    }

    /**
     * This method returns the age that this {@code Person} has. 
     * @return the age that this {@code Person} has.
     */
    public byte GetAge()
    {
        return m_age;
    }

    /**
     * This method returns the date of born that this {@code Person} has. 
     * @return the first name that this {@code Person} has.
     */
    public String GetDateOfBorn()
    {
        return m_dateOfBorn.toString();
    }

    /**
     * This method returns the sex that this {@code Person} has. 
     * @return the sex that this {@code Person} has.
     */
    public String GetSex()
    {
        return m_sex.GetSex();
    }

    /**
     * This method returns the login that this {@code Person} has. 
     * @return the first name that this {@code Person} has.
     */
    public Login GetLogin()
    {
        return m_login;
    }

    /**
     * This method sets a new first name for this object {@code Person}.
     * @param firstName will be a new first name of this {@code Person}.
     */
    public void SetFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    /**
     * This method sets a new second name for this object {@code Person}.
     * @param secondName will be a new second name of this {@code Person}.
     */
    public void SetSecondName(String secondName)
    {
        m_secondName = secondName;
    }

    /**
     * This method sets a new last name for this object {@code Person}.
     * @param lastName will be a new last name of this {@code Person}.
     */
    public void SetLastName(String lastName)
    {
        m_lastName = lastName;
    }

    /**
     * This method sets a new second last name for this object {@code Person}.
     * @param secondLastName will be a new second last name of this {@code Person}.
     */
    public void SetSecondLastName(String secondLastName)
    {
        m_secondLastName = secondLastName;
    }

    /**
     * This method sets a new date of born for this object {@code Person}. 
     * Then it establishes a new age.
     * @param dateOfBorn will be a new name of this {@code Person}.
     * @see {@link #SetAge() SetAge()}
     */
    public void SetDateOfBorn(String dateOfBorn)
    {
        GenerateDateOfBorn(dateOfBorn);
        SetAge();
    } 

    /**
     * This method sets a new sex for this object {@code Person}.
     * @param sex will be a new sex of this {@code Person}.
     */
    public void SetSex(String sex)
    {
        m_sex = GenerateSex(sex);
    }

    /**
     * This method sets an age for this object {@code Person}.
     */
    private final void SetAge()
    {
        Calendar currentlyDate = new GregorianCalendar();
        m_age = (byte)(currentlyDate.get(Calendar.YEAR) - m_dateOfBorn.get(Calendar.YEAR));
    }

    /**
     * This method sets a date of born for this object {@code Person}.
     */
    private final void GenerateDateOfBorn(String dateOfBorn)
    {
        String[] dates = dateOfBorn.split("/");
        m_dateOfBorn = new GregorianCalendar(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]) - 1, Integer.parseInt(dates[2]));
    }

    /**
     * This method generates and return a one type sex.
     */
    private final Sex GenerateSex(String sex)
    {
        if (Sex.MALE.GetSex().toUpperCase().equals(sex.toUpperCase()))
            return Sex.MALE;
        else if (Sex.FEMALE.GetSex().toUpperCase().equals(sex.toUpperCase()))
            return Sex.FEMALE;
        else
            return Sex.OTHER;
    }
}