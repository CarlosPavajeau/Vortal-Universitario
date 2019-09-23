/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Point;
import java.awt.event.ActionEvent;

import Model.Admin;
import View.PanelHandler.Panels;

/**
 * 
 */
public class AdminPanel extends Panel
{
    private static final long serialVersionUID = 1369914050610515081L;

    private Admin admin;
    
    public AdminPanel()
    {
        super("BIENVENIDO ADMINISTRADOR");
        admin = null;
    }

    public void SetAdmin(Admin _admin)
    {
        admin = _admin;
    }

    public Admin GetAdmin()
    {
        return admin;
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.DATA_HANDLER_PANEL); }),
                            60);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_HANDLER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.STUDENT_HANDLER_PANEL); }), 
                            185);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_SUBJECT_HANDLER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.SUBJECT_HANDLER_PANEL); }), 
                            310);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ACADEMIC_SEMESTER_HANDLER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.ACADEMIC_SEMESTER_HANDLER_PANEL); }), 
                            435);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PENSUM_HANDLER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.PENSUM_HANDLER_PANEL); }), 
                            560);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_GROUP_HANDLER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.STUDENT_GROUP_HANDLER_PANEL); }), 
                            685);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PROFESSOR_HANDLER, 
                            (ActionEvent evt) -> { PanelHandler.ChangePanel(this, Panels.PROFESSOR_HANDLER_PANEL); }), 
                            810);
        AddButton(TypeButton.BUTTON_LOGOUT, new Point(775, 625), (ActionEvent evt) -> { ReturnToBehindPanel(); });
    }
}