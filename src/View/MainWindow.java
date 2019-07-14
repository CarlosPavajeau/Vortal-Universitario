/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 
 */
public class MainWindow extends JFrame 
{
    private static final long serialVersionUID = 9040978770256604819L;

    List<Panel> m_panels;

    public MainWindow() 
    {
        initComponents();
    }

    private void initComponents() 
    {
        m_panels = new ArrayList<>();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vortal Universitario");
        setBackground(Color.WHITE);
        setBounds(new Rectangle(0, 0, 0, 0));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }
}