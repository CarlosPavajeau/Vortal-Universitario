/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

/**
 * 
 */
public class RegisterAdminPanel extends FormPanel
{
    private static final long serialVersionUID = 6118942589914143575L;
    
    public RegisterAdminPanel()
    {
        super("REGISTRO DE ADMINISTRADOR");
        initComponents();
    }

    private void initComponents()
    {
        
    }

    @Override
    public void InitFields() 
    {
        AddTextField(new TextField(300, 50, "Digite su ID", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Identificación: ", 50, 150);
        AddTextField(new TextField(300, 50, "Digite su usuario", TextField.OBLIGATORY_FIELD), "Usuario: ", 50, 250);
        AddTextField(new TextField(300, 50, "Digite su contraseña", TextField.OBLIGATORY_FIELD), "Contraseña: ", 50, 350);
    }
}