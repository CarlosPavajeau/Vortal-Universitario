/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel
{
    private static final long serialVersionUID = -9143271408778332230L;

    public Label(String text, int width, int height)
    {
        super(text);
        setBounds(0, 0, width, height);
        setFont(new Font("Microsoft Sans Serif", 0, 16));
    }
}
