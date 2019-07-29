/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import javax.swing.JTable;

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
    }
}