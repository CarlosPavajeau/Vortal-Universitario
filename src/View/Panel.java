/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * 
 */
public abstract class Panel extends JPanel
{

    private static final long serialVersionUID = 6607745560865183345L;

    private List<Button> m_buttons;

    public Panel()
    {
        initComponents();
    }

    private void initComponents()
    {
        m_buttons = new ArrayList<>();
        setBackground(Color.WHITE);
        setSize(new Dimension(1300, 1000));
        setPreferredSize(new Dimension(1300, 1000));
        setBorder(new RoundRectBorder());
        setBounds(new Rectangle(0, 0, 0, 0));
    }

    public List<Button> GetButtons()
    {
        return m_buttons;
    }

    public void AddButton(TypeButton button, ActionListener l)
    {
        m_buttons.add(new Button(button, l));
        add(new Button(button, l));
    }
    
}