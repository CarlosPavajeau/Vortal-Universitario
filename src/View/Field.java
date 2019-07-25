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

import javax.swing.JPasswordField;

/**
 * 
 */
public abstract class Field extends JPasswordField
{
    private static final long serialVersionUID = -6658030860003762208L;

    public static final int OBLIGATORY_FIELD = 1;
    public static final int NUMERIC_FIELD = 2;
    public static final int ALPHA_FIELD = 4;
    
    private final String m_defaultText;
    private final int m_typeField;

    public Field(int width, int height, String defaultText, int typeField)
    {
        super();
        m_defaultText = defaultText;
        m_typeField = typeField;
        setFont(new Font("Microsoft Sans Serif", 0, 16));
        setForeground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        setHorizontalAlignment(JPasswordField.LEFT);
        setText(m_defaultText);
        setEchoChar((char)0);
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

    public void Clear()
    {
        TextFieldFocusLost(null);
    }

    /**
     * 
     * @return
     */
    private boolean ValidateObligatoryField()
    {
        return !(String.valueOf(getPassword()).isEmpty() || String.valueOf(getPassword()).equals(m_defaultText));
    }

    /**
     * 
     * @return
     */
    private boolean ValidateAlphaField()
    {
        return String.valueOf(getPassword()).matches("[a-zA-Z]+");
    }

    /**
     * 
     * @return
     */
    private boolean ValidateNumericField()
    {
        return String.valueOf(getPassword()).matches("(\\d+)");
    }

    /**
     * 
     * @param evt
     */
    private void TextFieldFocusGained(FocusEvent evt) 
    {
        if (String.valueOf(getPassword()).equals(m_defaultText))
        {
            if (this instanceof PasswordField) /**Is a PasswordField? */
                setEchoChar((char)8226);

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
        if (String.valueOf(getPassword()).isEmpty())
        {
            setEchoChar((char)0);
            setForeground(Color.GRAY);
            setText(m_defaultText);
        }
    }
}