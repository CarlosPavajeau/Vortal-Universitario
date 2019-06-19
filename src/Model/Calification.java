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
    private Subject m_subject;
    private float[] m_notes;

    /**
     * Initialize a new {@code Calification} with these characteristics.
     * @param subject that is to be assigned to the object.
     */
    public Calification(Subject subject)
    {
        m_subject = subject;
        m_notes = new float[ACADEMICS_CORTS];
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
    public void AddNote(int academicCut, float note) throws IndexOutOfBoundsException
    {
        m_notes[academicCut] = note;
    }
}