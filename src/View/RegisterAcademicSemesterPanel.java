/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

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
		
	}

    @Override
    protected void ReturnButtonAction() 
    {
        MainWindow.ChangePanel(Panels.REGISTER_ACADEMIC_SEMESTER_PANEL, Panels.ACADEMIC_SEMESTER_HANDLER_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }
}