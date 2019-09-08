/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model.Exceptions;

/**
 * This is the exception {@code ExceededCreditsExeption}. It's a {@code Exception}. 
 * This exception is when the objects that implement the 
 * interface {@code SubjectHandler} try to add a new subject and do not have the 
 * credits available to add it.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class ExceededCreditsException extends Exception
{

    private static final long serialVersionUID = 910021930941673946L;

    public ExceededCreditsException() 
    {
    }

    public ExceededCreditsException(String message) 
    {
        super(message);
    }

    public ExceededCreditsException(Throwable cause) 
    {
        super(cause);
    }

    public ExceededCreditsException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public ExceededCreditsException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace)         
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}