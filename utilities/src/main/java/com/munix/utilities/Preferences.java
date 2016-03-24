package com.munix.utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by munix on 24/03/16.
 */
public class Preferences {

    private static SharedPreferences getSharedPreferenceManager( Context mContext ) {
        try {
            return mContext.getSharedPreferences( mContext.getPackageName() + "_preferences", Context.MODE_WORLD_WRITEABLE );
        } catch ( Exception e ) {
            return null;
        }
    }

    public static void writeSharedPreference( Context mContext, String key, String value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( mContext );
            SharedPreferences.Editor editor = settings.edit();
            editor.putString( key, value );
            editor.commit();
        } catch ( Exception e ) {
        }
    }

    public static void writeSharedPreference( Context mContext, String key, Boolean value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( mContext );
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean( key, value );
            editor.commit();
        } catch ( Exception e ) {
        }
    }

    public static void writeSharedPreference( Context mContext, String key, long value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( mContext );
            SharedPreferences.Editor editor = settings.edit();
            editor.putLong( key, value );
            editor.commit();
        } catch ( Exception e ) {
        }
    }

    public static Boolean readSharedPreference( Context mContext, String key, Boolean default_value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( mContext );
            return settings.getBoolean( key, default_value );
        } catch ( Exception e ) {
            return default_value;
        }
    }

    public static long readSharedPreference( Context mContext, String key, long default_value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( mContext );
            return settings.getLong( key, default_value );
        } catch ( Exception e ) {
            return default_value;
        }
    }

    public static String readSharedPreference( Context mContext, String key, String default_value ) {
        try {
            SharedPreferences settings = getSharedPreferenceManager( mContext );
            return settings.getString( key, default_value );
        } catch ( Exception e ) {
            return default_value;
        }
    }
}
