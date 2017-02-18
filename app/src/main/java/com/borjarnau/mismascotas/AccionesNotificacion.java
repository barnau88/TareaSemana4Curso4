package com.borjarnau.mismascotas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ArnAu on 16/02/2017.
 */
public class AccionesNotificacion extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String ACCION_KEY1 = "VER_MI_PERFIL";
        String ACCION_KEY2 = "FOLLOW_UNFOLLOW";
        String ACCION_KEY3 = "VER_USUARIO";
        String accion = intent.getAction();

        if (ACCION_KEY1.equals(accion)) {
            Toast.makeText(context, "ES MI PERFIL ", Toast.LENGTH_LONG).show();
        } else if (ACCION_KEY2.equals(accion)) {
            Toast.makeText(context, "ES ES DE FOLLOW ", Toast.LENGTH_LONG).show();
        } else if (ACCION_KEY3.equals(accion)) {
            Toast.makeText(context, "ES EL PERFIL DE UN USUARIO ", Toast.LENGTH_LONG).show();

        }

    }


}