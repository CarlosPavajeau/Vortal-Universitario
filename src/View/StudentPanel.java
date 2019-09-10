/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

/**
 * 
 */
public class StudentPanel extends Panel
{
    private static final long serialVersionUID = 7107309620859913470L;
    
    public StudentPanel()
    {
        super("BIENVENIDO ESTUDIANTE");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_SUBJECT_HANDLER, null), 275);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, null), 425);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_VIEW_PROGRESS, null), 575);
        AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ReturnToBehindPanel(); });
    }
}