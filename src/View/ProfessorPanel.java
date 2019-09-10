/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

/**
 * 
 */
public class ProfessorPanel extends Panel
{
    private static final long serialVersionUID = 2311518156248267799L;
    
    public ProfessorPanel()
    {
        super("BIENVENIDO PROFESOR");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, null), 350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_HANDLER, null), 500);
        AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ReturnToBehindPanel(); });
    }
}