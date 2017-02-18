package com.borjarnau.mismascotas.presentador;

import android.content.Context;
import android.widget.Toast;

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.restApi.EndPointApi;
import com.borjarnau.mismascotas.restApi.adapter.RestApiAdapter;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoPerfilResponse;
import com.borjarnau.mismascotas.restApi.model.MascotaResponse;
import com.borjarnau.mismascotas.vista.fragment.IRecyclerViewFragmentView;
import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentViewII;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ArnAu on 14/10/2016.
 */
public class RecyclerViewFragmentPresenter  implements  IRecyclerViewFragmentPresenter { //extends AppCompatActivity


    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    //private IRecyclerViewFragmentViewII iRecyclerViewFragmentViewII;
    //private IRecyclerViewFragmentViewII iRecyclerViewFragmentViewII;
    private RecyclerViewFragmentViewII recyclerViewFragmentViewII;


    private Context context;

    private ArrayList<Mascota> mascotas;

    private   ArrayList<Mascota> mascotasUSer;

    public static Mascota x;
    public String urlPerfilFoto ;


   /* public static String id_dispositivo_perritopaco;
    public static String id_dispositivo_gatoulises;
    public static String id_dispositivo_niko_pty;
*/
    //public static boolean esPako = false;


    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;

        //obtenerMediosRecientes();
        obtenerMediosRecientesUsuarios();

    }


    public  RecyclerViewFragmentPresenter(RecyclerViewFragmentViewII recyclerViewFragmentViewII, Context context) {
        //this.iRecyclerViewFragmentViewII = iRecyclerViewFragmentViewII;
        this.recyclerViewFragmentViewII = recyclerViewFragmentViewII;
        this.context = context;

        //obtenerMediosRecientesUsuario();
        //Toast.makeText(context, mascotasUSer.get(0).getId(), Toast.LENGTH_LONG).show();
       /* if (RecyclerViewFragmentViewII.esPako == true){
            obtenerFotoPerfil();
            obtenerMediosRecientes();
        }
       */

        if(RecyclerViewFragmentViewII.quienEs == 1){
            obtenerFotoPerfil();
            obtenerMediosRecientes();
        }else if (RecyclerViewFragmentViewII.quienEs == 2){
            obtenerFotoPerfilNiko_pty();
            obtenerMediosRecientesNiko_pty();
        }else if (RecyclerViewFragmentViewII.quienEs == 3){
            obtenerFotoPerfilGatoulises();
            obtenerMediosRecientesGatoulises();
        }

        //Toast.makeText(context, urlPerfilFoto, Toast.LENGTH_LONG).show();

    }


  public void obtenerFotoPerfil() {
      RestApiAdapter restApiAdapter = new RestApiAdapter();
      Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorFotoPerrfil();
      EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

      Call<MascotaFotoPerfilResponse> mascotaFotoPerfilResponseCall = endPointApi.getFotoPerfilMiUsuario();

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
              Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

          }
      });

  }



           @Override
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
                mostrarMascotasUserRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }



    @Override
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
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }



    @Override
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
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });

    }


/*
    public void obtenerMediosRecientesUsuario() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMediaUSer();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotasUSer = mascotaResponse.getMascotas();

                mostrarMascotasUserRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();

            }
        });
    }
*/

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void obtenerMediosRecientesUsuarios() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);


        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMediaGatoulises();
        final Call<MascotaResponse> mascotaResponseCall1 = endPointApi.getRecentMediaNiko_pty();
        final Call<MascotaResponse> mascotaResponseCall2 = endPointApi.getRecentMedia();
        //final Call<MascotaResponse> mascotaResponseCall3 = endPointApi.getRecentMediaMascotasapp2016();
        //final Call<MascotaResponse> mascotaResponseCall4 = endPointApi.getRecentMediaMypetappcour();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotasUSer = mascotaResponse.getMascotas();

                mascotaResponseCall1.enqueue(new Callback<MascotaResponse>() {
                    @Override
                    public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                        MascotaResponse mascotaResponse = response.body();
                        mascotasUSer.addAll(mascotaResponse.getMascotas());

                        mascotaResponseCall2.enqueue(new Callback<MascotaResponse>() {
                            @Override
                            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                                MascotaResponse mascotaResponse = response.body();
                                mascotasUSer.addAll(mascotaResponse.getMascotas());


                                mostrarMascotasRV();
                                /*
                                mascotaResponseCall3.enqueue(new Callback<MascotaResponse>() {
                                    @Override
                                    public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                                        MascotaResponse mascotaResponse = response.body();
                                        mascotasUSer.addAll(mascotaResponse.getMascotas());

                                        mascotaResponseCall4.enqueue(new Callback<MascotaResponse>() {
                                            @Override
                                            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                                                MascotaResponse mascotaResponse = response.body();
                                                mascotasUSer.addAll(mascotaResponse.getMascotas());

                                                mostrarMascotasRV();

                                            }

                                            @Override
                                            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                                                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();
                                            }
                                        });


                                    }

                                    @Override
                                    public void onFailure(Call<MascotaResponse> call, Throwable t) {
                                        Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();
                                    }
                                });*/
                            }

                            @Override
                            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<MascotaResponse> call, Throwable t) {
                        Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();
                    }
                });
            }
            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexión", Toast.LENGTH_LONG).show();
            }
        });
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotasUSer));
        iRecyclerViewFragmentView.generarGridLayout();
    }

    public void mostrarMascotasUserRV() {
        recyclerViewFragmentViewII.inicializarAdaptadorMiMascotaRV(recyclerViewFragmentViewII.crearAdaptadorMiMascota(mascotas));
        recyclerViewFragmentViewII.generarGridLayout();
    }

    public void mostrarFotoPerfilUser(String x){
         Picasso.with(recyclerViewFragmentViewII.getContext())
                .load(x)
                .placeholder(R.drawable.perro1)
                .into(recyclerViewFragmentViewII.imgFotoMiMascota);

    }



}





