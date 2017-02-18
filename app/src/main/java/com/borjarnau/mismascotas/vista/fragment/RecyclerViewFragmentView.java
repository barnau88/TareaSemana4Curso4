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

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.presentador.IRecyclerViewFragmentPresenter;
import com.borjarnau.mismascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by ArnAu on 14/10/2016.
 */
public class RecyclerViewFragmentView extends Fragment implements IRecyclerViewFragmentView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos) {
        MascotaAdaptador adaptador = new MascotaAdaptador(contactos, getActivity()  );
        return adaptador;
    }



    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }



}

