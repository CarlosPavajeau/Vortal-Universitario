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
public class SuccesPanel
{
    public static enum TypeSucces
    {
        REGISTERED_PERSON("Registro de persona exitoso!"),
        REGISTERED_ACADEMIC_LOAD("Carga académica creada y asiganada con éxito."),
        REGISTERED_ACADEMIC_SEMESTER("Semestre académico registrado con éxito."),
        REGISTERED_ADMIN("Administrador registrado con éxito."),
        REGISTERED_PENSUM("PENSUM registrado con éxito."),
        REGISTERED_SUBJECT("Asignatura registrada con éxito.")
        
        ;

        private final String succesMessage;

        private TypeSucces(String succes_message)
        {
            succesMessage = succes_message;
        }

        public String GetSuccesMessage()
        {
            return succesMessage;
        }
    }

    private static final String SUCCES_ICON_SRC = "/View/Assets/Icons/50x50/Icon_Danger.png";

    private static final Icon SUCCES_ICON = new ImageIcon(SuccesPanel.class.getResource(SUCCES_ICON_SRC));

    private static final String SUCCES_MSG = "Éxito: ";

    public static void ShowSucces(TypeSucces typeSucces)
    {
        MainWindow.ShowPopUpWindow("Éxito", SUCCES_MSG + typeSucces.GetSuccesMessage(), JOptionPane.INFORMATION_MESSAGE, SUCCES_ICON);
    }
}