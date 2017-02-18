package com.borjarnau.mismascotas.restApi.model;

import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 15/10/2016.
 */
public class MascotaResponse {

    ArrayList<Mascota> mascotas;



    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
