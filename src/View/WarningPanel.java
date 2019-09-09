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
public class WarningPanel 
{
    public static enum TypeWarning
    {
        PERSON_ALREADY_REGISTERED("Ya existe una persona con el código digitado."),
        SUBJECT_ALREADY_REGISTERED("Ya existe una asignatura con el código digitado."),
        PENSUM_ALREADY_REGISTERED("Ya existe un PENSUM con el código digitado."),
        STUDENT_GROUP_ALREADY_REGISTERED("Ya existe un grupo de estudiantes con los datos digitados."),
        ACADEMIC_LOAD_ALREADY_REGISTERED("El profesor ya posee la carga académica digitada."),
        ACADEMIC_SEMESTER_ALREADY_REGISTERED("Semestre académico ya registrado."),
        PROFESOR_NOT_REGISTER("El código digitado no corresponde a un profesor registrado."),
        SUBJECT_NOT_REGISTER("El código digitado no corresponde a una asignatura registrada."),
        INVALID_CREDIT_NUMBER("Número de créditos inválido."),
        INVALID_FIELDS("Campos invalidos.")
        ;

        private final String msgWarning; 

        private TypeWarning(String msg)
        {
            msgWarning = msg;
        }

        public String GetMsg()
        {
            return msgWarning;
        }
    }

    private static final String WARNING_ICON_SRC = "/View/Assets/Icons/50x50/Icon_Warning.png";

    private static final Icon WARNING_ICON = new ImageIcon(WarningPanel.class.getResource(WARNING_ICON_SRC));

    private static final String WARNING_MSG = "Advertencia: ";

    public static void ShowWarning(TypeWarning typeWarning)
    {
        MainWindow.ShowPopUpWindow("Advertencia", WARNING_MSG + typeWarning.GetMsg(), JOptionPane.WARNING_MESSAGE, WARNING_ICON);
    }
}