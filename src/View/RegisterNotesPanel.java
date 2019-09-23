/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Point;
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
        AddField(new TextField("Digite el código del grupo", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código del grupo: ", new Point(50, 150));
        AddField(new TextField("Digite el código del estudiante", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Codigo del estudiante", new Point(50, 150));
        AddField(new TextField(100, 50, "1° corte", TextField.OBLIGATORY_FIELD + TextField.FLOAT_FIELD), "Notas: ", new Point(50, 350));
        AddField(new TextField(100, 50, "2° corte", TextField.OBLIGATORY_FIELD + TextField.FLOAT_FIELD), "", new Point(165, 350));
        AddField(new TextField(100, 50, "3° corte", TextField.OBLIGATORY_FIELD + TextField.FLOAT_FIELD), "", new Point(280, 350));
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt)
    {
        if (!ValidateFields())
            System.out.println("Error: Campos invalidos");
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }
}