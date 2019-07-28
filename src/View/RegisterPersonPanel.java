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
    
    public RegisterPersonPanel()
    {
        super("REGISTRO DE PERSONA");
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
        AddField(new TextField(200, 50, "Digite el sexo", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Sexo: ", 400, 415);
        AddField(new TextField(200, 50, "Digite el tipo de persona (Estudiante/Profesor)", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Tipo: ", 50, 515);
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (ValidateFields())
        {
            try 
            {
                DataConnectionHandler dataConnectionHandler = new PersonDataHandler();
                if (!dataConnectionHandler.ConnectWithData())
                {
                    dataConnectionHandler.CreateDataConnection();
                }
                dataConnectionHandler.ConnectWithData();
                String code, firstName, secondName, lastName, secondLastName, sex, dateOfBorn;

                code = GetContentField(0);
                firstName = GetContentField(1);
                secondName = GetContentField(2);
                lastName = GetContentField(3);
                secondLastName = GetContentField(4);
                dateOfBorn = GetContentField(5);
                sex = GetContentField(6);

                Person e = (GetContentField(7).equals("Profesor")) ? 
                            new Professor(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex) : 
                            new Student(code, firstName, secondName, lastName, secondLastName, dateOfBorn, sex);

                if (dataConnectionHandler.Insert(e))
                {
                    MainWindow.ChangePanel(Panels.REGISTER_PERSON_PANEL, Panels.ADMIN_PANEL);
                    dataConnectionHandler.CloseDataConnection();
                }
                else
                    JOptionPane.showMessageDialog(this, "Estudiante/Professor ya registrado");
                    
                ClearFields();
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void ReturnButtonAction() 
    {
        MainWindow.ChangePanel(Panels.REGISTER_PERSON_PANEL, Panels.ADMIN_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }
}