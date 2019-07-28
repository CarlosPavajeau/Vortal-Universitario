/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setFont(new Font("Microsoft Sans Serif", 0, 12));
        setIconTextGap(3);
        if (!typeButton.GetText().isEmpty())
        {
            setText(typeButton.GetText());
            setToolTipText(typeButton.GetText());
        }
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMargin(null);
        setMaximumSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        setMinimumSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        setSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        setPreferredSize(new Dimension(typeButton.GetWidth(), typeButton.GetHeigth()));
        setRolloverIcon(new ImageIcon(getClass().getResource(typeButton.GetRolloverSRC())));
        setPressedIcon(new ImageIcon(getClass().getResource(typeButton.GetPressedSRC())));
        if (l != null) addActionListener(l);
    }
}