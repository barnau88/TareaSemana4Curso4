package com.borjarnau.mismascotas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.UsuarioFollowedResponse;
import com.borjarnau.mismascotas.restApi.model.UsuarioResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ArnAu on 16/02/2017.
 */
public class Follow extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {

        String ACCION_KEY = "FOLLOW_UNFOLLOW";
        String accion = intent.getAction();

        final String FOLLOW = "follow";
        final String UNFOLLOW = "unfollow";


        final String id_user= "4192443066";

        if(ACCION_KEY.equals(accion)){


            RestApiAdapter restApiAdapter = new RestApiAdapter();
            Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorSaberSiSeLeSigue(id_user);
            EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
            Call<UsuarioFollowedResponse> usuarioFollowedResponseCall = endPointApi.yaLeSeguia();

            usuarioFollowedResponseCall.enqueue(new Callback<UsuarioFollowedResponse>() {
                @Override
                public void onResponse(Call<UsuarioFollowedResponse> call, Response<UsuarioFollowedResponse> response) {
                    UsuarioFollowedResponse usuarioFollowedResponse = response.body();

                    if( usuarioFollowedResponse.isYaLeSeguias() == false){
                        darFollowUnfollow(FOLLOW, context);
                        Toast.makeText(context, "HAS EMPEZADO A SEGUIRLE ", Toast.LENGTH_LONG).show();
                        //yaLeSigues = true;
                    }else {
                        darFollowUnfollow(UNFOLLOW, context);
                        Toast.makeText(context, "HAS DEJADO DE SEGUIRLE", Toast.LENGTH_LONG).show();
                        //yaLeSigues = false;
                    }

                }

                @Override
                public void onFailure(Call<UsuarioFollowedResponse> call, Throwable t) {

                }
            });







        }

    }

    public void darFollowUnfollow(String action, final Context context){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram2();
        Call<UsuarioResponse> usuarioResponseCall = endPointApi.seguirDejarSeguirUsuario(action);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {

                UsuarioResponse usuarioResponse = response.body();
                //Log.d("EOOOOOOOOOOOOO", "HA LLEGADO AKIIIIIIIIIIIIIIIIIIIIIIIIIII");
                //Toast.makeText(context, "ES ES DE FOLLOW ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

    }
}
