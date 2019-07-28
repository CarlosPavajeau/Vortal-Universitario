/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import View.MainWindow.Panels;

/**
 * 
 */
public class RegisterPensumPanel extends FormPanel
{
    private static final long serialVersionUID = -5626698849668333842L;
    
    public RegisterPensumPanel()
    {
        super("REGISTRO DE PENSUM");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el código del pensum", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código: ", 50, 150);
        AddField(new TextField(300, 50, "Digite el nombre del pensum", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Nombre: ", 400, 150);
        AddField(new TextField(400, 50, "Descripción (Opcional)", 0), "Descripción: ", 50, 250);
        AddField(new TextField(300, 50, "Digite el campus", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Campus: ", 50, 350);
        AddField(new TextField(300, 50, "Digite el número de semestres", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Semestres: ", 400, 350);
        AddField(new TextField(300, 50, "Digite la carga lectiva global",
                TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Carga lectiva global", 50, 450);
        AddField(new TextField(300, 50, "Digite el título", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD),
                "Título (Requerido/A otorgar): ", 400, 450);
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {
		
	}

    @Override
    protected void ReturnButtonAction() 
    {
        MainWindow.ChangePanel(Panels.REGISTER_PENSUM_PANEL, Panels.PENSUM_HANDLER_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }
}