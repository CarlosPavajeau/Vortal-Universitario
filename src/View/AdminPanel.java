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
public class AdminPanel extends Panel
{
    private static final long serialVersionUID = 1369914050610515081L;
    
    public AdminPanel()
    {
        super("BIENVENIDO ADMINISTRADOR");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.DATA_HANDLER_PANEL); }),
                            60);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_HANDLER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.STUDENT_HANDLER_PANEL); }), 
                            185);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_SUBJECT_HANDLER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.SUBJECT_HANDLER_PANEL); }), 
                            310);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ACADEMIC_SEMESTER_HANDLER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.ACADEMIC_SEMESTER_HANDLER_PANEL); }), 
                            435);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PENSUM_HANDLER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.PENSUM_HANDLER_PANEL); }), 
                            560);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_GROUP_HANDLER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.STUDENT_GROUP_HANDLER_PANEL); }), 
                            685);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PROFESSOR_HANDLER, 
                            (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.PROFESSOR_HANDLER_PANEL); }), 
                            810);
        AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { MainWindow.ChangePanel(Panels.ADMIN_PANEL, Panels.START_PANEL); });
    }
}