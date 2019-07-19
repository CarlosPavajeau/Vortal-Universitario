/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * 
 */
public class MainWindow extends JFrame 
{
    private static final long serialVersionUID = 9040978770256604819L;

    List<Panel> m_panels;
    JPanel m_mainPanel;

    public MainWindow() 
    {
        super();
        initComponents();
    }

    private void initComponents() 
    {
        m_panels = new ArrayList<>();
        m_mainPanel = new JPanel();
        setContentPane(m_mainPanel);
        m_mainPanel.setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vortal Universitario");
        setBackground(Color.WHITE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }
}