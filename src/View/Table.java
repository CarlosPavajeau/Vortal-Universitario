/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 */
public class Table extends JTable
{
    private static final long serialVersionUID = 6281155193179910464L;

    private final String[] columnNames;

    public Table(String... _columnNames)
    {
        columnNames = _columnNames;
        setModel(new DefaultTableModel(null,columnNames) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
}