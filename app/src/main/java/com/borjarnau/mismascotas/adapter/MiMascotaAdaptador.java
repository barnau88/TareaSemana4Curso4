package com.borjarnau.mismascotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjarnau.mismascotas.DetalleMascota;
import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class MiMascotaAdaptador extends  RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;



    public MiMascotaAdaptador(ArrayList<Mascota>mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //aqui indicamos cual es el layout que estara reciclando el recycleview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent, false);   ///cardview_mi_mascota
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaAdaptador.MiMascotaViewHolder miMascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        //////////mascotaViewHolder.imgFoto.setImageResource(mascota.getUrlFoto());
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.perro1)
                .into(miMascotaViewHolder.imgFoto);




        //mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        //mascotaViewHolder.tvNumMeGustas.setInputType(mascota.getNumMegustas());
        //mascotaViewHolder.tvNumMeGustas.setText(Integer.toString(mascota.getNumMegustas()));
        miMascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        miMascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("url", mascota.getUrlFoto());
                intent.putExtra("like",mascota.getLikes());
                activity.startActivity(intent);

            }
        });




/*
        final Mascota mascota = mascotas.get(position);
        miMascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());

        miMascotaViewHolder.tvNumMeGustas.setText(Integer.toString(mascota.getNumMegustas()));
*/
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public static  class MiMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;


        //Este constructor se ha puesto automaticamente, poniendome
        //alado de RecyclerView.ViewHolder cuando me salia la linea entera en rojo
        //apretando Alt+enter y me a sugerido el constructor


        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);

            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

        }

    }

}