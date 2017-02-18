package com.borjarnau.mismascotas.activities_menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ArnAu on 22/12/2016.
 */
public class MenuRecibirNotificacionesActivity extends AppCompatActivity  {

    private TextView tvNombreUsuarioInstagram;
    private TextView tvIdDispositivo;
    private TextView tvIdUsuarioInstagram;
    //private TextView tvIdRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recibir_notificaciones);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       // if(RecyclerViewFragmentViewII.quienEs != 0){
        //}

        //String id_dispositivo = FirebaseInstanceId.getInstance().getToken();
       //enviarIdREGISTRO(id_dispositivo);

        Bundle parametros = getIntent().getExtras();

        String nuevoPnombreUsuario = parametros.getString(getResources().getString(R.string.pnombre_usuario_instagram));
        String nuevoPidDispositivo = parametros.getString(getResources().getString(R.string.pId_dispositivo));
        String nuevoPidUsuarioInstagram = parametros.getString(getResources().getString(R.string.pId_usuario_instagram));

        tvNombreUsuarioInstagram = (TextView) findViewById(R.id.tvNombreUsuarioInstagram);
        tvIdDispositivo = (TextView) findViewById(R.id.tvIdDispositivo);
        tvIdUsuarioInstagram = (TextView) findViewById(R.id.tvIdUsuarioInstagram);

        tvNombreUsuarioInstagram.setText(nuevoPnombreUsuario);
        tvIdDispositivo.setText(nuevoPidDispositivo);
        tvIdUsuarioInstagram.setText(nuevoPidUsuarioInstagram);

    }


   /* private void enviarIdREGISTRO(String id_dispositivo){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorInsertarDatosDB();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestAPIServidor(gsonMediaRecent);
        Call<UsuarioResponse> usuarioResponseCall = endPointApi.registrarIdDispositivo(id_dispositivo);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_REGISTRO", usuarioResponse.getId_regristro());
                Log.d("ID_DISPOSITIVO", usuarioResponse.getId_dispositivo());
                Log.d("ID_USUARIO_INSTAGRAM", usuarioResponse.getId_usuario_instagram());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }*/
}
