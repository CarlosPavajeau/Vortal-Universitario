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
public class AcademicSemesterHandlerPanel extends Panel
{
    private static final long serialVersionUID = -2196951048169048566L;

    public AcademicSemesterHandlerPanel()
    {
        super("GESTIÓN DE SEMESTRES ACAEMICOS");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_ACADEMIC_SEMESTER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(this, Panels.REGISTER_ACADEMIC_SEMESTER_PANEL); } ), 
                            350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_ACADEMIC_SEMESTER, null), 500);
        AddReturnButton();
    }
}