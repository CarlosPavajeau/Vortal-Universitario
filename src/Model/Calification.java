/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;


/**
 * This is the class {@code Calification}. Represent a calification.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Calification
{
    private static final int ACADEMICS_CORTS = 3;
    private static final int NOTE_EMPTY = -1;

    private Subject m_subject;
    private float[] m_notes;

    /**
     * Initialize a new {@code Calification} with these characteristics.
     * @param subject that is to be assigned to the object.
     */
    public Calification(Subject subject)
    {
        this(subject, new float[]{NOTE_EMPTY, NOTE_EMPTY, NOTE_EMPTY});
    }

    /**
     * Initialize a new {@code Calification} with these characteristics.
     * @param subject that is to be assigned to the object.
     * @param notes it will be the notes that this {@code Calification} has.
     */
    public Calification(Subject subject, float[] notes)
    {
        m_subject = subject;
        m_notes = notes;
    }

    /**
     * This method returns the subject that this {@code Calification} has. 
     * @return the subject that this {@code Calification} has.
     */
    public Subject GetSubject()
    {
        return m_subject;
    }

    /**
     * This method returns the notes that this {@code Calification} has. 
     * @return the notes that this {@code Calification} has.
     */
    public float[] GetNotes()
    {
        return m_notes;
    }

    /**
     * This method returns one note that this {@code Calification} has.
     * @param cort is a academic cut 
     * @return one note that this {@code Calification} has.
     */
    public float GetNote(int cort)
    {
        return m_notes[cort];
    }

    /**
     * This method add a new note for this {@code Calification}
     * @param academicCut It will be the academic cut evaluated
     * @param note It will be the note of that academic cut.
     */
    public void AddNote(int academicCut, float note)
    {
        m_notes[academicCut] = note;
    }

    /**
     * This method does the action of validate that this object {@code Calification} not has one note.
     * @return {@code true} if this object {@code Clification} has one note. {@code false} otherwise.
     */
    public boolean HasNotes()
    {
        for (float note : m_notes)
            if (!IsNoteEmpty(note))
                return true;
        return false;
    }

    /**
     * This method return the current average that have this {@code Calification}.
     * @return the current average of this {@code Calification}.
     */
    public float GetAverage()
    {
        float average = 0.0f;
        for (int i = 0; i < ACADEMICS_CORTS; i++)
        {
            if (!IsNoteEmpty(m_notes[i]))
            {
                if (i < ACADEMICS_CORTS - 1)/**First or second academic cut*/
                    average += m_notes[i] * 0.3; /**30% */
                else /**Third academic cut */
                    average += m_notes[i] * 0.4; /**40% */
            }
        }

        return average;
    }

    /**
     * This method validate if this note is not empty.
     * @param note to validate.
     * @return {@code true} if note == {@code NOTE_EMPTY}. {@code false} otherwise.
     */
    private boolean IsNoteEmpty(float note)
    {
        return note == NOTE_EMPTY;
    }
}