/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Admin;
import Model.Person;
import Model.Professor;
import Model.Student;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import Model.DataConnectionHandler.PersonDataHandler;

import static View.MainWindow.Panels;;

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
                            MainWindow.ChangePanel(Panels.LOGIN_PANEL, Panels.ADMIN_PANEL);
                        else
                            JOptionPane.showMessageDialog(this, "Datos incorrectos");
                        break;
                    }
                    case STUDENT:
                    {
                        dataConnectionHandler = new PersonDataHandler();
                        dataConnectionHandler.ConnectWithData();
                        Person person = new Student(user);
                        person = (Student)dataConnectionHandler.Select(person);
                        if (person != null)
                            MainWindow.ChangePanel(Panels.LOGIN_PANEL, Panels.STUDENT_PANEL);
                        else
                            JOptionPane.showMessageDialog(this, "Datos incorrectos");
                        break;
                    }
                    case PROFESSOR:
                    {
                        dataConnectionHandler = new PersonDataHandler();
                        dataConnectionHandler.ConnectWithData();
                        Person person = new Professor(user);
                        person = (Professor)dataConnectionHandler.Select(person);
                        if (person != null)
                            MainWindow.ChangePanel(Panels.LOGIN_PANEL, Panels.PROFESSOR_PANEL);
                        else
                            JOptionPane.showMessageDialog(this, "Datos incorrectos");
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
                ClearFormPanel();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Por favor digite su usuario y/o contraseña");
        }
	}

    @Override
    protected void InitPanel() 
    {
        AddReturnButton();
    }

    @Override
    protected void ReturnButtonAction()
    {
        super.ClearFormPanel();
        MainWindow.ChangePanel(Panels.LOGIN_PANEL, Panels.START_PANEL);
    }
}