package com.borjarnau.mismascotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borjarnau.mismascotas.DetalleMascota;
import com.borjarnau.mismascotas.NotificationService;
import com.borjarnau.mismascotas.PerfilUsuarioReiteado;
import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.presentador.IRecyclerViewFragmentPresenter;
import com.borjarnau.mismascotas.presentador.RecyclerViewFragmentPresenter;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.FotoResponse;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoPerfilResponse;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoResponse;
import com.borjarnau.mismascotas.restApi.model.MascotaResponse;
import com.borjarnau.mismascotas.restApi.model.UsuarioResponse;
import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentViewII;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{


    ArrayList<Mascota> mascotas;
    Activity activity;




    public MascotaAdaptador(ArrayList<Mascota>mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }



    //inflar o dar vida a el layout (cardview) y lo pasara al viewholder para el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //aqui indicamos cual es el layout que estara reciclando el recycleview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de nuestra lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {

        final Mascota mascota = mascotas.get(position);

        //////////mascotaViewHolder.imgFoto.setImageResource(mascota.getUrlFoto());
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.perro1)
                .into(mascotaViewHolder.imgFoto);

        //mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        //mascotaViewHolder.tvNumMeGustas.setInputType(mascota.getNumMegustas());
        //mascotaViewHolder.tvNumMeGustas.setText(Integer.toString(mascota.getNumMegustas()));
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));


        ///////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////

        String id_usuario = mascota.getId();
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorIdDeLaFoto(mascota.getNumeroDeLaFoto());
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaFotoResponse> mascotaFotoResponseCall = endPointApi.getIdMedia(id_usuario);

        mascotaFotoResponseCall.enqueue(new Callback<MascotaFotoResponse>() {
            @Override
            public void onResponse(Call<MascotaFotoResponse> call, Response<MascotaFotoResponse> response) {
                MascotaFotoResponse mascotaFotoResponse = response.body();
                //YA TENGO EL ID DE LA FOTO
                //Toast.makeText(activity, "EL ID DE LA FOTO ES " + mascotaFotoResponse.getMediaId(), Toast.LENGTH_LONG).show();


                RestApiAdapter restApiAdapter = new RestApiAdapter();
                Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorLikeDadoPorPerritopaco(mascotaFotoResponse.getMediaId()); //XXXXXX
                EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

                Call<MascotaFotoResponse> mascotaFotoResponseCall = endPointApi.darListaDeUsuariosQueHanDadoLike(mascotaFotoResponse.getMediaId());

                mascotaFotoResponseCall.enqueue(new Callback<MascotaFotoResponse>() {
                    @Override
                    public void onResponse(Call<MascotaFotoResponse> call, Response<MascotaFotoResponse> response) {
                        MascotaFotoResponse mascotaFotoResponse = response.body();

                        //Toast.makeText(activity, "LE HABIA DADO ME GUSTA?   " + mascotaFotoResponse.isYaTeGustaba(), Toast.LENGTH_LONG).show();


                        if(mascotaFotoResponse.isYaTeGustaba()== false ){

                            mascotaViewHolder.ivBone.setImageResource(R.drawable.hueso2);

                        }else{
                            mascotaViewHolder.ivBone.setImageResource(R.drawable.huesoamarillo);
                        }

                    }

                    @Override
                    public void onFailure(Call<MascotaFotoResponse> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<MascotaFotoResponse> call, Throwable t) {

            }
        });




        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////

        mascotaViewHolder.ivBone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String id_usuario = mascota.getId();

                //NotificationService.nombreUser = mascota.getNombreCompleto();
                //String id_dispositivo = mascota.getId_dispositivo();
                //Toast.makeText(activity, id_dispositivo, Toast.LENGTH_LONG).show();

                 //NotificationService.id_user = id_usuario;



                RestApiAdapter restApiAdapter = new RestApiAdapter();
                Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorIdDeLaFoto(mascota.getNumeroDeLaFoto());
                EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

                Call<MascotaFotoResponse> mascotaFotoResponseCall = endPointApi.getIdMedia(id_usuario);

                mascotaFotoResponseCall.enqueue(new Callback<MascotaFotoResponse>() {
                    @Override
                    public void onResponse(Call<MascotaFotoResponse> call, Response<MascotaFotoResponse> response) {
                        MascotaFotoResponse mascotaFotoResponse = response.body();
                        //YA TENGO EL ID DE LA FOTO
                        //Toast.makeText(activity, "EL ID DE LA FOTO ES " + mascotaFotoResponse.getMediaId(), Toast.LENGTH_LONG).show();


                        RestApiAdapter restApiAdapter = new RestApiAdapter();
                        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorLikeDadoPorPerritopaco(mascotaFotoResponse.getMediaId()); //XXXXXX
                        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

                        Call<MascotaFotoResponse> mascotaFotoResponseCall = endPointApi.darListaDeUsuariosQueHanDadoLike(mascotaFotoResponse.getMediaId());

                        mascotaFotoResponseCall.enqueue(new Callback<MascotaFotoResponse>() {
                            @Override
                            public void onResponse(Call<MascotaFotoResponse> call, Response<MascotaFotoResponse> response) {
                                final MascotaFotoResponse mascotaFotoResponse = response.body();

                                //Toast.makeText(activity, "LE HABIA DADO ME GUSTA?   " + mascotaFotoResponse.isYaTeGustaba(), Toast.LENGTH_LONG).show();


                                if(mascotaFotoResponse.isYaTeGustaba()== false && mascota.isTeGustaLaFoto() == false){
                                    //Toast.makeText(activity, "Diste like a " + mascota.getNombreCompleto(), Toast.LENGTH_SHORT).show();
                                    mascota.setTeGustaLaFoto(true);
                                    mascota.setLikes(mascota.getLikes() + 1);
                                    mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));
                                    mascotaViewHolder.ivBone.setImageResource(R.drawable.huesoamarillo);
                                    RestApiAdapter restApiAdapter = new RestApiAdapter();
                                    EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram2();
                                    EndPointApi endpoints = restApiAdapter.establecerConexionRestAPIServidor();

                                    Call<MascotaResponse> mascotaResponseCall = endPointApi.darLike(mascotaFotoResponse.getMediaId());
                                    Call<UsuarioResponse> usuarioResponseCall = endpoints.dameIdDispo(id_usuario);

                                    usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
                                        @Override
                                        public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                                            UsuarioResponse usuarioResponse = response.body();
                                            //YA TENGO EL ID DEL DISPOSITIVO
                                            //Log.d("ID_USUUUUUU", usuarioResponse.getId_dispositivo());
                                            //Toast.makeText(getBaseContext(),usuarioResponse.getId_dispositivo() , Toast.LENGTH_LONG).show();

                                            //VAMOS A REGISTRAR EL LIKE A CADA FOTO Q ME GUSTE
                                            RestApiAdapter restApiAdapter = new RestApiAdapter();
                                            EndPointApi endpoints = restApiAdapter.establecerConexionRestAPIServidor();

                                            Call<FotoResponse> mascotaFotoResponseCall = endpoints.registrarLike(mascotaFotoResponse.getMediaId(), id_usuario, usuarioResponse.getId_dispositivo());

                                            mascotaFotoResponseCall.enqueue(new Callback<FotoResponse>() {
                                                @Override
                                                public void onResponse(Call<FotoResponse> call, Response<FotoResponse> response) {
                                                    FotoResponse fotoResponse = response.body();
                                                   // Log.d("ID_FOTO", fotoResponse.getId_foto_instagram());
                                                   // Log.d("ID_USUARIO_INSTA", fotoResponse.getId_usuario_instagram());
                                                   // Log.d("ID_DISPOSITIVO", fotoResponse.getId_dispositivo());



                                                }

                                                @Override
                                                public void onFailure(Call<FotoResponse> call, Throwable t) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onFailure(Call<UsuarioResponse> call, Throwable t) {

                                        }
                                    });

                                    mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
                                        @Override
                                        public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                                            MascotaResponse mascotaResponse = response.body();
                                            Log.d("DISTE LIKE A ", mascota.getNombreCompleto());


                                        }

                                        @Override
                                        public void onFailure(Call<MascotaResponse> call, Throwable t) {

                                        }
                                    });

                                }else{
                                    Toast.makeText(activity, "Quitaste el like a " + mascota.getNombreCompleto(), Toast.LENGTH_SHORT).show();
                                    mascota.setTeGustaLaFoto(false);
                                    mascota.setLikes(mascota.getLikes() - 1);
                                    mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));
                                    mascotaViewHolder.ivBone.setImageResource(R.drawable.hueso2);
                                    RestApiAdapter restApiAdapter = new RestApiAdapter();
                                    EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram2();

                                    Call<MascotaResponse> mascotaResponseCall = endPointApi.quitarLike(mascotaFotoResponse.getMediaId());

                                    mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
                                        @Override
                                        public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                                            MascotaResponse mascotaResponse = response.body();
                                            Log.d("QUITASTE EL LIKE A ", mascota.getNombreCompleto());
                                        }

                                        @Override
                                        public void onFailure(Call<MascotaResponse> call, Throwable t) {

                                        }
                                    });
                                }

                            }

                            @Override
                            public void onFailure(Call<MascotaFotoResponse> call, Throwable t) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<MascotaFotoResponse> call, Throwable t) {

                    }
                });


            }
        });



        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////


        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("url", mascota.getUrlFoto());
                intent.putExtra("like",mascota.getLikes());
                activity.startActivity(intent);

            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////

       /* mascotaViewHolder.ibHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                int c = constructorMascotas.obtenerLikesMascota(mascota);
                mascotaViewHolder.tvNumMeGustas.setText(String.valueOf(c) + " Likes");

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////

                constructorMascotas.insertarMascotaFavo( mascota);

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                // mascotaViewHolder.ibHuesoBlanco.setImageResource(R.drawable.huesoamarillo);
                // mascotaViewHolder.tvNumMeGustas.setText(Integer.toString(mascota.getNumMegustas() + 1));

            }
        });*/


    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();

    }




    public static  class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageView ivBone;///////////////////////////////////////////////////////////////////////////
        //private TextView tvNombreCV;
        private TextView tvLikes;

        //private ImageButton ibHuesoBlanco;

        //Este constructor se ha puesto automaticamente, poniendome
        //alado de RecyclerView.ViewHolder cuando me salia la linea entera en rojo
        //apretando Alt+enter y me a sugerido el constructor


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            //tvNombreCV = (TextView)itemView.findViewById(R.id.tvNombreCV);
            ivBone = (ImageView)itemView.findViewById(R.id.ivBone);//////////////////////////////////////////////
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

            //ibHuesoBlanco = (ImageButton)itemView.findViewById(R.id.ibHuesoBlanco);

        }

    }


}
