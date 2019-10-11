/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Point;
import java.awt.event.ActionEvent;

import Model.Subject;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.SubjectDataHandler;
import View.ErrorPanel.TypeError;
import View.SuccesPanel.TypeSucces;
import View.WarningPanel.TypeWarning;

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
        AddField(new TextField("Digite el código", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código de asignatura: ", new Point(50, 150));
        AddField(new TextField("Digite el nombre", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Nombre de asignatura: ", new Point(400, 150));
        AddField(new TextField("Digite el número de créditos", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Número de créditos", new Point(50, 250));
        AddField(new TextField("Digite el semestre recomendado", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Semestre recomendado", new Point(400, 250));
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (ValidateFields())
        {
            try
            {
                String code, name;
                int credits, recommendedSemester;

                code                = GetCode();
                name                = GetName();
                credits             = GetCredits();
                recommendedSemester = GetRecommendedSemester();

                Subject subject = new Subject(code, name, credits, recommendedSemester);
                DataConnectionHandler dataConnectionHandler = new SubjectDataHandler();

                if (SaveData(subject, dataConnectionHandler))
                {
                    SuccesPanel.ShowSucces(TypeSucces.REGISTERED_SUBJECT);
                    ReturnToBehindPanel();
                }
                else
                    WarningPanel.ShowWarning(TypeWarning.SUBJECT_ALREADY_REGISTERED);
            }
            catch (Exception exception)
            {
                ErrorPanel.ShowError(TypeError.CONNECTION_ERROR);
            }
        }
        else
            WarningPanel.ShowWarning(TypeWarning.INVALID_FIELDS);
    }
    
    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    private String GetCode()
    {
        return GetContentField(0);
    }

    private String GetName()
    {
        return GetContentField(1);
    }

    private int GetCredits()
    {
        return GetIntContentField(2);
    }

    private int GetRecommendedSemester()
    {
        return GetIntContentField(3);
    }
}