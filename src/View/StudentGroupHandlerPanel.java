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
public class StudentGroupHandlerPanel extends Panel
{

    private static final long serialVersionUID = 7617256835103697946L;

    public StudentGroupHandlerPanel()
    {
        super("GESTIÓN DE GRUPOS DE ESTUDIANTE");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_STUDENT_GROUP, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.STUDENT_GROUP_HANDLER_PANEL, Panels.REGISTER_STUDENT_GROUP_PANEL); }), 
                            350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_STUDENTGROUP, null), 500);
        AddReturnButton();
    }

    @Override
    protected void ReturnButtonAction()
    {
        MainWindow.ChangePanel(Panels.STUDENT_GROUP_HANDLER_PANEL, Panels.ADMIN_PANEL);
    }
    
}