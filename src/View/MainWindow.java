/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import View.LoginPanel.TypeUser;
import View.RegisterPersonPanel.TypePerson;

/**
 * 
 */
public class MainWindow extends JFrame 
{
    private static final long serialVersionUID = 9040978770256604819L;

    private static List<Panel> panels;
    public static final MainWindow mainWindow = new MainWindow();
    private JPanel mainPanel;

    public static enum Panels
    {
        START_PANEL,
        STUDENT_PANEL,
        PROFESSOR_PANEL,
        ADMIN_PANEL,
        LOGIN_PANEL,
        REGISTER_ACADEMIC_LOAD_PANEL,
        REGISTER_ACADEMIC_SEMESTER_PANEL,
        REGISTER_ADMIN_PANEL,
        REGISTER_NOTES_PANEL,
        REGISTER_PENSUM_PANEL,
        REGISTER_PERSON_PANEL,
        REGISTER_SUBJECT_PANEL,
        DATA_HANDLER_PANEL,
        STUDENT_HANDLER_PANEL,
        PROFESSOR_HANDLER_PANEL,
        SUBJECT_HANDLER_PANEL,
        PENSUM_HANDLER_PANEL,
        ACADEMIC_SEMESTER_HANDLER_PANEL,
        STUDENT_GROUP_HANDLER_PANEL
    }

    public MainWindow() 
    {
        super();
        initComponents();
        InitPanels();
        Start();
    }

    private void initComponents() 
    {
        panels = new ArrayList<>();
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vortal Universitario");
        setBackground(Color.WHITE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }

    private void InitFormPanels()
    {
        panels.add(new RegisterAcademicLoadPanel());
        panels.add(new RegisterAcademicSemesterPanel());
        panels.add(new RegisterAdminPanel());
        panels.add(new RegisterNotesPanel());
        panels.add(new RegisterPensumPanel());
        panels.add(new RegisterPersonPanel());
        panels.add(new RegisterSubjectPanel());
    }

    private void InitHandlingPanels()
    {
        panels.add(new DataHandlerPanel());
        panels.add(new StudentHandlerPanel());
        panels.add(new ProfessorHandlerPanel());
        panels.add(new SubjectHandlerPanel());
        panels.add(new PensumHandlerPanel());
        panels.add(new AcademicSemesterHandlerPanel());
        panels.add(new StudentGroupHandlerPanel());
    }

    private void InitPanels()
    {
        panels.add(new StartPanel());
        panels.add(new StudentPanel());
        panels.add(new ProfessorPanel());
        panels.add(new AdminPanel());
        panels.add(new LoginPanel());
        InitFormPanels();
        InitHandlingPanels();
        AddPanels();
    }

    private void AddPanels()
    {
        for (Panel panel : panels)
        {
            panel.setVisible(false);
            add(panel);
        }
    }
    
    private void Start()
    {
        try 
        {
            DataConnectionHandler dataConnectionHandler = new LoginDataHandler("Admin.dat");
            if (!dataConnectionHandler.ConnectWithData())
            {
                dataConnectionHandler.CreateDataConnection();
                dataConnectionHandler.CloseDataConnection();
                MainWindow.ShowPanel(Panels.REGISTER_ADMIN_PANEL);
            }
            else
                MainWindow.ShowPanel(Panels.START_PANEL);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
		}
    }

    public static void ShowPopUpWindow(String title, String message, int messageType, Icon icon)
    {
        JOptionPane.showMessageDialog(mainWindow, message, title, messageType, icon);
    }

    public static void LoginAction(ActionEvent evt, TypeUser user)
    {
        ((LoginPanel)GetPanel(Panels.LOGIN_PANEL)).SetUser(user);
        MainWindow.ChangePanel(Panels.START_PANEL, Panels.LOGIN_PANEL);   
    }

    public static void ChangePanel(Panels from, Panels to)
    {
        if (to == Panels.REGISTER_PERSON_PANEL)
        {
            RegisterPersonPanel personPanel = (RegisterPersonPanel)GetPanel(to);

            if (from == Panels.PROFESSOR_HANDLER_PANEL)
                personPanel.SetTypePerson(TypePerson.PROFESSOR);
            else
                personPanel.SetTypePerson(TypePerson.STUDENT);
        }

        MainWindow.HidePanel(from);
        MainWindow.ShowPanel(to);
    }

    public static Panel GetPanel(Panels panel)
    {
        try
        {
            return panels.get(panel.ordinal());
        }
        catch (IndexOutOfBoundsException exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    private static void HidePanel(Panels panel)
    {
        MainWindow.ChangePanelVisibilitiy(panel, false);
    }

    private static void ShowPanel(Panels panel)
    {
        MainWindow.ChangePanelVisibilitiy(panel, true);
    }

    private static void ChangePanelVisibilitiy(Panels panel, boolean visibility)
    {
        try
        {
            Panel aPanel = GetPanel(panel);

            if (aPanel instanceof StartPanel)
                ((StartPanel)aPanel).EnableButtons();

            aPanel.setVisible(visibility);
        }
        catch (IndexOutOfBoundsException exception)
        {
            exception.printStackTrace();
        }
    }
}