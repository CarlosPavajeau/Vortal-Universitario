/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import Model.Admin;
import Model.Person;
import Model.Professor;
import Model.Student;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import Model.DataConnectionHandler.PersonDataHandler;

import static View.MainWindow.Panels;
import static View.WarningPanel.TypeWarning;

/**
 * 
 */
public class LoginPanel extends FormPanel
{
    private static final long serialVersionUID = -6911695528579363916L;

    public enum TypeUser
    {
        ADMIN,
        PROFESSOR,
        STUDENT
    }

    private TypeUser m_user;

    public LoginPanel()
    {
        super("INICIO DE SESIÓN");
    }

    public void SetUser(TypeUser user)
    {
        m_user = user;
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
        if (ValidateFields())
        {
            DataConnectionHandler dataConnectionHandler = null;
            String user, password;
            user = String.valueOf(GetFields().get(0).getPassword());
            password = String.valueOf(GetFields().get(1).getPassword());
            
            try
            {
                switch (m_user)
                {
                    case ADMIN:
                    {
                        dataConnectionHandler = new LoginDataHandler("Admin.dat");
                        dataConnectionHandler.ConnectWithData();
                        Admin admin = new Admin("", user, password);
                        admin = (Admin)dataConnectionHandler.Select(admin);
                        if (admin != null)
                        {
                            AdminPanel adminPanel = (AdminPanel)MainWindow.GetPanel(Panels.ADMIN_PANEL);
                            adminPanel.SetAdmin(admin);
                            MainWindow.ChangePanel(this, Panels.ADMIN_PANEL);
                        }
                        else
                            WarningPanel.ShowWarning(TypeWarning.INVALID_DATA);
                        break;
                    }
                    case STUDENT:
                    case PROFESSOR:
                    {
                        dataConnectionHandler = new PersonDataHandler();
                        dataConnectionHandler.ConnectWithData();
                        Person person = (m_user == TypeUser.STUDENT) ? new Student(user) : new Professor(user);

                        person = (Person)dataConnectionHandler.Select(person);
                        
                        if (person != null)
                        {
                            MainWindow.PushPanel(this);
                            MainWindow.ShowPanel((m_user == TypeUser.STUDENT) ? Panels.STUDENT_PANEL : 
                                                                                Panels.PROFESSOR_PANEL);
                        }
                        else
                            WarningPanel.ShowWarning(TypeWarning.INVALID_DATA);
                        break;
                    }
                    default:
                        return;
                }
            }
            catch (Exception exception)
            {

            }
            finally
            {
                ClearAndReturnToBehindPanel();
            }
        }
        else
            WarningPanel.ShowWarning(TypeWarning.INVALID_FIELDS);
	}

    @Override
    protected void InitPanel() 
    {
        AddReturnButton();
    }
}