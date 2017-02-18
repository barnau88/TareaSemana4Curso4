package com.borjarnau.mismascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.adapter.MiMascotaAdaptador;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoPerfilResponse;
import com.borjarnau.mismascotas.restApi.model.MascotaResponse;
import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentViewII;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ArnAu on 17/02/2017.
 */
public class PerfilUsuarioReiteado extends AppCompatActivity {

    public String urlPerfilFoto ;

    public static ImageView imgFotoMiMascota;

    private RecyclerView rvMascotasGrid;

    private ArrayList<Mascota> mascotas;

    private TextView tvUserName;

    public static int quienEs = 0;
    public static String nuevoPnombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_reiteado);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imgFotoMiMascota = (ImageView) findViewById(R.id.imgFotoMiMascota);

        rvMascotasGrid= (RecyclerView) findViewById(R.id.rvMascotasGrid);

        tvUserName = (TextView) findViewById(R.id.tvUserName);

        tvUserName.setText(nuevoPnombre);


        if(this.quienEs == 1){
            obtenerFotoPerfilNiko_pty();
            obtenerMediosRecientesNiko_pty();
        }else if (this.quienEs == 2){
            obtenerFotoPerfilGatoulises();
            obtenerMediosRecientesGatoulises();
        }


    }


    public void obtenerFotoPerfilGatoulises() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorFotoPerrfil();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaFotoPerfilResponse> mascotaFotoPerfilResponseCall = endPointApi.getFotoPerfilGatoulises();

        mascotaFotoPerfilResponseCall.enqueue(new Callback<MascotaFotoPerfilResponse>() {
            @Override
            public void onResponse(Call<MascotaFotoPerfilResponse> call, Response<MascotaFotoPerfilResponse> response) {
                MascotaFotoPerfilResponse mascotaFotoPerfilResponse = response.body();
                urlPerfilFoto = mascotaFotoPerfilResponse.getUrlFotoPerfil();

                //Toast.makeText(context, urlPerfilFoto, Toast.LENGTH_LONG).show();


                mostrarFotoPerfilUser(urlPerfilFoto);

            }

            @Override
            public void onFailure(Call<MascotaFotoPerfilResponse> call, Throwable t) {
                // Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }



    public void obtenerMediosRecientesGatoulises() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMediaGatoulises();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();


                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasUserRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                //Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }



    public void obtenerFotoPerfilNiko_pty() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorFotoPerrfil();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaFotoPerfilResponse> mascotaFotoPerfilResponseCall = endPointApi.getFotoPerfilNiko_pty();

        mascotaFotoPerfilResponseCall.enqueue(new Callback<MascotaFotoPerfilResponse>() {
            @Override
            public void onResponse(Call<MascotaFotoPerfilResponse> call, Response<MascotaFotoPerfilResponse> response) {
                MascotaFotoPerfilResponse mascotaFotoPerfilResponse = response.body();
                urlPerfilFoto = mascotaFotoPerfilResponse.getUrlFotoPerfil();

                //Toast.makeText(context, urlPerfilFoto, Toast.LENGTH_LONG).show();


                mostrarFotoPerfilUser(urlPerfilFoto);

            }

            @Override
            public void onFailure(Call<MascotaFotoPerfilResponse> call, Throwable t) {
                //Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }




    public void obtenerMediosRecientesNiko_pty() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMediaNiko_pty();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();


                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasUserRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                //Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }



    public void mostrarFotoPerfilUser(String x){
        Picasso.with(this)
                .load(x)
                .placeholder(R.drawable.perro1)
                .into(imgFotoMiMascota);

    }


    public void mostrarMascotasUserRV() {
        inicializarAdaptadorMiMascotaRV(crearAdaptadorMiMascota(mascotas));
        generarGridLayout();
    }






    public void inicializarAdaptadorMiMascotaRV(MiMascotaAdaptador adaptador) {

        rvMascotasGrid.setAdapter(adaptador);
    }

    public MiMascotaAdaptador crearAdaptadorMiMascota(ArrayList<Mascota> mascotas) {
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(mascotas, this);

        return adaptador;
    }


    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvMascotasGrid.setLayoutManager(gridLayoutManager);

    }

}
