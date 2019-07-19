/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * 
 */
public abstract class FormPanel extends Panel
{
    private static final long serialVersionUID = -8968908404958389317L;
    
    private ArrayList<TextField> m_fields;
    private ArrayList<JLabel> m_labels;

    public FormPanel()
    {
        super();
        initComponents();
    }

    private void initComponents()
    {
        m_fields = new ArrayList<>();
        m_labels = new ArrayList<>();
    }

    public void AddTextField(TextField textField, String text, int x, int y)
    {
        m_fields.add(textField);
        m_labels.add(new JLabel(text));
        textField.setBounds(x, y, textField.getWidth(), textField.getHeight());
        add(textField);
    }
}