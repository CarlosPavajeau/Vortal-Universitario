/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

/**
 * 
 */
public class StudentGroupHandlerPanel extends Panel
{

    private static final long serialVersionUID = 7617256835103697946L;

    public StudentGroupHandlerPanel()
    {
        super("GESTIÓN DE GRUPOS DE ESTUDIANTE");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_STUDENTGROUP, null), 500);
        AddReturnButton();
    }
}