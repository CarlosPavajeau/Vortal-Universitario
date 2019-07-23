/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

/**
 * 
 */
public class StartPanel extends Panel
{
    private static final long serialVersionUID = -3651333001011074104L;

    public StartPanel()
    {
        super();
        initComponents();
    }

    private void initComponents()
    {
        AddButton(TypeButton.BUTTON_ICON_I_AM_ADMIN, 100, 100, null);
        AddButton(TypeButton.BUTTON_ICON_I_AM_STUDENT, 500, 100, null);
        AddButton(TypeButton.BUTTON_ICON_I_AM_PROFESSOR, 100, 400, null);
        AddButton(TypeButton.BUTTON_EXIT, 775, 625, (ActionEvent evt) -> { ExitButtonAction(evt); });
    }

    private void ExitButtonAction(ActionEvent evt)
    {
        System.exit(0);
    }
}