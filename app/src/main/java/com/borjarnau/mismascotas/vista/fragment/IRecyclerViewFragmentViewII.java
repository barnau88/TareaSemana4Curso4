package com.borjarnau.mismascotas.vista.fragment;

import com.borjarnau.mismascotas.adapter.MiMascotaAdaptador;
import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 20/10/2016.
 */
public interface IRecyclerViewFragmentViewII {


    public void generarLinearLayoutVertical();
    public void generarGridLayout();



    public MiMascotaAdaptador crearAdaptadorMiMascota(ArrayList<Mascota> mascotas);


    public void inicializarAdaptadorMiMascotaRV (MiMascotaAdaptador adaptador);
}
