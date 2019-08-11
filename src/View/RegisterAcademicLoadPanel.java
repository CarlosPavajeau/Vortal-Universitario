/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Professor;
import Model.Subject;
import Model.TypeGroup;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.PersonDataHandler;
import Model.DataConnectionHandler.SubjectDataHandler;
import View.MainWindow.Panels;

/**
 * 
 */
public class RegisterAcademicLoadPanel extends FormPanel
{
    private static final long serialVersionUID = -2738404143820514135L;

    public RegisterAcademicLoadPanel()
    {
        super("REGISTRO Y ASIGNACIÓN DE CARGA ACADEMICA");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el código del profesor", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código del profesor: ", 50, 150);
        AddField(new TextField(300, 50, "Digite el código de la asignatura", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código de la asignatura: ", 400, 150);
        AddField(new TextField(300, 50, "Digite el número del grupo", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Número del grupo: ", 50, 250);
        AddField(new TextField(300, 50, "Digite el límite de estudiantes", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Límite de estudiantes: ", 400, 250);
        AddRadioButtons("Tipo de grupo: ", 50, 400, "Mañana", "Tarde", "Noche");
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {
        if (ValidateFields() && ValidateRadioButtons())
        {
            try 
            {
                DataConnectionHandler dataConnectionHandler = new PersonDataHandler();
                DataConnectionHandler subjectConnectionHandler = new SubjectDataHandler();
                Subject subject = null;
                Professor professor = null;
                if (!dataConnectionHandler.ConnectWithData() || !subjectConnectionHandler.ConnectWithData())
                {
                    System.err.println("ERROR, NO EXISTEN DATOS");
                }

                subject = (Subject)subjectConnectionHandler.Select(new Subject(GetSubjectCode()));
                if (subject != null)
                {
                    professor = (Professor)dataConnectionHandler.Select(new Professor(GetProfessorCode()));
                    if (professor != null)
                    {
                        if (professor.AddAcademicLoad(GetGroupNumber(), GetLimitOfStudents(), GetTypeGroup(), subject))
                        {
                            JOptionPane.showMessageDialog(this, "Carga academica agregada con exito");
                            ClearFormPanel();
                            MainWindow.ChangePanel(Panels.REGISTER_ACADEMIC_LOAD_PANEL, Panels.PROFESSOR_HANDLER_PANEL);
                        }
                        else
                            JOptionPane.showMessageDialog(this, "El profesor ya posee la carga academica digitada");
                    }
                }
                dataConnectionHandler.Update(professor);
                dataConnectionHandler.CloseDataConnection();
                subjectConnectionHandler.CloseDataConnection();

            } catch (ClassNotFoundException | SQLException | IOException exception)
            {
                exception.printStackTrace();
            }
            catch (ClassCastException exception)
            {
                JOptionPane.showMessageDialog(this, "ERROR, El codigo digitado no corresponde con un profesor");   
            }
        }
	}

    @Override
    protected void ReturnButtonAction()
    {
        super.ReturnButtonAction();
        MainWindow.ChangePanel(Panels.REGISTER_ACADEMIC_LOAD_PANEL, Panels.PROFESSOR_HANDLER_PANEL);   
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    private String GetProfessorCode()
    {
        return GetContentField(0);
    }

    private String GetSubjectCode()
    {
        return GetContentField(1);
    }

    private int GetGroupNumber()
    {
        return GetIntContentField(2);
    }

    private int GetLimitOfStudents()
    {
        return GetIntContentField(3);
    }

    private TypeGroup GetTypeGroup()
    {
        return (GetRadioButtons().get(0).isSelected()) ? TypeGroup.MORNING : 
               (GetRadioButtons().get(1).isSelected() ? TypeGroup.AFTERNOON : TypeGroup.EVENING);
    }
}