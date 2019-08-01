/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Admin;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import View.MainWindow.Panels;

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
                DataConnectionHandler dataConnectionHandler = new LoginDataHandler("Admin.dat");
                dataConnectionHandler.CreateDataConnection();

                String code, user, password;
                code = GetContentField(0);
                user = GetContentField(1);
                password = GetContentField(2);
                Admin admin = new Admin(code, user, password);
                dataConnectionHandler.Insert(admin);
                dataConnectionHandler.CloseDataConnection();
                ClearFormPanel();
                JOptionPane.showMessageDialog(this, "Registro de administrador exitoso!");
                MainWindow.ChangePanel(Panels.REGISTER_ADMIN_PANEL, Panels.START_PANEL);
            } 
            catch (Exception exception)
            {
                Exit(null);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Campos invalidos");
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
}