package es.munix.demo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.munix.utilities.DiskCache;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        DiskCache.get( this ).put( "test", "Hola" );

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Cache" );
        builder.setMessage( DiskCache.get( this ).getAsString( "test" ) );
        builder.setPositiveButton( "OK", null );
        builder.show();
    }
}
