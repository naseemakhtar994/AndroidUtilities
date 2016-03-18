package com.munix.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by munix on 18/03/16.
 */
public class Files {

    /**
     * Elimina un directorio de manera recursiva
     *
     * @param dir
     * @return true si ha podido eliminarlo, false en caso contrario
     */
    public static boolean deleteDir( File dir ) {
        if ( dir != null && dir.isDirectory() ) {
            String[] children = dir.list();
            for ( int i = 0; i < children.length; i++ ) {
                boolean success = deleteDir( new File( dir, children[i] ) );
                if ( !success ) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * Retorna un byte array de un fichero
     *
     * @param file
     * @return byte[]
     * @throws IOException
     */
    public static byte[] getBytesFromFile( File file ) throws IOException {
        InputStream is = new FileInputStream( file );
        long length = file.length();

        if ( length > Integer.MAX_VALUE ) {
            throw new IOException( "File is too large" );
        }

        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while ( offset < bytes.length && ( numRead = is.read( bytes, offset, bytes.length - offset ) ) >= 0 ) {
            offset += numRead;
        }

        if ( offset < bytes.length ) {
            throw new IOException( "Could not completely read file " + file.getName() );
        }
        is.close();
        return bytes;
    }
}
