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

    private final String m_defaultText;

    public TextField(int width, int height, String defaultText)
    {
        m_defaultText = defaultText;
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

    private void TextFieldFocusGained(FocusEvent evt) 
    {
        if (getText().equals(m_defaultText))
        {
            setForeground(Color.BLACK);
            setText("");
        }
    }

    private void TextFieldFocusLost(FocusEvent evt)
    {
        if (getText().equals(""))
        {
            setForeground(Color.GRAY);
            setText(m_defaultText);
        }
    }
}