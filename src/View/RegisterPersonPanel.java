/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import Model.Person;
import Model.Professor;
import Model.Sex;
import Model.Student;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.PersonDataHandler;
import View.ErrorPanel.TypeError;
import View.SuccesPanel.TypeSucces;
import View.WarningPanel.TypeWarning;

/**
 * 
 */
public class RegisterPersonPanel extends FormPanel
{
    private static final long serialVersionUID = 4949141375919823301L;

    public static enum TypePerson
    {
        STUDENT,
        PROFESSOR
    }
    
    private TypePerson m_typePerson;

    public RegisterPersonPanel()
    {
        super("REGISTRO DE PERSONA");
        m_typePerson = TypePerson.STUDENT;
    }

    public TypePerson GetTypePerson()
    {
        return m_typePerson;
    }

    public void SetTypePerson(TypePerson typePerson)
    {
        m_typePerson = typePerson;
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite su ID", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Identificación: ", 50, 150);
        AddField(new TextField(300, 50, "Digite su primer nombre", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Nombres/Apellidos: ", 50, 250);
        AddField(new TextField(300, 50, "Digite su segundo nombre", TextField.ALPHA_FIELD), "", 400, 250);
        AddField(new TextField(300, 50, "Digite su primer apellido", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "", 50, 315);
        AddField(new TextField(300, 50, "Digite su segundo apellido", TextField.ALPHA_FIELD), "", 400, 315);
        AddField(new TextField(200, 50, "aaaa/mm/dd", TextField.OBLIGATORY_FIELD + TextField.DATE_FIELD), "Fecha de nacimiento: ", 50, 415);
        AddRadioButtons("Sexo: ", 400, 415, "Masculino", "Femenino", "Otro");
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (ValidateFields() && ValidateRadioButtons())
        {
            try 
            {
                Person person = (GetTypePerson() == TypePerson.PROFESSOR) ? 
                            new Professor(GetCode(), GetFirstName(), GetSecondName(), GetLastName(), 
                                          GetSecondLastName(), GetDateOfBorn(), GetSex()) : 
                            new Student(GetCode(), GetFirstName(), GetSecondName(), GetLastName(), 
                                        GetSecondLastName(), GetDateOfBorn(), GetSex());

                DataConnectionHandler dataConnectionHandler = new PersonDataHandler();
                 
                if (SaveData(person, dataConnectionHandler))
                    SuccesPanel.ShowSucces(TypeSucces.REGISTERED_PERSON);
                else
                    WarningPanel.ShowWarning(TypeWarning.PERSON_ALREADY_REGISTERED);

            } catch (Exception exception) 
            {
                ErrorPanel.ShowError(TypeError.CONNECTION_ERROR);
            }
            finally
            {
                ClearAndReturnToBehindPanel();
            }
        }
        else
            WarningPanel.ShowWarning(TypeWarning.INVALID_FIELDS);
    }
    
    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    private String GetCode()
    {
        return GetContentField(0);
    }

    private String GetFirstName()
    {
        return GetContentField(1);
    }

    private String GetSecondName()
    {
        return GetContentField(2);
    }

    private String GetLastName()
    {
        return GetContentField(3);
    }

    private String GetSecondLastName()
    {
        return GetContentField(4);
    }

    private String GetDateOfBorn()
    {
        return GetContentField(5);
    }

    private Sex GetSex()
    {
        return (GetRadioButtons().get(0).isSelected() ? Sex.MALE : 
               (GetRadioButtons().get(1).isSelected() ? Sex.FEMALE : Sex.OTHER));
    }
}