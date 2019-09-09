/*
 * Copyright (C) 2019-2019 Carlos Pavajeau 
 * 
 */

package View;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 */
public class ErrorPanel
{
    public static enum TypeError
    {
        CONNECTION_ERROR("Conexión con los datos fallida."),
        UPDATE_ERROR("Fallo en la actualización de datos."),
        WITHOOUT_DATA("Los datos necesarios para esta acción no han sido registrados."),
        INVALID_PROFESSOR_CODE("El código digitado no es el de un profesor."),
        
        ;

        private final String errorMessage;

        private TypeError(String error_message)
        {
            errorMessage = error_message;
        }

        public String GetErrorMessage()
        {
            return errorMessage;
        }
    }

    private static final String ERROR_ICON_SRC = "/View/Assets/Icons/50x50/Icon_Danger.png";

    private static final Icon ERROR_ICON = new ImageIcon(ErrorPanel.class.getResource(ERROR_ICON_SRC));

    private static final String ERROR_MSG = "Error: ";

    public static void ShowError(TypeError typeError)
    {
        MainWindow.ShowPopUpWindow("Error", ERROR_MSG + typeError.GetErrorMessage(), JOptionPane.ERROR_MESSAGE, ERROR_ICON);
    }
}