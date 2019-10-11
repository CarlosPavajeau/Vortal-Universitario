/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.LoginDataHandler;
import View.PanelHandler.Panels;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public class MainWindow extends JFrame 
{
    private static final long serialVersionUID = 9040978770256604819L;

    public static final MainWindow MainWindow = new MainWindow();
    private JPanel mainPanel;

    public MainWindow() 
    {
        super();
        initComponents();
        PanelHandler.InitPanels();
        AddPanels();
        Start();
    }

    private void initComponents() 
    {
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vortal Universitario");
        setBackground(Color.WHITE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }

    private void AddPanels()
    {
        PanelHandler.GetPanels().stream().map((panel) -> {
            panel.setVisible(false);
            return panel;
        }).forEachOrdered((panel) -> {
            add(panel);
        });
    }
    
    private void Start()
    {
        try 
        {
            DataConnectionHandler dataConnectionHandler = new LoginDataHandler("Admin.dat");
            if (!dataConnectionHandler.ConnectWithData())
            {
                dataConnectionHandler.CreateDataConnection();
                dataConnectionHandler.CloseDataConnection();
                PanelHandler.ShowPanel(Panels.REGISTER_ADMIN_PANEL);
            }
            else
                PanelHandler.ShowPanel(Panels.START_PANEL);
        } 
        catch (IOException | ClassNotFoundException | SQLException e) 
        {
            
        }
    }

    public static void ShowPopUpWindow(String title, String message, int messageType, Icon icon)
    {
        JOptionPane.showMessageDialog(MainWindow, message, title, messageType, icon);
    }
}