/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Subject;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.SubjectDataHandler;
import View.MainWindow.Panels;

/**
 * 
 */
public class RegisterSubjectPanel extends FormPanel
{
    private static final long serialVersionUID = 6556975800225335457L;
    
    public RegisterSubjectPanel()
    {
        super("REGISTRO DE ASIGNATURA");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el código", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código de asignatura: ", 50, 150);
        AddField(new TextField(300, 50, "Digite el nombre", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Nombre de asignatura: ",400, 150);
        AddField(new TextField(300, 50, "Digite el número de créditos", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Número de créditos", 50, 250);
        AddField(new TextField(300, 50, "Digite el semestre recomendado", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Semestre recomendado", 400, 250);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (ValidateFields())
        {
            try
            {
                DataConnectionHandler dataConnectionHandler = new SubjectDataHandler();
                if (!dataConnectionHandler.ConnectWithData())
                    dataConnectionHandler.CreateDataConnection();
                dataConnectionHandler.ConnectWithData();

                String code, name;
                int credits, recommendedSemester;

                code = GetContentField(0);
                name = GetContentField(1);
                credits = Integer.parseInt(GetContentField(2));
                recommendedSemester = Integer.parseInt(GetContentField(3));

                Subject subject = new Subject(code, name, credits, recommendedSemester);

                if (dataConnectionHandler.Insert(subject))
                {
                    JOptionPane.showMessageDialog(this, "Asignatura registrada con éxito!");
                    MainWindow.ChangePanel(Panels.REGISTER_SUBJECT_PANEL, Panels.SUBJECT_HANDLER_PANEL);
                    dataConnectionHandler.CloseDataConnection();
                }
                else
                    JOptionPane.showMessageDialog(this, "Asignatura ya registrada");

                    ClearFormPanel();

            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Campos inválidos");
    }

    @Override
    protected void ReturnButtonAction() 
    {
        super.ReturnButtonAction();
        MainWindow.ChangePanel(Panels.REGISTER_SUBJECT_PANEL, Panels.SUBJECT_HANDLER_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }
}