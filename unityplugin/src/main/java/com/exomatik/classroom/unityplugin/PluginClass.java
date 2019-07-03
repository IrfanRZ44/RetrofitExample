package com.exomatik.classroom.unityplugin;

import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by IrfanRZ on 23/05/2019.
 */

public class PluginClass {

    public static String getTextFromPlugin(int number){

        return "Number is " + Integer.toString(number);
    }

    public static boolean onKeyDown(int keyCode, KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:

                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                Toast.makeText(this, "Bawah", Toast.LENGTH_SHORT).show();
                break;

            default:
//                Toast.makeText(this, "none", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
