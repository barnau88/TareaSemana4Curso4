package com.borjarnau.mismascotas;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.borjarnau.mismascotas.activities_menus.MenuAcercaDeActivity;
import com.borjarnau.mismascotas.activities_menus.MenuConfigurarCuenta;
import com.borjarnau.mismascotas.activities_menus.MenuContactoActivity;
import com.borjarnau.mismascotas.activities_menus.MenuRecibirNotificacionesActivity;
import com.borjarnau.mismascotas.adapter.PageAdapter;
import com.borjarnau.mismascotas.presentador.RecyclerViewFragmentPresenter;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.UsuarioResponse;
import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentView;
import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentViewII;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
//import com.borjarnau.mascotas.fragment.PerfilFragment;
//import com.borjarnau.mascotas.fragment.RecyclerViewFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private static final String ID_USUARIO = "4192443066";
    private static final String ID_REGISTRO = "-KcZ75MBiHBcDn7VQzfN";

    //private TextView tvUserName;

    //public static String URLFotoPrinci;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        //URLFotoPrinci = RecyclerViewFragmentPresenter.urlPerfilFoto;

       // Toast.makeText(this, URLFotoPrinci, Toast.LENGTH_LONG).show();
        setUpViewPager();


        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragmentView());   // fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragmentViewII());   //PerfilFragment()   //RecyclerViewFragmentViewII()
        return fragments;

    }

    public void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager() , agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);

    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mContacto:
                // Toast.makeText(this, "has pulsado menu contacto", Toast.LENGTH_LONG).show();

                Intent intent = new Intent (this , MenuContactoActivity.class);
                startActivity(intent);
                break;


            case R.id.mAcercaDe:
                // Toast.makeText(this, "has pulsado menu acerca de", Toast.LENGTH_LONG).show();

                Intent i = new Intent (this, MenuAcercaDeActivity.class);
                startActivity(i);
                break;

            case R.id.mConfigurarCuenta:
                // Toast.makeText(this, "has pulsado menu acerca de", Toast.LENGTH_LONG).show();

                Intent inte = new Intent (this, MenuConfigurarCuenta.class);
                startActivity(inte);
                break;

            case R.id.mRecibirNotificaciones:

                Intent kk = new Intent (this, MenuRecibirNotificacionesActivity.class);
                //startActivity(kk);

                String token = FirebaseInstanceId.getInstance().getToken();
                String nombre_usuario_instagram;
                String id_usuario_instagram;

                if(RecyclerViewFragmentViewII.quienEs == 1){
                    nombre_usuario_instagram = "perritopaco";
                    id_usuario_instagram = "4013497851" ;
                    kk.putExtra(getResources().getString(R.string.pnombre_usuario_instagram), nombre_usuario_instagram);
                    kk.putExtra(getResources().getString(R.string.pId_dispositivo), token);
                    kk.putExtra(getResources().getString(R.string.pId_usuario_instagram), id_usuario_instagram);

                    enviarTokenUsuarioInstagramRegistro(token, nombre_usuario_instagram, id_usuario_instagram);
                }else if (RecyclerViewFragmentViewII.quienEs == 2){
                    nombre_usuario_instagram = "niko_pty";
                    id_usuario_instagram = "4230859422";
                    kk.putExtra(getResources().getString(R.string.pnombre_usuario_instagram), nombre_usuario_instagram);
                    kk.putExtra(getResources().getString(R.string.pId_dispositivo), token);
                    kk.putExtra(getResources().getString(R.string.pId_usuario_instagram), id_usuario_instagram );

                    enviarTokenUsuarioInstagramRegistro(token, nombre_usuario_instagram, id_usuario_instagram);
                }else if (RecyclerViewFragmentViewII.quienEs == 3){
                    nombre_usuario_instagram = "gatoulises";
                    id_usuario_instagram = "4192443066";
                    kk.putExtra(getResources().getString(R.string.pnombre_usuario_instagram), nombre_usuario_instagram);
                    kk.putExtra(getResources().getString(R.string.pId_dispositivo), token);
                    kk.putExtra(getResources().getString(R.string.pId_usuario_instagram), id_usuario_instagram );

                    enviarTokenUsuarioInstagramRegistro(token, nombre_usuario_instagram, id_usuario_instagram);
                }else{
                    Toast.makeText(getBaseContext(), MenuConfigurarCuenta.nombreUsuarioNuevo + "  no ha compartido su usuario sandbox con el desarrollador de la App", Toast.LENGTH_LONG).show();
                    token = "id_dispositivo no valido";
                    nombre_usuario_instagram = "Usuario de instagram no valido, al no compartir su cuenta sandbox con el desarrollador de la App";
                    id_usuario_instagram = "Id del usuario de instagram no valido, al no compartir su cuenta sandbox con el desarrollador de la App";
                    kk.putExtra(getResources().getString(R.string.pnombre_usuario_instagram), "*****");
                    kk.putExtra(getResources().getString(R.string.pId_dispositivo), "*****");
                    kk.putExtra(getResources().getString(R.string.pId_usuario_instagram), "*****");

                    enviarTokenUsuarioInstagramRegistro(token, nombre_usuario_instagram, id_usuario_instagram);
                }

                //enviarTokenUsuarioInstagramRegistro(token, nombre_usuario_instagram, id_usuario_instagram);

                startActivity(kk);

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void irAFavoritos(View v){

        Intent intent = new Intent(this, Favoritas_Activity.class);
        startActivity(intent);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// ESTOS TRES METODOS , SON METODOS QUE UTILIZABA CUANDO TENIA EN EL LAYOUT TRES BOTONES, EN EL LAYOUT CORRESPONDIENTE LOS HE COMENTADO PARA QUE NO APAREZCAN////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    public void lanzarNotificacion(View v){
        Intent i = new Intent(this,  MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notificaciones)
                .setContentTitle("Notificación")
                .setContentText("Hola Mundo")
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                ;

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificacion.build());
    }

    public void recibirNotificaciones (View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", token);
    }


    public void  enviarTokenYUsuarioInstagram(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        String id_usuario_instagram ;
        String nombre_usuario_instagram;

        if(RecyclerViewFragmentViewII.quienEs == 1){
            nombre_usuario_instagram = "perritopaco";
            id_usuario_instagram = "4013497851" ;
        }else if (RecyclerViewFragmentViewII.quienEs == 2){
            nombre_usuario_instagram = "niko_pty";
            id_usuario_instagram = "4230859422";
        }else if (RecyclerViewFragmentViewII.quienEs == 3){
            nombre_usuario_instagram = "gatoulises";
            id_usuario_instagram = "4192443066";
        }else{
            Toast.makeText(getBaseContext(), MenuConfigurarCuenta.nombreUsuarioNuevo + "  no ha compartido su usuario sandbox con el desarrollador de la App", Toast.LENGTH_LONG).show();
            token = "id_dispositivo no valido";
            nombre_usuario_instagram = "Usuario de instagram no valido, al no compartir su cuenta sandbox con el desarrollador de la App";
            id_usuario_instagram = "Id del usuario de instagram no valido, al no compartir su cuenta sandbox con el desarrollador de la App";
        }

        enviarTokenUsuarioInstagramRegistro(token, nombre_usuario_instagram, id_usuario_instagram);
    }
