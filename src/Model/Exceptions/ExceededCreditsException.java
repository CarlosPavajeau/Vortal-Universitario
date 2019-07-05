/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model.Exceptions;

/**
 * This is the class {@code ExceededCreditsExeption}. Is an {@code Exception}.
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