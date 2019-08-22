/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import Model.Admin;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import View.ErrorPanel.TypeError;
import View.MainWindow.Panels;
import View.SuccesPanel.TypeSucces;
import View.WarningPanel.TypeWarning;

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
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (ValidateFields())
        {
            try
            {
                String code, user, password;
                code = GetCode();
                user = GetUser();
                password = GetPassword();

                Admin admin = new Admin(code, user, password);
                DataConnectionHandler dataConnectionHandler = new LoginDataHandler("Admin.dat");
                
                if (SaveData(admin, dataConnectionHandler))
                {
                    SuccesPanel.ShowSucces(TypeSucces.REGISTERED_ADMIN);
                    ClearFormPanel();
                    MainWindow.ChangePanel(Panels.REGISTER_ADMIN_PANEL, Panels.START_PANEL);
                }
            } 
            catch (Exception exception)
            {
                ErrorPanel.ShowError(TypeError.CONNECTION_ERROR);
                Exit(null);
            }
        }
        else
            WarningPanel.ShowWarning(TypeWarning.INVALID_FIELDS);
    }

    private void Exit(ActionEvent evt)
    {
        System.exit(0);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
        AddButton(TypeButton.BUTTON_EXIT, 50, 600, (ActionEvent evt) -> { Exit(evt); });
    }

    private String GetCode()
    {
        return GetContentField(0);
    }

    private String GetUser()
    {
        return GetContentField(1);
    }

    private String GetPassword()
    {
        return GetContentField(2);
    }
}