/*
 * Copyright (C) 2019 Carlos Pavajeau
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
import java.awt.Point;

/**
 * 
 */
public abstract class FormPanel extends Panel
{
    private static final long serialVersionUID = -8968908404958389317L;
    
    private List<Field> fields;
    private List<RadioButton> radioButtons;
    private ButtonGroup buttonGroup;

    public FormPanel(String title)
    {
        super(title);
        initComponents();
    }

    private void initComponents()
    {
        fields = new ArrayList<>();
        radioButtons = new ArrayList<>(0);
        buttonGroup = new ButtonGroup();
        InitFields();
        if (!(this instanceof RegisterAdminPanel))
            AddReturnButton();
    }

    public List<Field> GetFields()
    {
        return fields;
    }

    public List<RadioButton> GetRadioButtons()
    {
        return radioButtons;
    }

    public void AddField(Field field, String text, Point fieldPosition)
    {
        JLabel ltext = new JLabel(text);
        ltext.setFont(new Font("Microsoft Sans Serif", 0, 16));
        ltext.setSize(text.length() * 16, 20);
        fields.add(field);
        AddComponent(ltext, fieldPosition);
        fieldPosition.y += ltext.getHeight();
        AddComponent(field, fieldPosition);
    }

    public void AddRadioButtons(String text, Point radioButtonsPosition, String... ops)
    {
        JLabel ltext = new JLabel(text);
        ltext.setFont(new Font("Microsoft Sans Serif", 0, 16));
        ltext.setSize(text.length() * 10, 50);
        AddComponent(ltext, radioButtonsPosition);

        int auxX = radioButtonsPosition.x + ltext.getWidth();
        for (String op : ops)
        {
            AddRadioButton(op, new Point(auxX, radioButtonsPosition.y));
            auxX += RadioButton.RADIO_BUTTON_WIDTH;
        }
    }

    public void AddRadioButton(String textButton, Point radioButtonPosition)
    {
        RadioButton radioButton = new RadioButton(textButton);
        radioButtons.add(radioButton);
        buttonGroup.add(radioButton);
        AddComponent(radioButton, radioButtonPosition);
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
        AddField(textField, text, new Point(Panel.WhereCenterX(this, textField), y));
    }

    protected void AddRegisterButton(TypeButton typeButton)
    {
        AddActionButton(typeButton, 750);
    }

    protected void AddActionButton(TypeButton typeButton, int whereX)
    {
        AddButton(typeButton, new Point(whereX, 600), (ActionEvent evt) -> { RegisterButtonAction(evt); });
    }

    protected void ClearFormPanel()
    {
        ClearFields();
        ClearRadioButtons();
    }

    protected abstract void InitFields();
    protected abstract void RegisterButtonAction(ActionEvent evt);
    
    @Override
    protected void ReturnToBehindPanel() 
    {
        super.ReturnToBehindPanel();
        ClearFormPanel();
    }

    protected void ClearAndReturnToBehindPanel()
    {
        ClearFormPanel();
        ReturnToBehindPanel();
    }

    private void ClearFields()
    {
        for (Field field : GetFields())
            field.Clear();
    }

    private void ClearRadioButtons()
    {
        buttonGroup.clearSelection();
    }
}