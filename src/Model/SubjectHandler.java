/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

import Model.Exceptions.ExceededCreditsException;

/**
 * This is the interface {@code SubjectManager} for the handling of subjects.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
interface SubjectHandler
{
    /**
     * This method adds a new {@code Subject} to each object that implements this interface.
     * @param subject the {@code Subject} to add.
     * @return {@code true} if this object does not have the {@code Subject}. {@code false} otherwise.
     * @throws ExceededCreditsException if this object does not have available credits.
     * @see {@link #CanAddThisSubject(Subject)}
     */
    boolean AddSubject(Subject subject) throws ExceededCreditsException;

    /**
     * This method removes one {@code Subject} to each object that implements this interface.
     * @param subject the {@code Subject} to remove.
     * @return {@code true} if this object have the {@code Subject} and this one was eliminated. {@code false} otherwise.
     */
    boolean RemoveSubject(Subject subject);

    /**
     * This method validates if this object can register a more {@code Subject}.
     * @param subject the {@code Subject} to validate.
     * @return {@code true} if this object has available credits.
     * {@code false} otherwise. 
     */
    boolean CanAddThisSubject(Subject subject); 

    /**
     * This method returns the available credits that has this object.
     * @return the available credits tha has this object.
     */
    int GetAvailableCredits();
}