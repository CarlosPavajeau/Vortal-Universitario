/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class RoundRectBorder extends AbstractBorder
{
    private static final long serialVersionUID = 1554576986093645747L;
    private static final Color ALPHA_ZERO = new Color(0x0, true);

    private static final int TOP = 4;
    private static final int LEFT = 8;
    private static final int BOTTOM = 4;
    private static final int RIGHT = 8;

    private static final Insets BORDER_INSETS = new Insets(TOP, LEFT, BOTTOM, RIGHT);
    
    public static final RoundRectBorder GRAY_BORDER = new RoundRectBorder();
    public static final RoundRectBorder BLUE_BORDER = new RoundRectBorder(Color.BLUE);
    public static final RoundRectBorder RED_BORDER = new RoundRectBorder(Color.RED);

    private final Color _color;

    public RoundRectBorder()
    {
        _color = Color.GRAY;
    }

    public RoundRectBorder(Color color)
    {
        _color = color;
    }

    @Override
    public void paintBorder(Component component, Graphics graphics, int x, int y, int width, int height)
    {
        Graphics2D graphics2d = (Graphics2D)graphics.create();
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape border = getBorderShape(x, y, width - 1, height - 1);
        graphics2d.setPaint(ALPHA_ZERO);
        Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
        corner.subtract(new Area(border));
        graphics2d.fillRoundRect(x, y, width - 1, height - 1, 5, 5);
        graphics2d.setPaint(_color);
        graphics2d.drawRoundRect(x, y, width - 1, height - 1, 5, 5);
        graphics2d.dispose();
    }
    
    public Shape getBorderShape(int x, int y, int width, int height) 
    {
        return new RoundRectangle2D.Double(x, y, width, height, height, height);
    }
    
    @Override 
    public Insets getBorderInsets(Component component)
    {
        return BORDER_INSETS;
    }

    @Override
    public Insets getBorderInsets(Component component, Insets insets) 
    {
        insets.set(TOP, LEFT, BOTTOM, RIGHT);
        return insets;
    }
}