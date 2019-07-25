/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public abstract class Panel extends JPanel
{

    private static final long serialVersionUID = 6607745560865183345L;

    private List<Button> m_buttons;
    private final String m_title;

    public Panel(String title)
    {
        super();
        m_title = title;
        initComponents();
        SetTitle();
    }

    private void initComponents()
    {
        m_buttons = new ArrayList<>();
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(1000, 700));
        setPreferredSize(new Dimension(1000, 700));
        setSize(new Dimension(1000, 700));
        setBorder(new RoundRectBorder());
        setLayout(null);
    }

    public List<Button> GetButtons()
    {
        return m_buttons;
    }

    public void AddButton(TypeButton typeButton, int x, int y, ActionListener l)
    {
        Button button = new Button(typeButton, l);
        m_buttons.add(button);
        AddComponent(button, x, y);
    }

    public void AddComponent(Component component, int x, int y)
    {
        component.setLocation(new Point(x, y));
        add(component);
    }

    protected void AddCenterComponentX(Component component, int y)
    {
        AddComponent(component, Panel.WhereCenterX(this, component), y);
    }

    protected void AddCenterComponentY(Component component, int x)
    {
        AddComponent(component, x, Panel.WhereCenterY(this, component));
    }

    protected static int WhereCenterX(Panel panel, Component component)
    {
        return (panel.getWidth() - component.getWidth()) / 2;
    }

    protected static int WhereCenterY(Panel panel, Component component)
    {
        return (panel.getHeight() - component.getHeight()) / 2; 
    }

    private void SetTitle()
    {
        JLabel title = new JLabel(m_title);
        title.setFont(new Font("Microsoft Sans Serif", 0, 25));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 5, 700, 100);
        int x = (getWidth() - title.getWidth()) / 2;
        title.setBounds(x, 5, 700, 100);
        add(title);
    }
}