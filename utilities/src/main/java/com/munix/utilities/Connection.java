package com.munix.utilities;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by munix on 18/03/16.
 */
public class Connection {

    /**
     * Comprueba si tenemos conexión a internet
     *
     * @param context
     * @return true si está conectado a internet, false en caso contrario
     */
    public static Boolean isConnected( Context context ) {
        try {
            ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
            if ( conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected() ) {
                return true;
            } else {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }
    }
}
