/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

/**
 * 
 */
public class TextField extends Field
{
    private static final long serialVersionUID = -1322371677583567319L;

    public TextField(int width, int height, String defaultText, int typeField)
    {
        super(width, height, defaultText, typeField);
    }

    public TextField(String defaultText, int typeField)
    {
        super(defaultText, typeField);
    }
}