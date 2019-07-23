/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

/**
 * 
 */
public class StudentPanel extends Panel
{
    private static final long serialVersionUID = 7107309620859913470L;
    
    public StudentPanel()
    {
        super();
        initComponents();
    }

    private void initComponents()
    {
        AddButton(TypeButton.BUTTON_ICON_SUBJECT_HANDLER, 50, 100, null);
        AddButton(TypeButton.BUTTON_ICON_DATA_MANAGER, 200, 100, null);
        AddButton(TypeButton.BUTTON_ICON_VIEW_PROGRESS, 350, 100, null);
        AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, null);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ACCESS_DATA_MANAGER, null), 500);
    }
}