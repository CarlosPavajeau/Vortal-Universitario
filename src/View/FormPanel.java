/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

/**
 * 
 */
public abstract class FormPanel extends Panel
{
    private static final long serialVersionUID = -8968908404958389317L;
    
    private List<Field> m_fields;
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
        InitFields();
    }

    public List<Field> GetTextFields()
    {
        return m_fields;
    }

    public void AddField(Field textField, String text, int x, int y)
    {
        JLabel ltext = new JLabel(text);
        ltext.setFont(new Font("Microsoft Sans Serif", 0, 16));
        ltext.setSize(250, 20);
        m_labels.add(ltext);
        m_fields.add(textField);
        AddComponent(ltext, x, y);
        AddComponent(textField, x, y + ltext.getHeight());
    }

    protected void AddCenterField(Field textField, String text, int y)
    {
        AddField(textField, text, Panel.WhereCenterX(this, textField), y);
    }

    protected void AddRegisterButton(TypeButton typeButton)
    {
        AddActionButton(typeButton, 750);
    }

    protected void AddActionButton(TypeButton typeButton, int whereX)
    {
        AddButton(typeButton, whereX, 600, (ActionEvent evt) -> { RegisterButtonAction(evt); });
    }

    public boolean ValidateFields()
    {
        for (Field textField : GetTextFields())
            if (!textField.IsValidField())
                return false;
        return true;
    }

    protected abstract void InitFields();
    protected abstract void RegisterButtonAction(ActionEvent evt);

    private void SetTitle()
    {
        JLabel title = new JLabel(m_title);
        title.setFont(new Font("Microsoft Sans Serif", 0, 25));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 5, 700, 100);
        int x = (getWidth() - title.getWidth()) / 2;
        title.setBounds(x, 5, 700, 100);
        add(title);
    }
}