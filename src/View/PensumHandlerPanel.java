/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;

import View.MainWindow.Panels;

/**
 * 
 */
public class PensumHandlerPanel extends Panel
{
    private static final long serialVersionUID = -841003057759870803L;

    public PensumHandlerPanel()
    {
        super("GESTIÓN DE PENSUMs");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_PENSUM, (ActionEvent evt) -> { MainWindow.ChangePanel(this, Panels.REGISTER_PENSUM_PANEL); }), 200);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_PENSUM, null), 350);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ADD_SUBJECT, null), 500);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_DELETE_SUBJECT, null), 650);
        AddReturnButton();
    }
}