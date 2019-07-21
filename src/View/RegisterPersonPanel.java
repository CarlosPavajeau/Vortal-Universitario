/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

/**
 * 
 */
public class RegisterPersonPanel extends FormPanel
{
    private static final long serialVersionUID = 4949141375919823301L;
    
    public RegisterPersonPanel()
    {
        super("REGISTRO DE PERSONA");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite su ID", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Identificación: ", 50, 150);
        AddField(new TextField(300, 50, "Digite su primer nombre", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Nombres/Apellidos: ", 50, 250);
        AddField(new TextField(300, 50, "Digite su segundo nombre", TextField.ALPHA_FIELD), "", 400, 250);
        AddField(new TextField(300, 50, "Digite su primer apellido", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "", 50, 315);
        AddField(new TextField(300, 50, "Digite su segundo apellido", TextField.ALPHA_FIELD), "", 400, 315);
        AddField(new TextField(200, 50, "aaaa/mm/dd", TextField.OBLIGATORY_FIELD), "Fecha de nacimiento: ", 50, 415);
        AddButton(TypeButton.BUTTON_REGISTER, 750, 600, (ActionEvent evt) -> { RegisterButton(evt); });
        JRadioButton e = new JRadioButton("Femenino");
        e.setBounds(new Rectangle(400, 400, 200, 50));
        e.setFont(new Font("Microsoft Sans Serif", 0, 16));
        e.setBackground(Color.WHITE);
        add(e);
    }

    public void RegisterButton(ActionEvent evt)
    {
        if (!ValidateFields())
            System.out.println("Error: Campos invalidos");
    }
}