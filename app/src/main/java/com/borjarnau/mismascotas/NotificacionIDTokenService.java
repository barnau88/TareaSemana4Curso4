package com.borjarnau.mismascotas;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ArnAu on 20/12/2016.
 */
public class NotificacionIDTokenService extends FirebaseInstanceIdService {         //clase para obtener el token o el Id del dispisitivo

    private static final String TAG = "FIREBASE_TOKEN";

    @Override
    public void onTokenRefresh(){    //METODO A REESCRIBIR
        //super.onTokenRefresh();
        //aqui recuperamos el token cuando la app empieza a correr, sin necesidad de dar a ningun boton
        String token = FirebaseInstanceId.getInstance().getToken();     //pide a firebase un token y este la devuelve y la guarda en la variable (gracias al archivo google-servises.json)
        enviarTokenRegistro(token);

    }


    private void enviarTokenRegistro(String token){
        Log.d(TAG, token);
        //LUEGO LO PONDRE PARA QUE SE LO ENVIE AL SERVIDOR
    }
}

