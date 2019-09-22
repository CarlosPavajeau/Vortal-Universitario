/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;

public class Label extends JLabel
{
    private static final long serialVersionUID = -9143271408778332230L;

    public Label(String text)
    {
        this(text, new Rectangle(300, 50));
    }

    public Label(String text, Rectangle size)
    {
        this(text, size, 16);
    }

    public Label(String text, Rectangle size, int fontSize)
    {
        super(text);
        setBounds(size);
        setFont(new Font("Microsoft Sans Serif", 0, fontSize));
        setHorizontalAlignment(JLabel.CENTER);
    }
}
