package com.munix.utilities;

/**
 * Created by munix on 07/04/16.
 */
public class Threads {

    /**
     * Retorna el nombre de la clase dentro de la posición del stacktrace del hilo principal
     *
     * @param stackTracePosition
     * @return String
     */
    public static String getCallerClassName( int stackTracePosition ) {
        String fullClassName = Thread.currentThread().getStackTrace()[stackTracePosition].getClassName();
        return fullClassName.substring( fullClassName.lastIndexOf( "." ) + 1 );
    }

    /**
     * Retorna el nombre del método de la clase dentro de la posición del stacktrace del hilo principal
     *
     * @param stackTracePosition
     * @return String
     */
    public static String getCallerMethodName( int stackTracePosition ) {
        return Thread.currentThread().getStackTrace()[stackTracePosition].getMethodName();
    }

    /**
     * Retorna el número de la línea de la clase dentro de la posición del stacktrace del hilo principal
     *
     * @param stackTracePosition
     * @return int
     */
    public static int getCallerLineNumber( int stackTracePosition ) {
        return Thread.currentThread().getStackTrace()[stackTracePosition].getLineNumber();
    }
}
