/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.util.Stack;

import View.LoginPanel.TypeUser;

import java.util.ArrayList;
import java.util.List;

public class PanelHandler
{
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

    private static Stack<Panel> panelsStack = new Stack<>();
    private static List<Panel> panels = new ArrayList<>();

    public static void InitPanels()
    {   
        InitCommonPanels();
        InitFormPanels();
        InitHandlingPanels();   
    }

    private static void InitCommonPanels()
    {
        panels.add(new StartPanel());
        panels.add(new StudentPanel());
        panels.add(new ProfessorPanel());
        panels.add(new AdminPanel());
        panels.add(new LoginPanel());
    }

    private static void InitFormPanels()
    {
        panels.add(new RegisterAcademicLoadPanel());
        panels.add(new RegisterAcademicSemesterPanel());
        panels.add(new RegisterAdminPanel());
        panels.add(new RegisterNotesPanel());
        panels.add(new RegisterPensumPanel());
        panels.add(new RegisterPersonPanel());
        panels.add(new RegisterSubjectPanel());
    }

    private static void InitHandlingPanels()
    {
        panels.add(new DataHandlerPanel());
        panels.add(new StudentHandlerPanel());
        panels.add(new ProfessorHandlerPanel());
        panels.add(new SubjectHandlerPanel());
        panels.add(new PensumHandlerPanel());
        panels.add(new AcademicSemesterHandlerPanel());
        panels.add(new StudentGroupHandlerPanel());
    }

    public static void ShowLoginPanel(TypeUser user)
    {
        LoginPanel loginPanel = ((LoginPanel)GetPanel(Panels.LOGIN_PANEL));
        loginPanel.SetUser(user);
        PushPanel(GetPanel(Panels.START_PANEL));
        ShowPanel(Panels.LOGIN_PANEL); 
    }

    public static List<Panel> GetPanels()
    {
        return panels;
    }

    public static void ChangePanel(Panel panelToHide, Panels panelToShow)
    {
        PushPanel(panelToHide);
        ShowPanel(panelToShow);
    }

    public static void PushPanel(Panel panelToHide)
    {
        HidePanel(panelToHide);
        panelsStack.add(panelToHide);
    }

    public static void PopPanel()
    {
        ChangeVisibilityPanel(panelsStack.pop(), true);
    }

    public static void ShowPanel(Panels panel)
    {
        Panel panelToShow = GetPanel(panel);
        if (IsStartPanel(panel))
            ((StartPanel)panelToShow).EnableButtons();
        ChangeVisibilityPanel(panelToShow, true);
    }

    public static boolean IsStartPanel(Panels panel)
    {
        return panel == Panels.START_PANEL;
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

    public static void HidePanel(Panel panel)
    {
        ChangeVisibilityPanel(panel, false);
    }

    public static void ChangeVisibilityPanel(Panel panel, boolean visibility)
    {
        panel.setVisible(visibility);
    }
}