package com.wadlow.orientation;

//One Layout XML File for Both Orientations,
// Modify the Layout by Code

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public final static int SPACING_VERTICAL = 50;
    public final static int SPACING_HORIZONTAL = 25;

    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Configuration config = getResources( ).getConfiguration( );
        modifyLayout( config );
    }

    public void onConfigurationChanged(@NonNull Configuration newConfig ) {
        super.onConfigurationChanged( newConfig );
        modifyLayout( newConfig );
    }

    public void modifyLayout( Configuration newConfig ) {
        Button b2 = ( Button ) findViewById( R.id.button2 );
        ViewGroup.MarginLayoutParams params2
                = (ViewGroup.MarginLayoutParams) b2.getLayoutParams( );
        Button b3 = ( Button ) findViewById( R.id.button3 );
        ViewGroup.MarginLayoutParams params3
                = (ViewGroup.MarginLayoutParams) b3.getLayoutParams( );

        if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            params2.setMargins( 0, SPACING_HORIZONTAL, 0, 0 );
            params3.setMargins( 0, SPACING_HORIZONTAL, 0, 0 );
        } else if( newConfig.orientation
                == Configuration.ORIENTATION_PORTRAIT ) {
            params2.setMargins( 0, SPACING_VERTICAL, 0, 0 );
            params3.setMargins( 0, SPACING_VERTICAL, 0, 0 );
        }
    }
}