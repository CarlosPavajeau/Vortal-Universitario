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

    public FormPanel(String title)
    {
        super(title);
        initComponents();
    }

    private void initComponents()
    {
        m_fields = new ArrayList<>();
        m_labels = new ArrayList<>();
        InitFields();
        if (!(this instanceof RegisterAdminPanel))
            AddReturnButton();
    }

    public List<Field> GetFields()
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

    public boolean ValidateFields()
    {
        for (Field textField : GetFields())
            if (!textField.IsValidField())
                return false;
        return true;
    }

    protected String GetContentField(int i)
    {
        return String.valueOf(GetFields().get(i).getPassword());
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

    protected void ClearFields()
    {
        for (Field field : GetFields())
            field.Clear();
    }

    protected abstract void InitFields();
    protected abstract void RegisterButtonAction(ActionEvent evt);
}