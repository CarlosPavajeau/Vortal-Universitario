/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;

/**
 * 
 */
public abstract class FormPanel extends Panel
{
    private static final long serialVersionUID = -8968908404958389317L;
    
    private List<Field> m_fields;
    private List<RadioButton> m_radioButtons;
    private ButtonGroup m_buttonGroup;

    public FormPanel(String title)
    {
        super(title);
        initComponents();
    }

    private void initComponents()
    {
        m_fields = new ArrayList<>();
        m_radioButtons = new ArrayList<>(0);
        m_buttonGroup = new ButtonGroup();
        InitFields();
        if (!(this instanceof RegisterAdminPanel))
            AddReturnButton();
    }

    public List<Field> GetFields()
    {
        return m_fields;
    }

    public List<RadioButton> GetRadioButtons()
    {
        return m_radioButtons;
    }

    public void AddField(Field textField, String text, int x, int y)
    {
        JLabel ltext = new JLabel(text);
        ltext.setFont(new Font("Microsoft Sans Serif", 0, 16));
        ltext.setSize(250, 20);
        m_fields.add(textField);
        AddComponent(ltext, x, y);
        AddComponent(textField, x, y + ltext.getHeight());
    }

    public void AddRadioButton(String text, int x, int y)
    {
        RadioButton radioButton = new RadioButton(text);
        m_radioButtons.add(radioButton);
        m_buttonGroup.add(radioButton);
        AddComponent(radioButton, x, y);
    }

    public boolean ValidateFields()
    {
        for (Field textField : GetFields())
            if (!textField.IsValidField())
                return false;
        return true;
    }

    public boolean ValidateRadioButtons()
    {
        for (RadioButton radioButton : GetRadioButtons())
            if (radioButton.isSelected())
                return true;
        return false;
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

    protected void ClearFormPanel()
    {
        ClearFields();
        ClearRadioButtons();
    }

    protected abstract void InitFields();
    protected abstract void RegisterButtonAction(ActionEvent evt);

    @Override
    protected void ReturnButtonAction() 
    {
        ClearFormPanel();
    }

    private void ClearFields()
    {
        for (Field field : GetFields())
            field.Clear();
    }

    private void ClearRadioButtons()
    {
        m_buttonGroup.clearSelection();
    }
}