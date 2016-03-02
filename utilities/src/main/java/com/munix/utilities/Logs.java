package com.munix.utilities;

import android.util.Log;

/**
 * Created by munix on 1/03/16.
 */
public class Logs {

    public static void verbose( String text ) {
        try {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            String className = fullClassName.substring( fullClassName.lastIndexOf( "." ) + 1 );
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            Log.v( className, className + "." + methodName + "():" + lineNumber + ": " + text );
        } catch ( OutOfMemoryError error ) {
            error.printStackTrace();
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }

    public static void warn( String text ) {
        try {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            String className = fullClassName.substring( fullClassName.lastIndexOf( "." ) + 1 );
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            Log.w( className, className + "." + methodName + "():" + lineNumber + ": " + text );
        } catch ( OutOfMemoryError error ) {
            error.printStackTrace();
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }

    public static void error( String text ) {
        try {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            String className = fullClassName.substring( fullClassName.lastIndexOf( "." ) + 1 );
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            Log.w( className, className + "." + methodName + "():" + lineNumber + ": " + text );
        } catch ( OutOfMemoryError error ) {
            error.printStackTrace();
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }
}
