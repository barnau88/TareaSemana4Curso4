package com.borjarnau.mismascotas.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.adapter.MiMascotaAdaptador;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.presentador.IRecyclerViewFragmentPresenter;
import com.borjarnau.mismascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by ArnAu on 20/10/2016.
 */
public class RecyclerViewFragmentViewII   extends Fragment { //implements IRecyclerViewFragmentViewII

    private RecyclerView rvMascotasGrid;

    private IRecyclerViewFragmentPresenter presenter;

    private TextView tvUserName;

    public static ImageView imgFotoMiMascota;

    //public static boolean esPako = false;
    public static int quienEs = 0;

    public static String nuevoPnombre;





    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil_user, container, false);

        imgFotoMiMascota = (ImageView) v.findViewById(R.id.imgFotoMiMascota);

        //String nuevoPnombre = EndPointApi.nombreUsuario;


        tvUserName = (TextView) v.findViewById(R.id.tvUserName);

        tvUserName.setText(nuevoPnombre);


        rvMascotasGrid= (RecyclerView) v.findViewById(R.id.rvMascotasGrid);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }






    //@Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasGrid.setLayoutManager(llm);

    }

    //@Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMascotasGrid.setLayoutManager(gridLayoutManager);

    }



    //@Override
    public MiMascotaAdaptador crearAdaptadorMiMascota(ArrayList<Mascota> mascotas) {
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(mascotas, getActivity());

        return adaptador;
    }




    //@Override
    public void inicializarAdaptadorMiMascotaRV(MiMascotaAdaptador adaptador) {

        rvMascotasGrid.setAdapter(adaptador);
    }



    public static int getQuienEs() {
        return quienEs;
    }

    public static void setQuienEs(int quienEs) {
        RecyclerViewFragmentViewII.quienEs = quienEs;
    }


    public static String getNuevoPnombre() {
        return nuevoPnombre;
    }

    public static void setNuevoPnombre(String nuevoPnombre) {
        RecyclerViewFragmentViewII.nuevoPnombre = nuevoPnombre;
    }
}


