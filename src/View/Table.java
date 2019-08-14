/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
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

    private final String[] m_columnNames;

    public Table(String... columnNames)
    {
        m_columnNames = columnNames;
        setModel(new DefaultTableModel(null,m_columnNames) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
}