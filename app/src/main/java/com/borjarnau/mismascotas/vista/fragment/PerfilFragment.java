package com.borjarnau.mismascotas.vista.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.adapter.MiMascotaAdaptador;
import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 17/10/2016.
 */
public class PerfilFragment extends Fragment {    //NO ESTA BIEN; PERO NO LOE ESTOY UTILIZANDO

    private ArrayList<Mascota> mascotas;
    //private RecyclerViewFragmentViewII listaMascotas;
    private RecyclerViewFragmentViewII bbb;
    private RecyclerView listaMascotas;


    public PerfilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil_user, container, false);

        //listaMascotas = (RecyclerViewFragmentViewII)v.findViewById(R.id.rvMascotasGrid);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotasGrid);
        //listaMascotas = bbb.obtenerRecyclerView();

        //listaMascotas.generarGridLayout();
        bbb.generarGridLayout();
        inicializarListaMiMascotas();
        inicializarAdaptador();
        return  v;

    }
    public MiMascotaAdaptador  adaptador;
    public void inicializarAdaptador(){

        //listaMascotas.inicializarAdaptadorMiMascotaRV(adaptador);
        bbb.inicializarAdaptadorMiMascotaRV(adaptador);

    }

    public void inicializarListaMiMascotas(){

       // adaptador = new MiMascotaAdaptador(mascotas,getActivity());
        //listaMascotas.crearAdaptadorMiMascota(mascotas);
        bbb.crearAdaptadorMiMascota(mascotas);

    }





}

 /*   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil_user, container, false);

        //listaMascotas = (RecyclerViewFragmentViewII)v.findViewById(R.id.rvMascotasPerfilUser);

        listaMascotas = bbb.obtenerRecyclerView();
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotasGrid);


        //listaMascotas.generarGridLayout();
        generarGrid();

        

        MiMascotaAdaptador adaptador = inicializarListaMiMascotas();
        inicializarAdaptador(adaptador);

        return  v;
    }


    //public MiMascotaAdaptador  adaptador;
    public void inicializarAdaptador(MiMascotaAdaptador adaptador){

        //listaMascotas.inicializarAdaptadorMiMascotaRV(adaptador);
        listaMascotas.setAdapter(adaptador);
    }

    public MiMascotaAdaptador inicializarListaMiMascotas(){

        //adaptador = new MiMascotaAdaptador(mascotas,getActivity());
        //listaMascotas.crearAdaptadorMiMascota(mascotas);
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(mascotas, getActivity()  );
        return adaptador;
    }

    public void generarGrid(){

        //adaptador = new MiMascotaAdaptador(mascotas,getActivity());
        //listaMascotas.crearAdaptadorMiMascota(mascotas);
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(mascotas, getActivity()  );
    }




}

*/
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotasGrid);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);

        listaMascotas.setLayoutManager(glm);

        //listaMascotas.setLayoutManager(llm);

        inicializarListaMiMascotas();
        inicializarAdaptador();

        return  v;
    }


    public MiMascotaAdaptador  adaptador;
    public void inicializarAdaptador(){

        adaptador = new MiMascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);

    }


    public void inicializarListaMiMascotas(){

        mascotas = new ArrayList<Mascota>();
/*
        mascotas.add(new Mascota(R.drawable.bird1, "Nino", 14));
        mascotas.add(new Mascota(R.drawable.bird2, "Nino", 110));
        mascotas.add(new Mascota(R.drawable.bird3, "Nino", 36));
        mascotas.add(new Mascota(R.drawable.bird4, "Nino", 12));
        mascotas.add(new Mascota(R.drawable.bird5, "Nino", 18));
        mascotas.add(new Mascota(R.drawable.bird6, "Nino", 29));
        mascotas.add(new Mascota(R.drawable.bird7, "Nino", 40));
        mascotas.add(new Mascota(R.drawable.bird8, "Nino", 140));

*/
/*

    }




}
*/