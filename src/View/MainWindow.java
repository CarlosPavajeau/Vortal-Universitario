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

/**
 * 
 */
public class MainWindow extends JFrame 
{
    private static final long serialVersionUID = 9040978770256604819L;

    List<Panel> m_panels;
    JPanel m_mainPanel;

    public MainWindow() 
    {
        super();
        initComponents();
        InitPanels();
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
        Button imProfessorButton = new Button(TypeButton.BUTTON_ICON_I_AM_PROFESSOR, (ActionEvent evt) -> { LoginAction(evt); });
        Button imStudentButton = new Button(TypeButton.BUTTON_ICON_I_AM_STUDENT, (ActionEvent evt) -> { LoginAction(evt); });
        Button imAdminButton = new Button(TypeButton.BUTTON_ICON_I_AM_ADMIN, (ActionEvent evt) -> { LoginAction(evt); });
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
        studentPanel.AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ChangePanel(1, 0); });
        m_panels.add(studentPanel);
    }

    private void InitProfessorPanel()
    {
        Panel professorPanel = new ProfessorPanel();
        professorPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DATA_MANAGER, null), 350);
        professorPanel.AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_STUDENT_HANDLER, null), 500);
        professorPanel.AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ChangePanel(2, 0); });
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
        adminPanel.AddButton(TypeButton.BUTTON_LOGOUT, 775, 625, (ActionEvent evt) -> { ChangePanel(3, 0); });
        m_panels.add(adminPanel);
    }

    private void InitLoginPanel()
    {
        Panel loginPanel = new LoginPanel();
        loginPanel.AddButton(TypeButton.BUTTON_ICON_RETURN, 5, 5, (ActionEvent evt) -> { ChangePanel(4, 0); });
        m_panels.add(loginPanel);
    }

    private void LoginAction(ActionEvent evt)
    {
        ChangePanel(0, 4);   
    }

    private void ChangePanel(int i, int j)
    {
        m_panels.get(i).setVisible(false);
        m_panels.get(j).setVisible(true);
    }
}