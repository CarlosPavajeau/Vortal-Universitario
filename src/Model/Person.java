/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This is the class {@code Person}, represent a person and his data as his first and 
 * second name, his last name and second last name, his age and date of birth, his 
 * sex and his login data. Derive of {@code Entity}.
 * 
 * @see {@code Entity}
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public abstract class Person extends Entity
{
    private static final long serialVersionUID = -7773874238710016793L;
    
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private byte age;
    private Calendar dateOfBorn;
    private Sex sex;
    private AccessData accessData;

    /**
     * Initialize a new {@code Person} with these characteristics.
     * As in {@code Entity} the code is unique. 
     * @param code that is to be assigned to the object. In this case, the code will be 
     * ID or DNI (T.I. - C.C.) of {@code Person}.
     * @param first_name will be the first name that have this {@code Person}.
     * @param second_name will be the second name that have this {@code Person}.
     * @param last_name will be the last name that have this {@code Person}.
     * @param second_last_name will be the second last name that have this {@code Person}.
     * @param date_of_born will be the date of born that have this {@code Person}.
     * @param _sex will be the sex that have this {@code Person}.
     */
    public Person(String code, String first_name, String second_name, String last_name, String second_last_name,
                  String date_of_born, Sex _sex)
    {
        super(code);
        firstName = first_name;
        secondName = second_name;
        lastName = last_name;
        secondLastName = second_last_name;
        GenerateDateOfBorn(date_of_born);
        SetAge();
        sex = _sex;
        accessData = new AccessData(code, code);
    }

    public Person(String code)
    {
        this(code, "", "", "", "", "0000/00/00", Sex.OTHER);
    }

    /**
     * This method returns the first name that this {@code Person} has. 
     * @return the first name that this {@code Person} has.
     */
    public String GerFirstName()
    {
        return firstName;
    }

    /**
     * This method returns the second name that this {@code Person} has. 
     * @return the second name that this {@code Person} has.
     */
    public String GetSecondName()
    {
        return secondName;
    }

    /**
     * This method returns the last name that this {@code Person} has. 
     * @return the last name that this {@code Person} has.
     */
    public String GetLastName()
    {
        return lastName;
    }

    /**
     * This method returns the second last name that this {@code Person} has. 
     * @return the second last name that this {@code Person} has.
     */
    public String GetSecondLastName()
    {
        return secondLastName;
    }

    /**
     * This method returns the age that this {@code Person} has. 
     * @return the age that this {@code Person} has.
     */
    public byte GetAge()
    {
        return age;
    }

    /**
     * This method returns the date of born that this {@code Person} has. 
     * @return the first name that this {@code Person} has.
     */
    public String GetDateOfBorn()
    {
        return dateOfBorn.toString();
    }

    /**
     * This method returns the sex that this {@code Person} has. 
     * @return the sex that this {@code Person} has.
     */
    public String GetSex()
    {
        return sex.GetSex();
    }

    /**
     * This method returns the accessData that this {@code Person} has. 
     * @return the first name that this {@code Person} has.
     */
    public AccessData GetLogin()
    {
        return accessData;
    }

    /**
     * This method sets a new first name for this object {@code Person}.
     * @param first_name will be a new first name of this {@code Person}.
     */
    public void SetFirstName(String first_name)
    {
        firstName = first_name;
    }

    /**
     * This method sets a new second name for this object {@code Person}.
     * @param second_name will be a new second name of this {@code Person}.
     */
    public void SetSecondName(String second_name)
    {
        secondName = second_name;
    }

    /**
     * This method sets a new last name for this object {@code Person}.
     * @param last_name will be a new last name of this {@code Person}.
     */
    public void SetLastName(String last_name)
    {
        lastName = last_name;
    }

    /**
     * This method sets a new second last name for this object {@code Person}.
     * @param second_last_name will be a new second last name of this {@code Person}.
     */
    public void SetSecondLastName(String second_last_name)
    {
        secondLastName = second_last_name;
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
     * @param _sex will be a new sex of this {@code Person}.
     */
    public void SetSex(Sex _sex)
    {
        sex = _sex;
    }

    /**
     * This method sets an age for this object {@code Person}.
     */
    private void SetAge()
    {
        Calendar currentlyDate = new GregorianCalendar();
        age = (byte)(currentlyDate.get(Calendar.YEAR) - dateOfBorn.get(Calendar.YEAR));
    }

    /**
     * This method sets a date of born for this object {@code Person}.
     */
    private void GenerateDateOfBorn(String date_of_born)
    {
        String[] dates = date_of_born.split("/");
        dateOfBorn = new GregorianCalendar(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]) - 1, Integer.parseInt(dates[2]));
    }
}