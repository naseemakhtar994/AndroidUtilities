package com.munix.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by munix on 24/03/16.
 */
public class Preferences {

    public static SharedPreferences getSharedPreferenceManager( Context context ) {
        try {
            return context.getSharedPreferences( context.getPackageName() + "_preferences", Context.MODE_PRIVATE );
        } catch ( Exception e ) {
            return null;
        }
    }

    /**
     * Elimina una preferencia almacenada en SharedPreferences
     *
     * @param context
     * @param key
     */
    public static Boolean deleteSharedPreference( Context context, String key ) {
        try {
            return getSharedPreferenceManager( context ).edit().remove( key ).commit();
        } catch ( Exception e ) {
        }
        return false;
    }

    /**
     * Elimina todas las Shared Preferences que empiecen con keyStartWith
     *
     * @param context
     * @param keyStartWith
     * @return
     */
    public static Boolean deleteSharedPreferenceByPartialKey( Context context, String keyStartWith ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            Map<String,?> keys = settings.getAll();
            SharedPreferences.Editor editor = settings.edit();
            for ( Map.Entry<String,?> entry : keys.entrySet() ) {
                if ( entry.getKey().startsWith( keyStartWith ) ) {
                    editor.remove( entry.getKey() );
                }
            }
            return editor.commit();
        } catch ( Exception e ) {
        }
        return false;
    }

    /**
     * Guardar una preferencia
     *
     * @param context
     * @param key
     * @param value
     */
    public static Boolean writeSharedPreference( Context context, String key, String value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            SharedPreferences.Editor editor = settings.edit();
            editor.putString( key, value );
            return editor.commit();
        } catch ( Exception e ) {
        }
        return false;
    }

    /**
     * Guardar una preferencia
     *
     * @param context
     * @param key
     * @param value
     */
    public static Boolean writeSharedPreference( Context context, String key, Boolean value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean( key, value );
            return editor.commit();
        } catch ( Exception e ) {
        }
        return false;
    }

    /**
     * Guardar una preferencia
     *
     * @param context
     * @param key
     * @param value
     */
    public static Boolean writeSharedPreference( Context context, String key, long value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            SharedPreferences.Editor editor = settings.edit();
            editor.putLong( key, value );
            return editor.commit();
        } catch ( Exception e ) {
        }
        return false;
    }

    /**
     * Lee una preferencia
     *
     * @param context
     * @param key
     * @param default_value
     * @return
     */
    public static Boolean readSharedPreference( Context context, String key, Boolean default_value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            return settings.getBoolean( key, default_value );
        } catch ( Exception e ) {
            return default_value;
        }
    }

    /**
     * Lee una preferencia
     *
     * @param context
     * @param key
     * @param default_value
     * @return
     */
    public static long readSharedPreference( Context context, String key, long default_value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            return settings.getLong( key, default_value );
        } catch ( Exception e ) {
            return default_value;
        }
    }

    /**
     * Lee una preferencia
     *
     * @param context
     * @param key
     * @param default_value
     * @return
     */
    public static String readSharedPreference( Context context, String key, String default_value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( context );
            return settings.getString( key, default_value );
        } catch ( Exception e ) {
            return default_value;
        }
    }
}
