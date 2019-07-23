/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

/**
 * 
 */
public class RegisterNotesPanel extends FormPanel
{
    private static final long serialVersionUID = 9175974894391401561L;

    public RegisterNotesPanel()
    {
        super("REGISTRO DE NOTAS");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el código del grupo", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código del grupo: ", 50, 150);
        AddField(new TextField(300, 50, "Digite el código del estudiante", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Codigo del estudiante", 50, 250);
        AddField(new TextField(100, 50, "1° corte", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Notas: ", 50, 350);
        AddField(new TextField(100, 50, "2° corte", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "", 165, 350);
        AddField(new TextField(100, 50, "3° corte", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "", 280, 350);
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (!ValidateFields())
            System.out.println("Error: Campos invalidos");
    }
}