/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import Model.DataConnectionHandler.DataConnectionHandler;
import View.ErrorPanel.TypeError;

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
        ltext.setSize(text.length() * 16, 20);
        m_fields.add(textField);
        AddComponent(ltext, x, y);
        AddComponent(textField, x, y + ltext.getHeight());
    }

    public void AddRadioButtons(String text, int x, int y, String... ops)
    {
        JLabel ltext = new JLabel(text);
        ltext.setFont(new Font("Microsoft Sans Serif", 0, 16));
        ltext.setSize(text.length() * 10, 50);
        AddComponent(ltext, x, y);

        int auxX = x + ltext.getWidth();
        for (String op : ops)
        {
            AddRadioButton(op, auxX, y);
            auxX += RadioButton.RADIO_BUTTON_WIDTH;
        }
    }

    public void AddRadioButton(String textButton, int x, int y)
    {
        RadioButton radioButton = new RadioButton(textButton);
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

    protected boolean SaveData(Object anObject, DataConnectionHandler dataConnectionHandler)
    {
        boolean result = false;

        try 
        {
            if (!dataConnectionHandler.ConnectWithData()) 
            {
                dataConnectionHandler.CreateDataConnection();
                dataConnectionHandler.ConnectWithData();
            }

            result = dataConnectionHandler.Insert(anObject);
            dataConnectionHandler.CloseDataConnection();

        } catch (ClassNotFoundException | SQLException | IOException e) 
        {
            ErrorPanel.ShowError(TypeError.CONNECTION_ERROR);
        }

        return result;
    }

    protected String GetContentField(int i)
    {
        return String.valueOf(GetFields().get(i).getPassword());
    }

    protected int GetIntContentField(int i)
    {
        return Integer.parseInt(GetContentField(i));
    }

    protected float GetFloatContentField(int i)
    {
        return Float.parseFloat(GetContentField(i));
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