/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Button extends JButton
{
    private static final long serialVersionUID = 5785888698230641579L;

    public Button(TypeButton typeButton, ActionListener l)
    {
        super();
        setBackground(Color.WHITE);
        setIcon(new ImageIcon(getClass().getResource(typeButton.GetSRC())));
        setRolloverIcon(new ImageIcon(getClass().getResource(typeButton.GetRolloverSRC())));
        setPressedIcon(new ImageIcon(getClass().getResource(typeButton.GetPressedSRC())));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setIconTextGap(2);
        setText(typeButton.GetText());
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(0, 0, 0, 0));
        setMaximumSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        setMinimumSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        setPreferredSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        addActionListener(l);
    }
}