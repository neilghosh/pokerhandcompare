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
public class DuplicateCardsException extends Exception {

    /**
     * Creates a new instance of <code>DuplicateCardsException</code> without
     * detail message.
     */
    public DuplicateCardsException() {
    }

    /**
     * Constructs an instance of <code>DuplicateCardsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateCardsException(String msg) {
        super(msg);
    }
}
