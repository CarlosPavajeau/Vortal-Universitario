/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
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

    private List<Button> buttons;
    private final String title;

    public Panel(String _title)
    {
        super();
        title = _title;
        initComponents();
        InitPanel();
        SetTitle();
    }

    private void initComponents()
    {
        buttons = new ArrayList<>();
        setBackground(Color.WHITE);
        setMaximumSize(PanelConstants.PANEL_SIZE);
        setMinimumSize(PanelConstants.PANEL_SIZE);
        setPreferredSize(PanelConstants.PANEL_SIZE);
        setSize(PanelConstants.PANEL_SIZE);
        setBorder(new RoundRectBorder());
        setLayout(null);
    }

    protected abstract void InitPanel();

    public List<Button> GetButtons()
    {
        return buttons;
    }

    protected void AddReturnButton()
    {
        AddButton(TypeButton.BUTTON_ICON_RETURN, PanelConstants.RETURN_BUTTON_POSITION, (ActionEvent evt) -> { ReturnToBehindPanel(); });
    }

    public void AddButton(TypeButton typeButton, Point buttonPosition, ActionListener buttonAction)
    {
        Button button = new Button(typeButton, buttonAction);
        AddComponent(button, buttonPosition);
    }

    public void AddComponent(Component component, Point componentPosition)
    {
        component.setLocation(componentPosition);
        if (component instanceof Button)
            buttons.add((Button)component);
        AddComponent(component);
    }

    public void AddComponent(Component component)
    {
        add(component);
    }

    protected void ReturnToBehindPanel()
    {
        setVisible(false);
        PanelHandler.PopPanel();
    }

    protected void AddCenterComponentX(Component component, int y)
    {
        AddComponent(component, new Point(WhereCenterX(component.getWidth()), y));
    }

    protected void AddCenterComponentY(Component component, int x)
    {
        AddComponent(component, new Point(x, WhereCenterY(component.getHeight())));
    }
    
    protected static int WhereCenterX(int componentWidth)
    {
        return (PanelConstants.PANEL_WIDTH - componentWidth) / 2;
    }

    protected static int WhereCenterY(int componentHeight)
    {
        return (PanelConstants.PANEL_HEIGHT - componentHeight) / 2;
    }

    private void SetTitle()
    {
        Label titleOfPanel = new Label(title, new Rectangle(WhereCenterX(LabelConstants.LABEL_TITLE_WIDTH), 5, 
                                       LabelConstants.LABEL_TITLE_WIDTH, LabelConstants.LABEL_TITLE_HEIGHT), 
                                       FontConstants.TITLE_FONT, Label.CENTER);
        AddComponent(titleOfPanel);
    }
}