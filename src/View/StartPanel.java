/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import View.LoginPanel.TypeUser;

/**
 * 
 */
public class StartPanel extends Panel
{
    private static final long serialVersionUID = -3651333001011074104L;

    public StartPanel()
    {
        super("BIENVENIDO, SELECIONE LA OPCIÓN QUE DESEE");
    }

    @Override
    protected void InitPanel()
    {
        Button imProfessorButton = new Button(TypeButton.BUTTON_ICON_I_AM_PROFESSOR, (ActionEvent evt) -> { MainWindow.LoginAction(evt, TypeUser.PROFESSOR); });
        Button imStudentButton = new Button(TypeButton.BUTTON_ICON_I_AM_STUDENT, (ActionEvent evt) -> { MainWindow.LoginAction(evt, TypeUser.STUDENT); });
        Button imAdminButton = new Button(TypeButton.BUTTON_ICON_I_AM_ADMIN, (ActionEvent evt) -> { MainWindow.LoginAction(evt, TypeUser.ADMIN); });
        AddComponent(imProfessorButton, 100, 100);
        AddComponent(imStudentButton, 700, 100);
        AddCenterComponentX(imAdminButton, 400);
        AddButton(TypeButton.BUTTON_EXIT, 775, 625, (ActionEvent evt) -> { ExitButtonAction(evt); });
    }

    private void ExitButtonAction(ActionEvent evt)
    {
        System.exit(0);
    }
}