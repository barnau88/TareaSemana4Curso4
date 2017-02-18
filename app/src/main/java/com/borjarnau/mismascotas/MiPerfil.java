package com.borjarnau.mismascotas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ArnAu on 16/02/2017.
 */
public class MiPerfil extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String ACCION_KEY = "VER_MI_PERFIL";
        String accion = intent.getAction();

        if(ACCION_KEY.equals(accion)){
            Toast.makeText(context, "ES MI PERFIL  ", Toast.LENGTH_LONG).show();
        }

    }



}
