/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import View.MainWindow.Panels;

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
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_OR_DELETE_STUDENT, null), 350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_VIEW_STUDENT_SUBJECTS, null), 500);
        AddReturnButton();
    }

    @Override
    protected void ReturnButtonAction()
    {
        MainWindow.ChangePanel(Panels.STUDENT_HANDLER_PANEL, Panels.ADMIN_PANEL);
    }
}