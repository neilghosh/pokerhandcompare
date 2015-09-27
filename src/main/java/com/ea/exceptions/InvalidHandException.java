/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ea.exceptions;

/**
 *
 * @author neil
 */
public class InvalidHandException extends Exception {

    /**
     * Creates a new instance of <code>NewException</code> without detail
     * message.
     */
    public InvalidHandException() {
    }

    /**
     * Constructs an instance of <code>InvalidHandException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidHandException(String msg) {
        super(msg);
    }
}
