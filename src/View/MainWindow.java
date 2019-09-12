/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import View.LoginPanel.TypeUser;

/**
 * 
 */
public class MainWindow extends JFrame 
{
    private static final long serialVersionUID = 9040978770256604819L;

    private static List<Panel> panels;
    private static Stack<Panel> panelsStack;
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
        panelsStack = new Stack<>();
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

    public static void LoginAction(TypeUser user)
    {
        LoginPanel loginPanel = ((LoginPanel)GetPanel(Panels.LOGIN_PANEL));
        loginPanel.SetUser(user);
        PushPanel(GetPanel(Panels.START_PANEL));
        ShowPanel(Panels.LOGIN_PANEL);   
    }

    public static void ChangePanel(Panel panelToHide, Panels panelToShow)
    {
        MainWindow.PushPanel(panelToHide);
        MainWindow.ShowPanel(panelToShow);
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

    public static void PushPanel(Panel panel)
    {
        panel.setVisible(false);
        panelsStack.push(panel);
    }

    public static void PopPanel()
    {
        panelsStack.pop().setVisible(true);
    }

    public static void HidePanel(Panel panel)
    {
        MainWindow.ChangePanelVisibilitiy(panel, false);
    }

    public static void ShowPanel(Panels panel)
    {
        MainWindow.ChangePanelVisibilitiy(GetPanel(panel), true);
    }

    private static void ChangePanelVisibilitiy(Panel panel, boolean visibility)
    {
        if (panel instanceof StartPanel)
            ((StartPanel)panel).EnableButtons();
        panel.setVisible(visibility);
    }
}