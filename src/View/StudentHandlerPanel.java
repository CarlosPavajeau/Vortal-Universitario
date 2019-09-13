/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.event.ActionEvent;

import View.PanelHandler.Panels;

/**
 * 
 */
public class StudentHandlerPanel extends Panel
{
    private static final long serialVersionUID = -3622917602253841665L;

    public StudentHandlerPanel()
    {
        super("GESTIÓN DE ESTUDIANTES");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_OR_DELETE_STUDENT, (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.REGISTER_PERSON_PANEL); }), 350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_VIEW_STUDENT_SUBJECTS, null), 500);
        AddReturnButton();
    }
}