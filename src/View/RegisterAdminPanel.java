/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

/**
 * 
 */
public class RegisterAdminPanel extends FormPanel
{
    private static final long serialVersionUID = 6118942589914143575L;
    
    public RegisterAdminPanel()
    {
        super("REGISTRO DE ADMINISTRADOR");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite su ID", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Identificación: ", 50, 150);
        AddField(new TextField(300, 50, "Digite su usuario", TextField.OBLIGATORY_FIELD), "Usuario: ", 50, 250);
        AddField(new PasswordField(300, 50, "Digite su contraseña"), "Contraseña: ", 50, 350);
        AddButton(TypeButton.BUTTON_REGISTER, 750, 600, (ActionEvent evt) -> { RegisterButton(evt); });
    }

    public void RegisterButton(ActionEvent evt)
    {
        if (!ValidateFields())
            System.out.println("Error: Campos invalidos");
    }
}