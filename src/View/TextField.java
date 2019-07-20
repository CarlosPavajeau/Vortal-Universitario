/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

/**
 * 
 */
public class TextField extends JTextField
{
    private static final long serialVersionUID = -1322371677583567319L;

    public static final int OBLIGATORY_FIELD = 1;
    public static final int NUMERIC_FIELD = 2;
    public static final int ALPHA_FIELD = 4;
    
    private final String m_defaultText;
    private final int m_typeField;

    /**
     * 
     * @param width
     * @param height
     * @param defaultText
     * @param typeField
     */
    public TextField(int width, int height, String defaultText, int typeField)
    {
        m_defaultText = defaultText;
        m_typeField = typeField;
        setFont(new Font("Microsoft Sans Serif", 0, 16));
        setForeground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        setHorizontalAlignment(JTextField.CENTER);
        setText(m_defaultText);
        setBorder(new RoundRectBorder());
        addFocusListener(new FocusAdapter() 
        {
            public void focusGained(FocusEvent evt) 
            {
                TextFieldFocusGained(evt);
            }

            public void focusLost(FocusEvent evt)
            {
                TextFieldFocusLost(evt);
            }
        });
    }

    /**
     * 
     * @return
     */
    public boolean IsValidField()
    {
        switch (m_typeField)
        {
            case TextField.OBLIGATORY_FIELD: 
                return ValidateObligatoryField();
            case TextField.ALPHA_FIELD: 
                return ValidateAlphaField();
            case TextField.NUMERIC_FIELD: 
                return ValidateNumericField();
            case TextField.ALPHA_FIELD + TextField.OBLIGATORY_FIELD: 
                return ValidateObligatoryField() && ValidateAlphaField();
            case TextField.NUMERIC_FIELD + TextField.OBLIGATORY_FIELD: 
                return ValidateObligatoryField() && ValidateNumericField();
            default:
                return true;
        }
    }

    /**
     * 
     * @return
     */
    private boolean ValidateObligatoryField()
    {
        return !(getText().isEmpty() || getText().equals(m_defaultText));
    }

    /**
     * 
     * @return
     */
    private boolean ValidateAlphaField()
    {
        return getText().matches("[a-zA-Z]+");
    }

    /**
     * 
     * @return
     */
    private boolean ValidateNumericField()
    {
        return getText().matches("(\\d+)");
    }

    /**
     * 
     * @param evt
     */
    private void TextFieldFocusGained(FocusEvent evt) 
    {
        if (getText().equals(m_defaultText))
        {
            setForeground(Color.BLACK);
            setText("");
        }
    }

    /**
     * 
     * @param evt
     */
    private void TextFieldFocusLost(FocusEvent evt)
    {
        if (getText().equals(""))
        {
            setForeground(Color.GRAY);
            setText(m_defaultText);
        }
    }
}