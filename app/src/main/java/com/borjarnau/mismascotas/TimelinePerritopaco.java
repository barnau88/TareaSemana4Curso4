package com.borjarnau.mismascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.adapter.MascotaAdaptadorFavo;
import com.borjarnau.mismascotas.adapter.MiMascotaAdaptador;
import com.borjarnau.mismascotas.db.ConstructorMascotas;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ArnAu on 16/02/2017.
 */
public class TimelinePerritopaco extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;

    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_perritopaco);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rvMascotas= (RecyclerView) findViewById(R.id.rvMascotas);

        obtenerMediosRecientes();
    }

    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();


                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                //Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void mostrarMascotasRV() {
        inicializarAdaptadorRV(crearAdaptador(mascotas));
        generarGridLayout();
    }

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }


    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos) {
        MascotaAdaptador adaptador = new MascotaAdaptador(contactos, this  );
        return adaptador;
    }


    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvMascotas.setLayoutManager(gridLayoutManager);
    }





}