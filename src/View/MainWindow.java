/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
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

    private static List<Panel> m_panels;
    private JPanel m_mainPanel;

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
        ACADEMIC_SEMESTER_HANDLER_PANEL
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
        m_panels = new ArrayList<>();
        m_mainPanel = new JPanel();
        setContentPane(m_mainPanel);
        m_mainPanel.setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vortal Universitario");
        setBackground(Color.WHITE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }

    private void InitFormPanels()
    {
        m_panels.add(new RegisterAcademicLoadPanel());
        m_panels.add(new RegisterAcademicSemesterPanel());
        m_panels.add(new RegisterAdminPanel());
        m_panels.add(new RegisterNotesPanel());
        m_panels.add(new RegisterPensumPanel());
        m_panels.add(new RegisterPersonPanel());
        m_panels.add(new RegisterSubjectPanel());
    }

    private void InitHandlingPanels()
    {
        m_panels.add(new DataHandlerPanel());
        m_panels.add(new StudentHandlerPanel());
        m_panels.add(new ProfessorHandlerPanel());
        m_panels.add(new SubjectHandlerPanel());
        m_panels.add(new PensumHandlerPanel());
        m_panels.add(new AcademicSemesterHandlerPanel());
    }

    private void InitPanels()
    {
        m_panels.add(new StartPanel());
        m_panels.add(new StudentPanel());
        m_panels.add(new ProfessorPanel());
        m_panels.add(new AdminPanel());
        m_panels.add(new LoginPanel());
        InitFormPanels();
        InitHandlingPanels();
        AddPanels();
    }

    private void AddPanels()
    {
        for (Panel panel : m_panels)
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

    public static void LoginAction(ActionEvent evt, TypeUser user)
    {
        LoginPanel loginPanel = (LoginPanel)m_panels.get(4);
        loginPanel.SetUser(user);
        MainWindow.ChangePanel(Panels.START_PANEL, Panels.LOGIN_PANEL);   
    }

    public static void ChangePanel(Panels i, Panels j)
    {
        MainWindow.HidePanel(i);
        MainWindow.ShowPanel(j);
    }

    private static void HidePanel(Panels i)
    {
        MainWindow.ChangePanelVisibilitiy(i, false);
    }

    private static void ShowPanel(Panels j)
    {
        MainWindow.ChangePanelVisibilitiy(j, true);
    }

    private static void ChangePanelVisibilitiy(Panels i, boolean visibility)
    {
        try
        {
            m_panels.get(i.ordinal()).setVisible(visibility);
        }
        catch (IndexOutOfBoundsException exception)
        {

        }
    }
}