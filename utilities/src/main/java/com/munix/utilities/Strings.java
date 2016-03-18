package com.munix.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by munix on 1/03/16.
 */
public class Strings {

    /**
     * Une un array list de strings en un único string mediante un separador
     *
     * @param myList
     * @param separator
     * @return String
     */
    public static String implode( ArrayList<String> myList, String separator ) {
        String newString = "";
        for ( Iterator<String> it = myList.iterator(); it.hasNext(); ) {
            newString += it.next();
            if ( it.hasNext() ) {
                newString += separator;
            }
        }
        return newString;
    }

    /**
     * Une un array de strings en un único string mediante un separador
     *
     * @param myList
     * @param separator
     * @return String
     */
    public static String implode( String[] myList, String separator ) {
        String newString = "";

        for ( int i = 0; i <= myList.length; i++ ) {
            newString += myList[i];
            if ( i < myList.length ) {
                newString += separator;
            }
        }
        return newString;
    }

    /**
     * Reemplaza todas las apariciones del string buscado con el string de reemplazo
     *
     * @param source
     * @param target
     * @param replacement
     * @return String
     */
    public static String replace( String source, String target, String replacement ) {
        StringBuilder sbSource = new StringBuilder( source );
        StringBuilder sbSourceLower = new StringBuilder( source.toLowerCase() );
        String searchString = target.toLowerCase();

        int idx = 0;
        while ( ( idx = sbSourceLower.indexOf( searchString, idx ) ) != -1 ) {
            sbSource.replace( idx, idx + searchString.length(), replacement );
            sbSourceLower.replace( idx, idx + searchString.length(), replacement );
            idx += replacement.length();
        }
        sbSourceLower.setLength( 0 );
        sbSourceLower.trimToSize();

        return sbSource.toString();
    }

    /**
     * Comprueba si un string es posible evaularlo como integer
     *
     * @param string
     * @return true si se ha podido evaluar el string como entero
     */
    public static boolean isInteger( String string ) {
        try {
            Integer.parseInt( string );
        } catch ( NumberFormatException e ) {
            return false;
        }
        return true;
    }

    /**
     * Convierte un string a hash md5
     *
     * @param stringToHash
     * @return md5 del string
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
                    sb.append( Constants.HEXADECIMAL[high] );
                    sb.append( Constants.HEXADECIMAL[low] );
                }
                return sb.toString();
            } catch ( NoSuchAlgorithmException e ) {
                return "";
            }
        } else {
            return "";
        }
    }

    /**
     * Reemplaza algunos de los códigos html más comunes
     *
     * @param in
     * @return String
     */
    public static String replaceHTMLCodes( String in ) {
        String[] buenas = {
                "Á",
                "á",
                "É",
                "é",
                "Í",
                "í",
                "Ó",
                "ó",
                "Ú",
                "ú",
                "Ñ",
                "ñ",
                "Ü",
                "ü",
                "«",
                "»",
                "¿",
                "¡",
                "€",
                " ",
                "..."
        };
        String[] catalans = {
                "à",
                "è",
                "ì",
                "ò",
                "ù",
                "À",
                "È",
                "Ì",
                "Ò",
                "Ù",
                "ç",
                "Ç",
                "·",
                "...",
                "–"
        };
        String[] not_catalans = {
                "&#xe0;",
                "&#xe8;",
                "&#xec;",
                "&#xf2;",
                "&#xf9;",
                "&#xc0;",
                "&#xc8;",
                "&#xcc;",
                "&#xd2;",
                "&#xd9;",
                "&#xe7;",
                "&#xc7;",
                "&#xb7;",
                "&#x2026;",
                "&#x2013;"
        };

        String[] not1 = {
                "&#193;",
                "&#225;",
                "&#201;",
                "&#233;",
                "&#205;",
                "&#237;",
                "&#211;",
                "&#243;",
                "&#218;",
                "&#250;",
                "&#209;",
                "&#241;",
                "&#220;",
                "&#252;",
                "&#171;",
                "&#187;",
                "&#191;",
                "&#161;",
                "&#128;",
                " ",
                "..."
        };
        String[] not2 = {
                "&#xc4;",
                "&#xe1;",
                "&#xc9;",
                "&#xe9;",
                "&#xcd;",
                "&#xed;",
                "&#xd3;",
                "&#xf3;",
                "&#xda;",
                "&#xfa;",
                "&#xd1;",
                "&#xf1;",
                "&#xdc;",
                "&#xfc;",
                "&#xab;",
                "&#xbb;",
                "&#xbf;",
                "&#xa1;",
                "&#x80;",
                "&#xA0;",
                "..."
        };
        String[] not3 = {
                "&Aacute;",
                "&aacute;",
                "&Eacute;",
                "&eacute;",
                "&Iacute;",
                "&iacute;",
                "&Oacute;",
                "&oacute;",
                "&Uacute;",
                "&uacute;",
                "&Ntilde;",
                "&ntilde;",
                "&Uuml;",
                "&uuml;",
                "&laquo;",
                "&raquo;",
                "&iquest;",
                "&iexcl;",
                "&euro;",
                " ",
                "&hellip;"
        };

        for ( int i = 0; i < buenas.length; i++ ) {
            in = replace( in, not1[i], buenas[i] );
            in = replace( in, not2[i], buenas[i] );
            in = replace( in, not3[i], buenas[i] );
        }

        for ( int i = 0; i < catalans.length; i++ ) {
            in = replace( in, not_catalans[i], catalans[i] );
        }

        return in;
    }
}
