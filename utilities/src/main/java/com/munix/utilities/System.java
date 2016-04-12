package com.munix.utilities;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by munix on 07/04/16.
 */
public class System {

    /**
     * Comprueba si una aplicación está instalada
     *
     * @param context
     * @param packageName
     * @return true si el nombre del paquete está instalado en el dispositivo
     */
    public static Boolean isPackageInstalled( Context context, String packageName ) {
        try {
            @SuppressWarnings( "unused" ) ApplicationInfo info = context.getApplicationContext().getPackageManager().getApplicationInfo( packageName, 0 );
            return true;
        } catch ( PackageManager.NameNotFoundException e ) {
            return false;
        }
    }
}
