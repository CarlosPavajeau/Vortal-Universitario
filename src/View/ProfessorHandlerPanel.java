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
public class ProfessorHandlerPanel extends Panel
{
    private static final long serialVersionUID = -6594487691959497282L;

    public ProfessorHandlerPanel()
    {
        super("GESTIÓN DE PROFESORES");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_PROFESSOR, (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.PROFESSOR_HANDLER_PANEL, Panels.REGISTER_PERSON_PANEL); }), 200);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_PROFESSOR, null), 350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_SUBJECT, null), 500);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_SUBJECT, null), 650);
        AddReturnButton();
    }

    @Override
    protected void ReturnButtonAction()
    {
        MainWindow.ChangePanel(Panels.PROFESSOR_HANDLER_PANEL, Panels.ADMIN_PANEL);
    }
}