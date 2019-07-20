/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

/**
 * 
 */
public abstract class FormPanel extends Panel
{
    private static final long serialVersionUID = -8968908404958389317L;
    
    private List<TextField> m_fields;
    private List<JLabel> m_labels;
    private final String m_title;

    public FormPanel(String title)
    {
        super();
        m_title = title;
        initComponents();
    }

    private void initComponents()
    {
        m_fields = new ArrayList<>();
        m_labels = new ArrayList<>();
        SetTitle();
    }

    public List<TextField> GetTextFields()
    {
        return m_fields;
    }

    public void AddTextField(TextField textField, String text, int x, int y)
    {
        JLabel ltext = new JLabel(text);
        ltext.setFont(new Font("Microsoft Sans Serif", 0, 16));
        ltext.setBounds(x, y, 120, 50);
        textField.setBounds(x + ltext.getWidth(), y, textField.getWidth(), textField.getHeight());
        add(ltext);
        add(textField);
        m_labels.add(ltext);
        m_fields.add(textField);
    }

    public boolean ValidateFields()
    {
        for (TextField textField : GetTextFields())
            if (!textField.IsValidField())
                return false;
        return true;
    }

    public abstract void InitFields();

    private void SetTitle()
    {
        JLabel title = new JLabel(m_title);
        title.setFont(new Font("Microsoft Sans Serif", 0, 25));
        title.setBounds(0, 5, 700, 100);
        int x = ((getHeight() - title.getHeight() - getInsets().top - getInsets().bottom) / 2);
        title.setBounds(x, 5, 700, 100);
        add(title);
    }
}