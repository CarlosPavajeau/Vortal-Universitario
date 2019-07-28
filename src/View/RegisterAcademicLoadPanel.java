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
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {
		
	}

    @Override
    protected void ReturnButtonAction()
    {
        MainWindow.ChangePanel(Panels.REGISTER_ACADEMIC_LOAD_PANEL, Panels.PROFESSOR_HANDLER_PANEL);   
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }
}