/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

/**
 * 
 */
public class LoginPanel extends FormPanel
{
    private static final long serialVersionUID = -6911695528579363916L;

    public LoginPanel()
    {
        super("INICIO DE SESIÓN");
    }

    @Override
    protected void InitFields() 
    {
        AddCenterField(new TextField(300, 50, "Digite su usuario", TextField.OBLIGATORY_FIELD), "Usuario: ", 150);
        AddCenterField(new PasswordField(300, 50, "Digite su contraseña"), "Contraseña: ", 250);
        AddCenterComponentX(new Button(TypeButton.BUTTON_LOGIN, ((ActionEvent evt) -> { RegisterButtonAction(evt); })), 600);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {

	}
}