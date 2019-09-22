/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

public abstract class DisplayPanel extends Panel
{
    private static final long serialVersionUID = -1176729975622551698L;

    protected Object data;

    public DisplayPanel(String _title, Object _data)
    {
        super(_title);
        data = _data;
        AddReturnButton();
    }

    public abstract void MakeDisplayPanel();
}