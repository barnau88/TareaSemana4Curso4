package com.borjarnau.mismascotas.vista.fragment;

import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 14/10/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV (MascotaAdaptador adaptador);


}
