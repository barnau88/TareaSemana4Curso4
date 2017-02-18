package com.borjarnau.mismascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class MascotaAdaptadorFavo extends RecyclerView.Adapter<MascotaAdaptadorFavo.MascotaFavoViewHolder>{


    ArrayList<Mascota> mascotasFavo;
    public MascotaAdaptadorFavo(ArrayList<Mascota>mascotasFavo){
        this.mascotasFavo = mascotasFavo;
    }



    //inflar o dar vida a el layout (cardview) y lo pasara al viewholder para el obtenga los views
    @Override
    public MascotaFavoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //aqui indicamos cual es el layout que estara reciclando el recycleview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_favorita,parent, false);
        return new MascotaFavoViewHolder(v);
    }

    //asocia cada elemento de nuestra lista con cada view
    @Override
    public void onBindViewHolder(final MascotaFavoViewHolder mascotaFavoViewHolder, int position) {
/*
        final Mascota mascota = mascotasFavo.get(position);
        mascotaFavoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaFavoViewHolder.tvNombreCV.setText(mascota.getNombre());
        //mascotaViewHolder.tvNumMeGustas.setInputType(mascota.getNumMegustas());
        mascotaFavoViewHolder.tvNumMeGustas.setText(Integer.toString(mascota.getNumMegustas() + 1));
/*
        mascotaFavoViewHolder.ibHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mascotaFavoViewHolder.ibHuesoBlanco.setImageResource(R.drawable.huesoamarillo);
                mascotaFavoViewHolder.tvNumMeGustas.setText(Integer.toString(mascota.getNumMegustas()+ 1));


            }
        });

        */

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotasFavo.size();
    }








    public static  class MascotaFavoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvNumMeGustas;

        //private ImageButton ibHuesoBlanco;

        //Este constructor se ha puesto automaticamente, poniendome
        //alado de RecyclerView.ViewHolder cuando me salia la linea entera en rojo
        //apretando Alt+enter y me a sugerido el constructor


        public MascotaFavoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvNumMeGustas = (TextView) itemView.findViewById(R.id.tvNumMeGustas);

            //ibHuesoBlanco = (ImageButton)itemView.findViewById(R.id.ibHuesoBlanco);

        }

    }
}
