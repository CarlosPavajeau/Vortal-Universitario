/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.AcademicSemester;
import Model.DataConnectionHandler.AcademicSemesterDataHandler;
import Model.DataConnectionHandler.DataConnectionHandler;
import View.MainWindow.Panels;

/**
 * 
 */
public class RegisterAcademicSemesterPanel extends FormPanel
{
    private static final long serialVersionUID = 6848182874437906997L;

    public RegisterAcademicSemesterPanel()
    {
        super("REGISTRO DE SEMESTRE ACADEMICO");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el número del semestre", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Número de semeste: ", 50, 150);
        AddField(new TextField(300, 50, "Digite los créditos mínimos", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Créditos mínimos: ", 50, 250);
        AddField(new TextField(300, 50, "Digite los créditos máximos", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Cŕeditos máximos: ", 400, 250);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {
        if (ValidateFields())
        {
            try
            {
                int semester, minCredits, maxCredits;

                semester = GetSemester();
                minCredits = GetMinCredits();
                maxCredits = GetMaxCredits();

                if ((maxCredits > 0 && minCredits > 0) || maxCredits >= minCredits)
                {
                    AcademicSemester academicSemester = new AcademicSemester(semester, maxCredits, minCredits);
                    DataConnectionHandler dataConnectionHandler = new AcademicSemesterDataHandler();

                    if (SaveData(academicSemester, dataConnectionHandler))
                    {
                        JOptionPane.showMessageDialog(this, "Semestre académico registrado con éxito!");
                        MainWindow.ChangePanel(Panels.REGISTER_ACADEMIC_SEMESTER_PANEL, Panels.ACADEMIC_SEMESTER_HANDLER_PANEL);
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Semestre académico ya registrado");

                    ClearFormPanel();
                }
                else
                    JOptionPane.showMessageDialog(this, "Campos inválidos, revise el número de créditos");
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Campos inválidos");
	}

    @Override
    protected void ReturnButtonAction() 
    {
        super.ReturnButtonAction();
        MainWindow.ChangePanel(Panels.REGISTER_ACADEMIC_SEMESTER_PANEL, Panels.ACADEMIC_SEMESTER_HANDLER_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    private int GetSemester() 
    {
        return Integer.valueOf(GetContentField(0));
    }

    private int GetMinCredits()
    {
        return Integer.valueOf(GetContentField(1));
    }

    private int GetMaxCredits() 
    {
        return Integer.valueOf(GetContentField(2));    
    }
}