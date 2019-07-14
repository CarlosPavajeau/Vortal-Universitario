/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.util.ArrayList;

/**
 * 
 */
public abstract class FormPanel extends Panel
{
    private static final long serialVersionUID = -8968908404958389317L;
    
    private ArrayList<TextField> m_fields;

    public FormPanel()
    {
        super();
        initComponents();
    }

    private void initComponents()
    {
        m_fields = new ArrayList<>();
    }

    public void AddTextField(TextField textField)
    {
        m_fields.add(textField);
    }
}