*/
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void enviarTokenUsuarioInstagramRegistro(String id_dispositivo, String  nombre_usuario_instagram, String id_usuario_instagram){
        Log.d("TOKEN", id_dispositivo);
        Log.d("NOMBRE_EN_INSTAGRAM", nombre_usuario_instagram);
        Log.d("ID_USUARIO_EN_INSTAGRAM", id_usuario_instagram);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        //NO SE NECESITA DESERIALIZADOR PARA DESERIALIZAR LOS DATOS MANDADOS A LA DB
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestAPIServidor();
        Call<UsuarioResponse> usuarioResponseCall = endPointApi.registrarIdDispositivo(id_dispositivo, nombre_usuario_instagram,id_usuario_instagram);   //esto manda estos datos al servidor

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_REGISTRO", usuarioResponse.getId_regristro());
                Log.d("ID_DISPOSITIVO", usuarioResponse.getId_dispositivo());
                Log.d("USUARIO", usuarioResponse.getNombre_usuario_instagram());
                Log.d("ID_USUARIO_INSTAGRAM", usuarioResponse.getId_usuario_instagram());

                //Toast.makeText(getBaseContext(),  "  HAS LLEGADO A ESTE PUNTO ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }

/*
    public  void darId(View v){
        Log.d("QUIERO IDDDDDDDDDD", "true");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endpoints = restApiAdapter.establecerConexionRestAPIServidor();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.dameIdDispo(ID_USUARIO);     // , ID_USUARIO

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_USUUUUUU", usuarioResponse.getId_dispositivo());
                Toast.makeText(getBaseContext(),usuarioResponse.getId_dispositivo() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }
*/
}
