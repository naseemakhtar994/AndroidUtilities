package com.munix.utilities;

import android.util.Log;

/**
 * Created by munix on 1/03/16.
 */
public class Logs {

    /**
     * Log verbose extendido
     *
     * @param tag
     * @param text
     */
    public static void verbose( String tag, String text ) {
        try {
            Log.v( tag, getFormattedLogLine() + text );
        } catch ( OutOfMemoryError error ) {
            error.printStackTrace();
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }

    /**
     * Log warn extendido
     *
     * @param tag
     * @param text
     */
    public static void warn( String tag, String text ) {
        try {
            Log.w( tag, getFormattedLogLine() + text );
        } catch ( OutOfMemoryError error ) {
            error.printStackTrace();
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }

    /**
     * Log error extendido
     *
     * @param tag
     * @param text
     */
    public static void error( String tag, String text ) {
        try {
            Log.e( tag, getFormattedLogLine() + text );
        } catch ( OutOfMemoryError error ) {
            error.printStackTrace();
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }

    private static String getFormattedLogLine() {
        String className = Threads.getCallerClassName( 5 );
        String methodName = Threads.getCallerMethodName( 5 );
        int lineNumber = Threads.getCallerLineNumber( 5 );
        return className + "." + methodName + "():" + lineNumber + ": ";
    }
}
