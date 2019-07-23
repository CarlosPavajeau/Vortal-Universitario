/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

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
        AddField(new TextField(300, 50, "Digite el número de créditos", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Número de créditos", 50, 250);
        AddField(new TextField(300, 50, "Digite el semestre recomendado", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Semestre recomendado", 400, 250);
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (!ValidateFields())
            System.out.println("Error: Campos invalidos");
    }
}