package View;

public enum TypeButton
{
    /**Standard buttons */
    BUTTON_LOGIN("Button_Login", "", TypeButton.STANDARD_BUTTON),
    BUTTON_REGISTER("Button_Register", "", TypeButton.STANDARD_BUTTON),
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
    BUTTON_ICON_ACCESS_DATA_MANAGER("Icon_AccessDataManager", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_OR_DELETE_STUDENT("Icon_Add-DeleteStudent", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_ADD_SUBJECT("Icon_AddSubject", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_CURRENT_PROGRESS("Icon_CurrentProgress", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DATA_MANAGER("Icon_DataManager", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_DELETE_SUBJECT("Icon_DeleteSubject", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_PERSON("Icon_Person", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_PERSONAL_DATA_MANAGER("Icon_PersonalDataManager", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_REGISTER_NOTES("Icon_RegisterNotes", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_SUBJECT_HANDLER("Icon_SubjectHandler", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_VIEW_PROGRESS("Icon_ViewProgress", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_VIEW_QUALIFICATIONS("Icon_ViewQualifications", "", TypeButton.BUTTON_WITH_SIZE_100x100),
    BUTTON_ICON_VIEW_STUDENT_SUBJECTS("Icon_ViewStudentSubjects", "", TypeButton.BUTTON_WITH_SIZE_100x100);

    private final String m_src;
    private final String m_rolloverSrc;
    private final String m_pressedSrc;
    private final int m_width, m_heigth;
    private final String m_text;

    private static final String STANDARD_BUTTONS_SRC = "/View/Assets/Buttons/";
    private static final String BUTTONS_WITH_ICONS100x100_SRC = "/View/Assets/Icons/100x100/";
    private static final String BUTTONS_WITH_ICONS50x50_SRC = "/View/Assets/Icons/50x50/";

    private static final int STANDARD_BUTTON = 0;
    private static final int BUTTON_WITH_SIZE_50x50 = 1;
    private static final int BUTTON_WITH_SIZE_100x100 = 2;

    private static final int STANDARD_BUTTON_SIZE_1 = 200; 
    private static final int STANDARD_BUTTON_SIZE_2 = 50;
    
    private static final int BUTTONS_WITH_ICONS100x100_SIZE = 100;

    private static final int BUTTONS_WITH_ICONS50x50_SIZE = 50;

    private static final String BUTTON_EXT = ".png";
    private static final String BUTTON_ROLLOVER_SUFFIX = "_MouseOn";
    private static final String BUTTON_PRESSED_SUFFIX = "_Click";

    private TypeButton(String buttonName, String tex, int typeButton)
    {
        if (typeButton == TypeButton.STANDARD_BUTTON)
        {
            m_src = STANDARD_BUTTONS_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = STANDARD_BUTTONS_SRC + buttonName +
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = STANDARD_BUTTONS_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = STANDARD_BUTTON_SIZE_1;
            m_heigth = STANDARD_BUTTON_SIZE_2;
        }
        else if (typeButton == TypeButton.BUTTON_WITH_SIZE_50x50)
        {
            m_src = BUTTONS_WITH_ICONS50x50_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = BUTTONS_WITH_ICONS50x50_SRC + buttonName + 
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = BUTTONS_WITH_ICONS50x50_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = m_heigth = BUTTONS_WITH_ICONS50x50_SIZE;
        }
        else
        {
            m_src = BUTTONS_WITH_ICONS100x100_SRC + buttonName + BUTTON_EXT;

            m_rolloverSrc = BUTTONS_WITH_ICONS100x100_SRC + buttonName + 
                            BUTTON_ROLLOVER_SUFFIX + BUTTON_EXT;
            m_pressedSrc = BUTTONS_WITH_ICONS100x100_SRC + buttonName + 
                            BUTTON_PRESSED_SUFFIX + BUTTON_EXT;

            m_width = m_heigth = BUTTONS_WITH_ICONS100x100_SIZE;
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