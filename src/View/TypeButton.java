package View;

public enum TypeButton
{
    /**Standard buttons */
    BUTTON_LOGIN("Button_Login", "", TypeButton.STANDARD_BUTTON),
    BUTTON_REGISTER("Button_Register", "", TypeButton.STANDARD_BUTTON),
    BUTTON_EXIT("Button_Exit", "", TypeButton.STANDARD_BUTTON),
    BUTTON_MATRICULATE("Button_Matriculate", "", TypeButton.STANDARD_BUTTON),
    BUTTON_LOGOUT("Button_LogOut", "", TypeButton.STANDARD_BUTTON),
    /**50x50 buttons */
    BUTTON_ICON_DANGER("Icon_Danger", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_HELP("Icon_Help", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_PEN("Icon_Pen", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_MESH("Icon_Mesh", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_RETURN("Icon_Return", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_MAGNIFYING("Icon_Magnifying", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_WARNING("Icon_Warning", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    BUTTON_ICON_MORTARBOARD("Icon_Mortarboard", "", TypeButton.BUTTON_WITH_SIZE_50x50),
    /**100x100 buttons */
    BUTTON_ICON_ACCESS_DATA_MANAGER("Icon_AccessDataManager", "Gestión de datos de acceso", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ACADEMIC_SEMESTER_HANDLER("Icon_AcademicSemesterHandler", "Gestión de semestres académicos", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_ACADEMIC_SEMESTER("", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_OR_DELETE_STUDENT("Icon_Add-DeleteStudent", "Añadir/Borrar estudiante", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_PENSUM("Icon_AddPensum", "Añadir PENSUM", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_PROFESSOR("Icon_AddProfessor", "Añadir profesor", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_STUDENT_GROUP("Icon_AddStudentGroup", "Añadir grupo de estudiantes", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_SUBJECT("Icon_AddSubject", "Añadir asignatura", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_CURRENT_PROGRESS("Icon_CurrentProgress", "Ver Progreso", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DATA_MANAGER("Icon_DataManager", "Gestión de datos", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DELETE_ACADEMIC_SEMESTER("Icon_DeleteAcademicSemester", "Eliminar un semestre academico", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DELETE_PENSUM("Icon_DeletePensum", "Eliminar un PEMSUM", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DELETE_PROFESSOR("Icon_DeleteProfessor", "Eliminar un professor", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DELETE_STUDENTGROUP("Icon_DeleteStudentGroup", "Elimnar un grupo de estudiantes", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DELETE_SUBJECT("Icon_DeleteSubject", "Eliminar Asignatura", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_PENSUM_HANDLER("Icon_PensumHandler", "Gestión de PENSUMs", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_PERSONAL_DATA_MANAGER("Icon_PersonalDataManager", "Gestión de datos personales", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_PROFESSOR_HANDLER("Icon_ProfessorHandler", "Gestión de profesores", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_REGISTER_NOTES("Icon_RegisterNotes", "Registrar notas", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_STUDENT_GROUP_HANDLER("Icon_StudentGroupHandler", "Gestión de grupos de estudiantes", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_STUDENT_HANDLER("Icon_StudentHandler", "Gestión de estudiantes", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_SUBJECT_HANDLER("Icon_SubjectHandler", "Gestión de asignaturas", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_VIEW_PROGRESS("Icon_ViewProgress", "Ver progreso", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_VIEW_QUALIFICATIONS("Icon_ViewQualifications", "Ver calificaciones", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_VIEW_STUDENT_SUBJECTS("Icon_ViewStudentSubjects", "Ver asignaturas de estudiante", TypeButton.BUTTON_WITH_SIZE_100x100),
    /**200x200 buttons */
    BUTTON_ICON_I_AM_ADMIN("I'm_Admin", "Soy Administrador", TypeButton.BUTTON_WITH_SIZE_200x200),
    BUTTON_ICON_I_AM_PROFESSOR("I'm_Professor", "Soy Professor", TypeButton.BUTTON_WITH_SIZE_200x200),
    BUTTON_ICON_I_AM_STUDENT("I'm_Student", "Soy Estudiante", TypeButton.BUTTON_WITH_SIZE_200x200)
    ;

    private final String m_src;
    private final String m_rolloverSrc;
    private final String m_pressedSrc;
    private final int m_width, m_heigth;
    private final String m_text;

    private static final String STANDARD_BUTTONS_SRC = "/View/Assets/Buttons/";
    private static final String BUTTONS_WITH_ICONS100x100_SRC = "/View/Assets/Icons/100x100/";
    private static final String BUTTONS_WITH_ICONS50x50_SRC = "/View/Assets/Icons/50x50/";
    private static final String BUTTONS_WITH_ICONS200x200_SRC = "/View/Assets/Icons/200x200/";

    private static final int STANDARD_BUTTON = 0;
    private static final int BUTTON_WITH_SIZE_50x50 = 1;
    private static final int BUTTON_WITH_SIZE_100x100 = 2;
    private static final int BUTTON_WITH_SIZE_200x200 = 3;

    private static final int STANDARD_BUTTON_SIZE_WIDTH = 200; 
    private static final int STANDARD_BUTTON_SIZE_HEIGHT = 50;
    
    private static final int BUTTONS_WITH_ICONS100x100_WIDTH = 100;
    private static final int BUTTONS_WITH_ICONS100x100_HEIGHT = 120;

    private static final int BUTTONS_WITH_ICONS50x50_WIDTH = 50;
    private static final int BUTTONS_WITH_ICONS50x50_HEIGHT = 70;

    private static final int BUTTONS_WITH_ICONS200x200_WIDTH = 200;
    private static final int BUTTONS_WITH_ICONS200x200_HEIGHT = 220;

    private static final String BUTTON_EXT = ".png";
    private static final String BUTTON_ROLLOVER_SUFFIX = "MouseOn";
    private static final String BUTTON_PRESSED_SUFFIX = "Click";

    private TypeButton(String buttonName, String tex, int typeButton)
    {
        if (typeButton == TypeButton.STANDARD_BUTTON)
        {
            m_src = STANDARD_BUTTONS_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = STANDARD_BUTTONS_SRC + buttonName +
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = STANDARD_BUTTONS_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = STANDARD_BUTTON_SIZE_WIDTH;
            m_heigth = STANDARD_BUTTON_SIZE_HEIGHT;
        }
        else if (typeButton == TypeButton.BUTTON_WITH_SIZE_50x50)
        {
            m_src = BUTTONS_WITH_ICONS50x50_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = BUTTONS_WITH_ICONS50x50_SRC + buttonName + 
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = BUTTONS_WITH_ICONS50x50_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = BUTTONS_WITH_ICONS50x50_WIDTH;
            m_heigth = BUTTONS_WITH_ICONS50x50_HEIGHT;
        }
        else if (typeButton == TypeButton.BUTTON_WITH_SIZE_100x100)
        {
            m_src = BUTTONS_WITH_ICONS100x100_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = BUTTONS_WITH_ICONS100x100_SRC + buttonName + 
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = BUTTONS_WITH_ICONS100x100_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = BUTTONS_WITH_ICONS100x100_WIDTH;
            m_heigth = BUTTONS_WITH_ICONS100x100_HEIGHT;
        } 
        else
        {
            m_src = BUTTONS_WITH_ICONS200x200_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = BUTTONS_WITH_ICONS200x200_SRC + buttonName + 
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = BUTTONS_WITH_ICONS200x200_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = BUTTONS_WITH_ICONS200x200_WIDTH;
            m_heigth = BUTTONS_WITH_ICONS200x200_HEIGHT;
        }
        m_text = tex;
    }

    public String GetSRC()
    {
        return m_src;
    }

    public String GetRolloverSRC()
    {
        return m_rolloverSrc;
    }

    public String GetPressedSRC()
    {
        return m_pressedSrc;
    }

    public int GetWidth()
    {
        return m_width;
    }

    public int GetHeigth()
    {
        return m_heigth;
    }

    public String GetText()
    {
        return m_text;
    }
}