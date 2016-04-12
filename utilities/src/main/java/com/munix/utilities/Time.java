package com.munix.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by munix on 07/04/16.
 */
public class Time {

    /**
     * Convierte el formato ISO 8601 PT#M#S# de las duraciones de youtube a timestamp
     *
     * @param youtubeTimeFormat
     * @return
     */
    public static long getYoutubeTimeInMilliseconds( String youtubeTimeFormat ) {
        String formatted = youtubeTimeConverterToHumanReadable( youtubeTimeFormat );
        SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
        sdf.setTimeZone( TimeZone.getTimeZone( "UTC" ) );

        Date date = null;
        try {
            date = sdf.parse( formatted );
            return date.getTime();
        } catch ( ParseException e ) {
            String temp = "",
                    hour = "",
                    minute = "",
                    second = "",
                    returnString;

            // Starts in position 2 to ignore P and T characters
            for ( int i = 2; i < youtubeTimeFormat.length(); ++i ) {
                // Put current char in c
                char c = youtubeTimeFormat.charAt( i );

                // Put number in temp
                if ( c >= '0' && c <= '9' )
                    temp = temp + c;
                else {
                    // Test char after number
                    switch( c ) {
                        case 'H': // Deal with hours
                            // Puts a zero in the left if only one digit is found
                            if ( temp.length() == 1 )
                                temp = "0" + temp;

                            // This is hours
                            hour = temp;

                            break;

                        case 'M': // Deal with minutes
                            // Puts a zero in the left if only one digit is found
                            if ( temp.length() == 1 )
                                temp = "0" + temp;

                            // This is minutes
                            minute = temp;

                            break;

                        case 'S': // Deal with seconds
                            // Puts a zero in the left if only one digit is found
                            if ( temp.length() == 1 )
                                temp = "0" + temp;

                            // This is seconds
                            second = temp;

                            break;
                    } // switch (c)

                    // Restarts temp for the eventual next number
                    temp = "";
                } // else
            } // for

            if ( hour == "" && minute == "" ) // Only seconds
                return Integer.parseInt( second ) * 1000;
            else {
                if ( hour == "" ) // Minutes and seconds
                    return ( ( Integer.parseInt( minute ) * 60 ) + Integer.parseInt( second ) ) * 1000;

                else // Hours, minutes and seconds
                    return ( ( Integer.parseInt( hour ) * 60 * 60 ) + ( Integer.parseInt( minute ) * 60 ) + Integer.parseInt( second ) ) * 1000;
            }
        }
    }

    /**
     * Convierte el formato ISO 8601 PT#M#S# de las duraciones de youtube a un formato humano tipo hh:mm:ss
     *
     * @param youtubeTimeFormat
     * @return
     */
    public static String youtubeTimeConverterToHumanReadable( String youtubeTimeFormat ) {
        // Gets a PThhHmmMssS time and returns a hh:mm:ss time

        String temp = "",
                hour = "",
                minute = "",
                second = "",
                returnString;

        // Starts in position 2 to ignore P and T characters
        for ( int i = 2; i < youtubeTimeFormat.length(); ++i ) {
            // Put current char in c
            char c = youtubeTimeFormat.charAt( i );

            // Put number in temp
            if ( c >= '0' && c <= '9' )
                temp = temp + c;
            else {
                // Test char after number
                switch( c ) {
                    case 'H': // Deal with hours
                        // Puts a zero in the left if only one digit is found
                        if ( temp.length() == 1 )
                            temp = "0" + temp;

                        // This is hours
                        hour = temp;

                        break;

                    case 'M': // Deal with minutes
                        // Puts a zero in the left if only one digit is found
                        if ( temp.length() == 1 )
                            temp = "0" + temp;

                        // This is minutes
                        minute = temp;

                        break;

                    case 'S': // Deal with seconds
                        // Puts a zero in the left if only one digit is found
                        if ( temp.length() == 1 )
                            temp = "0" + temp;

                        // This is seconds
                        second = temp;

                        break;
                } // switch (c)

                // Restarts temp for the eventual next number
                temp = "";
            } // else
        } // for

        if ( hour == "" && minute == "" ) // Only seconds
            returnString = second;
        else {
            if ( hour == "" ) // Minutes and seconds
                returnString = minute + ":" + second;
            else // Hours, minutes and seconds
                returnString = hour + ":" + minute + ":" + second;
        }

        // Returns a string in hh:mm:ss format
        return returnString;
    }
}
