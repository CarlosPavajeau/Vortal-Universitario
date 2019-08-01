/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Person;
import Model.Professor;
import Model.Student;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.PersonDataHandler;
import View.MainWindow.Panels;

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
        AddField(new TextField(200, 50, "aaaa/mm/dd", TextField.OBLIGATORY_FIELD), "Fecha de nacimiento: ", 50, 415);
        AddRadioButton("Masculino", 400, 415);
        AddRadioButton("Femenino", 520, 415);
        AddRadioButton("Otro", 640, 415);
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (ValidateFields() && ValidateRadioButtons())
        {
            try 
            {
                DataConnectionHandler dataConnectionHandler = new PersonDataHandler();
                if (!dataConnectionHandler.ConnectWithData())
                    dataConnectionHandler.CreateDataConnection();
                dataConnectionHandler.ConnectWithData();

                Person e = (GetTypePerson() == TypePerson.PROFESSOR) ? 
                            new Professor(GetCode(), GetFirstName(), GetSecondName(), GetLastName(), 
                                          GetSecondLastName(), GetDateOfBorn(), GetSex()) : 
                            new Student(GetCode(), GetFirstName(), GetSecondName(), GetLastName(), 
                                        GetSecondLastName(), GetDateOfBorn(), GetSex());
                
                if (dataConnectionHandler.Insert(e))
                {
                    JOptionPane.showMessageDialog(this, "Registro de persona exitoso");
                    MainWindow.ChangePanel(Panels.REGISTER_PERSON_PANEL, Panels.ADMIN_PANEL);
                    dataConnectionHandler.CloseDataConnection();
                    ClearFormPanel();
                }
                else
                    JOptionPane.showMessageDialog(this, "Estudiante/Professor ya registrado");

            } catch (Exception exception) 
            {
                exception.printStackTrace();
                ClearFormPanel();
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Campos invalidos");
    }

    @Override
    protected void ReturnButtonAction() 
    {
        ClearFormPanel();
        MainWindow.ChangePanel(Panels.REGISTER_PERSON_PANEL, Panels.ADMIN_PANEL);
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

    private String GetSex()
    {
        if (GetRadioButtons().get(0).isSelected())
            return "Masculino";
        else if (GetRadioButtons().get(1).isSelected())
            return "Femenino";
        else if (GetRadioButtons().get(2).isSelected())
            return "Otro";
        else 
            return null;
    }
}