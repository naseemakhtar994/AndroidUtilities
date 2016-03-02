package com.munix.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by munix on 1/03/16.
 */
public class Strings {

    private final static char[] HEXADECIMAL = {
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'a',
            'b',
            'c',
            'd',
            'e',
            'f'
    };

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

    /**
     * Convierte un string a hash md5
     *
     * @param stringToHash
     * @return
     */
    public static String md5( String stringToHash ) {
        if ( stringToHash != null ) {
            try {
                MessageDigest md = MessageDigest.getInstance( "MD5" );
                byte[] bytes = md.digest( stringToHash.getBytes() );
                StringBuilder sb = new StringBuilder( 2 * bytes.length );
                for ( int i = 0; i < bytes.length; i++ ) {
                    int low = ( bytes[i] & 0x0f );
                    int high = ( ( bytes[i] & 0xf0 ) >> 4 );
                    sb.append( HEXADECIMAL[high] );
                    sb.append( HEXADECIMAL[low] );
                }
                return sb.toString();
            } catch ( NoSuchAlgorithmException e ) {
                return "";
            }
        } else {
            return "";
        }
    }
}
