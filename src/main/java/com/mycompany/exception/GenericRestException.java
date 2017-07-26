package com.mycompany.exception;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 19, 2017
 * Time: 6:30:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenericRestException extends Exception {
    public GenericRestException(Exception ex) {
        super (ex);
    }
}
