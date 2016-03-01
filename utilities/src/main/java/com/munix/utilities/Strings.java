package com.munix.utilities;

/**
 * Created by munix on 1/03/16.
 */
public class Strings {

    /**
     * Comprueba si un string es posible evaularlo como integer
     *
     * @param s
     * @return
     */
    public static boolean isInteger( String s ) {
        try {
            Integer.parseInt( s );
        } catch ( NumberFormatException e ) {
            return false;
        }
        return true;
    }
}
