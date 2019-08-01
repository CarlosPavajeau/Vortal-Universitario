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
public class RegisterStudentGroupPanel extends FormPanel 
{

    private static final long serialVersionUID = -1599400795264602650L;

    public RegisterStudentGroupPanel()
    {
        super("REGISTRO DE GRUPO DE ESTUDIANTES");
    }

    @Override
    protected void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el número del grupo", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Número del grupo: ", 50, 150);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {

    }

    @Override
    protected void ReturnButtonAction() 
    {
        super.ReturnButtonAction();
        MainWindow.ChangePanel(Panels.REGISTER_STUDENT_GROUP_PANEL, Panels.STUDENT_GROUP_HANDLER_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
		
	}
    
}