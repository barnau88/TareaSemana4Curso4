package com.borjarnau.mismascotas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ArnAu on 16/02/2017.
 */
public class PerfilDeUnUsuario extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {



        String ACCION_KEY = "VER_USUARIO";
        String accion = intent.getAction();

        if(ACCION_KEY.equals(accion)){
            Toast.makeText(context, "ES EL PERFIL DE UN USUARIO ", Toast.LENGTH_LONG).show();
        }

    }
}
