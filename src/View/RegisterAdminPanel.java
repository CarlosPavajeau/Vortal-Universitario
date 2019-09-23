/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Point;
import java.awt.event.ActionEvent;

import Model.Admin;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import View.ErrorPanel.TypeError;
import View.PanelHandler.Panels;
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
        AddField(new TextField("Digite su ID", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Identificación: ", new Point( 50, 150));
        AddField(new TextField("Digite su usuario", TextField.OBLIGATORY_FIELD), "Usuario: ", new Point(50, 250));
        AddField(new PasswordField("Digite su contraseña"), "Contraseña: ", new Point(50, 350));
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
                    setVisible(false);
                    PanelHandler.ShowPanel(Panels.START_PANEL);
                }
            } 
            catch (Exception exeption)
            {
                ErrorPanel.ShowError(TypeError.CONNECTION_ERROR);
                System.out.println(exeption.getMessage());
                exeption.printStackTrace();
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
        AddButton(TypeButton.BUTTON_EXIT, new Point(50, 600), (ActionEvent evt) -> { Exit(evt); });
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