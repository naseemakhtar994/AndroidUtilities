package com.munix.utilities;

import android.content.Context;
import android.content.pm.PackageManager;

import java.io.File;

/**
 * Created by munix on 07/04/16.
 */
public class Application {

    /**
     * Elimina todos los datos de la aplicación
     *
     * @param context
     */
    public static void clearApplicationData( Context context ) {
        if ( context.getApplicationContext() != null ) {
            File cache = context.getApplicationContext().getCacheDir();
            File appDir = new File( cache.getParent() );
            if ( appDir.exists() ) {
                String[] children = appDir.list();
                for ( String s : children ) {
                    File f = new File( appDir, s );
                    Files.deleteDir( f );
                }
            }
        }
    }

    /**
     * Retorna el código de versión de la aplicación
     *
     * @param context
     * @return versionCode
     */
    public static int getVersionCode( Context context ) {
        int v = 0;
        try {
            v = context.getPackageManager().getPackageInfo( context.getPackageName(), 0 ).versionCode;
        } catch ( PackageManager.NameNotFoundException e ) {
        }
        return v;
    }

    /**
     * Retorna el nombre de la versión de la aplicación
     *
     * @param context
     * @return versionName
     */
    public static String getVersionName( Context context ) {
        String v = "";
        try {
            v = context.getPackageManager().getPackageInfo( context.getPackageName(), 0 ).versionName;
        } catch ( PackageManager.NameNotFoundException e ) {
        }
        return v;
    }
}
