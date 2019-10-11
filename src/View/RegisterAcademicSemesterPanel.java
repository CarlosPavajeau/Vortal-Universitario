/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Point;
import java.awt.event.ActionEvent;

import Model.AcademicSemester;
import Model.DataConnectionHandler.AcademicSemesterDataHandler;
import Model.DataConnectionHandler.DataConnectionHandler;
import View.ErrorPanel.TypeError;
import View.SuccesPanel.TypeSucces;
import View.WarningPanel.TypeWarning;

/**
 * 
 */
public class RegisterAcademicSemesterPanel extends FormPanel
{
    private static final long serialVersionUID = 6848182874437906997L;

    public RegisterAcademicSemesterPanel()
    {
        super("REGISTRO DE SEMESTRE ACADEMICO");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField("Digite el número del semestre", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Número de semeste: ", new Point(50, 150));
        AddField(new TextField("Digite los créditos mínimos", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Créditos mínimos: ", new Point(50, 250));
        AddField(new TextField("Digite los créditos máximos", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Cŕeditos máximos: ", new Point(400, 250));
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {
        if (ValidateFields())
        {
            try
            {
                int semester, minCredits, maxCredits;

                semester = GetSemester();
                minCredits = GetMinCredits();
                maxCredits = GetMaxCredits();

                if ((maxCredits > 0 && minCredits > 0) || maxCredits >= minCredits)
                {
                    AcademicSemester academicSemester = new AcademicSemester(semester, maxCredits, minCredits);
                    DataConnectionHandler dataConnectionHandler = new AcademicSemesterDataHandler();

                    if (SaveData(academicSemester, dataConnectionHandler))
                    {
                        SuccesPanel.ShowSucces(TypeSucces.REGISTERED_ACADEMIC_SEMESTER);
                        ClearAndReturnToBehindPanel();
                    }
                    else
                        WarningPanel.ShowWarning(TypeWarning.ACADEMIC_SEMESTER_ALREADY_REGISTERED);
                }
                else
                    WarningPanel.ShowWarning(TypeWarning.INVALID_CREDIT_NUMBER);
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

    private int GetSemester() 
    {
        return Integer.valueOf(GetContentField(0));
    }

    private int GetMinCredits()
    {
        return Integer.valueOf(GetContentField(1));
    }

    private int GetMaxCredits() 
    {
        return Integer.valueOf(GetContentField(2));    
    }
}