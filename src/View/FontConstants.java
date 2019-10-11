/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Font;

public interface FontConstants 
{
    String DEFAULT_FONT_NAME = "SansSerif";

    byte DEFAULT_FONT_SIZE = 16;
    byte BUTTON_FONT_SIZE = 12;
    byte TITLE_FONT_SIZE = 25;

    byte DEFAULT_FONT_STYLE = 0;
    
    Font DEFAULT_FONT = new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE);
    Font BUTTON_FONT = new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, BUTTON_FONT_SIZE);
    Font TITLE_FONT = new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_SIZE, TITLE_FONT_SIZE);
}