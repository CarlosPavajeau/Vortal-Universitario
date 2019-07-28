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
public class SubjectHandlerPanel extends Panel
{
    private static final long serialVersionUID = -867311560738952566L;

    public SubjectHandlerPanel()
    {
        super("GESTIÓN DE ASIGNATURAS");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_SUBJECT, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.SUBJECT_HANDLER_PANEL, Panels.REGISTER_SUBJECT_PANEL); }), 
                            350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_SUBJECT, null), 500);
        AddReturnButton();
    }

    @Override
    protected void ReturnButtonAction()
    {
        MainWindow.ChangePanel(Panels.SUBJECT_HANDLER_PANEL, Panels.ADMIN_PANEL);
    }
}