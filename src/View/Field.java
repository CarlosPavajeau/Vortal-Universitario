/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPasswordField;

/**
 * 
 */
public abstract class Field extends JPasswordField
{
    private static final long serialVersionUID = -6658030860003762208L;

    public static final int OBLIGATORY_FIELD    = 0x00000001;
    public static final int NUMERIC_FIELD       = 0x00000002;
    public static final int ALPHA_FIELD         = 0x00000004;
    public static final int DATE_FIELD          = 0x00000008;
    public static final int FLOAT_FIELD         = 0x00000010;
    
    private final String defaultText;
    private final int typeField;

    public Field(int width, int height, String default_text, int type_field)
    {
        super();
        defaultText = default_text;
        typeField = type_field;
        setFont(FontConstants.DEFAULT_FONT);
        setForeground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        setHorizontalAlignment(JPasswordField.LEFT);
        setText(defaultText);
        setEchoChar((char)0);
        setBorder(RoundRectBorder.GRAY_BORDER);
        addFocusListener(new FocusAdapter() 
        {
            public void focusGained(FocusEvent evt) 
            {
                TextFieldFocusGained();
            }

            public void focusLost(FocusEvent evt)
            {
                TextFieldFocusLost();
            }
        });
    }

    public Field(String defaultText, int typeField)
    {
        this(300, 50, defaultText, typeField);
    }

    public boolean IsValidField()
    {
        switch (typeField)
        {
            case TextField.OBLIGATORY_FIELD: 
                return ValidateObligatoryField();
            case TextField.ALPHA_FIELD:
                return ((ValidateObligatoryField()) ? ValidateAlphaField() : true); 
            case TextField.NUMERIC_FIELD: 
                return ((ValidateObligatoryField()) ? ValidateNumericField() : true);
            case TextField.DATE_FIELD:
                return ((ValidateObligatoryField()) ? ValidateDateField() : true);
            case TextField.FLOAT_FIELD:
                return ((ValidateObligatoryField()) ? ValidateFloatField() : true);
            case TextField.ALPHA_FIELD + TextField.OBLIGATORY_FIELD: 
                return ValidateObligatoryField() && ValidateAlphaField();
            case TextField.NUMERIC_FIELD + TextField.OBLIGATORY_FIELD: 
                return ValidateObligatoryField() && ValidateNumericField();
            case TextField.DATE_FIELD + TextField.OBLIGATORY_FIELD:
                return ValidateObligatoryField() && ValidateDateField();
            case TextField.FLOAT_FIELD + TextField.OBLIGATORY_FIELD:
                return ValidateObligatoryField() && ValidateFloatField();
            default:
                return true;
        }
    }

    private boolean ValidateObligatoryField()
    {
        return !(IsEmpty() || HasDefaultText());
    }

    private boolean ValidateAlphaField()
    {
        return GetText().matches("[a-zA-Z]+");
    }

    private boolean ValidateNumericField()
    {
        return GetText().matches("(\\d+)");
    }

    private boolean ValidateDateField()
    {
        return GetText().matches("\\d{4}/\\d{2}/\\d{2}");
    }

    private boolean ValidateFloatField()
    {
        return GetText().matches("(\\d+)\\.(\\d+)");
    }

    private void TextFieldFocusGained() 
    {
        if (HasDefaultText())
        {
            if (this instanceof PasswordField)
                setEchoChar((char)8226);

            setForeground(Color.BLACK);
            setText("");
            setBorder(RoundRectBorder.BLUE_BORDER);
        }
    }

    private boolean HasDefaultText()
    {
        return GetText().equals(defaultText);
    }

    private void TextFieldFocusLost()
    {
        if (IsEmpty())
            Clear();
        setBorder(RoundRectBorder.GRAY_BORDER);
    }

    private boolean IsEmpty()
    {
        return GetText().isEmpty();
    }

    public String GetText()
    {
        return String.valueOf(getPassword());
    }

    public void Clear()
    {
        SetDefaultValues();
    }

    private void SetDefaultValues()
    {
        setEchoChar((char)0);
        setForeground(Color.GRAY);
        setText(defaultText);
    }
}