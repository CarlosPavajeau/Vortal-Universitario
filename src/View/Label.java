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
        this(text, new Rectangle(LabelConstants.DEFAULT_LABEL_WIDTH, LabelConstants.DEFAULT_LABEL_HEIGHT));
    }

    public Label(String text, Rectangle size)
    {
        this(text, size, LabelConstants.DEFAULT_FONT_SIZE);
    }

    public Label(String text, Rectangle size, int fontSize)
    {
        this(text, size, new Font(FontConstants.DEFAULT_FONT_NAME, 
                                  FontConstants.DEFAULT_FONT_STYLE, fontSize), JLabel.LEFT);
    }

    public Label(String text, Rectangle size, Font font, int alignment)
    {
        super(text);
        setFont(font);
        setBounds(size);
        setHorizontalAlignment(alignment);
    }
}
