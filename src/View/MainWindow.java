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
        REGISTER_SUBJECT_PANEL
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

    private void InitPanels()
    {
        InitStartPanel();
        InitStudentPanel();
        InitProfessorPanel();
        InitAdminPanel();
        InitLoginPanel();
        InitFormPanels();
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

    private void InitStartPanel()
    {
        Panel startPanel = new StartPanel();
        Button imProfessorButton = new Button(TypeButton.BUTTON_ICON_I_AM_PROFESSOR, (ActionEvent evt) -> { LoginAction(evt, TypeUser.PROFESSOR); });
        Button imStudentButton = new Button(TypeButton.BUTTON_ICON_I_AM_STUDENT, (ActionEvent evt) -> { LoginAction(evt, TypeUser.STUDENT); });
        Button imAdminButton = new Button(TypeButton.BUTTON_ICON_I_AM_ADMIN, (ActionEvent evt) -> { LoginAction(evt, TypeUser.ADMIN); });
        startPanel.AddComponent(imProfessorButton, 100, 100);
        startPanel.AddComponent(imStudentButton, 700, 100);
        startPanel.AddCenterComponentX(imAdminButton, 400);
        m_panels.add(startPanel);
    }

    private void InitStudentPanel()
    {
        Panel studentPanel = new StudentPanel();
        studentPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_SUBJECT_HANDLER, null), 275);
        studentPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, null), 425);
        studentPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_VIEW_PROGRESS, null), 575);
        studentPanel.AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ChangePanel(Panels.STUDENT_PANEL, Panels.START_PANEL); });
        m_panels.add(studentPanel);
    }

    private void InitProfessorPanel()
    {
        Panel professorPanel = new ProfessorPanel();
        professorPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, null), 350);
        professorPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_HANDLER, null), 500);
        professorPanel.AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ChangePanel(Panels.PROFESSOR_PANEL, Panels.START_PANEL); });
        m_panels.add(professorPanel);
    }

    private void InitAdminPanel()
    {
        Panel adminPanel = new AdminPanel();
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, null), 60);
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_HANDLER, null), 185);
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_SUBJECT_HANDLER, null), 310);
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ACADEMIC_SEMESTER_HANDLER, null), 435);
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PENSUM_HANDLER, null), 560);
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_GROUP_HANDLER, null), 685);
        adminPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PROFESSOR_HANDLER, null), 810);
        adminPanel.AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ChangePanel(Panels.ADMIN_PANEL, Panels.START_PANEL); });
        m_panels.add(adminPanel);
    }

    private void InitLoginPanel()
    {
        FormPanel loginPanel = new LoginPanel();
        loginPanel.AddButton(TypeButton.BUTTON_ICON_RETURN, 5, 5, (ActionEvent evt) -> { loginPanel.ClearFields(); ChangePanel(Panels.LOGIN_PANEL, Panels.START_PANEL); });
        m_panels.add(loginPanel);
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
                MainWindow.ChangePanel(Panels.REGISTER_ADMIN_PANEL, Panels.REGISTER_ADMIN_PANEL);
            }
            else
                MainWindow.ChangePanel(Panels.START_PANEL, Panels.START_PANEL);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
		}
    }

    private void LoginAction(ActionEvent evt, TypeUser user)
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