package com.borjarnau.mismascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.borjarnau.mismascotas.R;
import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class ConstructorMascotas {//interactua con los metodos de la base de datos

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarSeisMascotas(db);
        return db.obtenerTodasLasMascotas();
    }


    public void insertarSeisMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Dady" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro2 );

        db.insertarMAscota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Dudú" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro3);

        db.insertarMAscota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Caly" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro4);

        db.insertarMAscota(contentValues);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Carola" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro5);

        db.insertarMAscota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Mulero" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro6);

        db.insertarMAscota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Truncate" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro7);

        db.insertarMAscota(contentValues);


    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota( mascota);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Mascota> obtenerDatosFavo(){

        BaseDatos db = new BaseDatos(context);

        return db.obtenerTodasLasMascotasFavo();
    }




    public void insertarMascotaFavo( Mascota mascota){
/*
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, mascota.getFoto());

        db.insertarMascotaFavo(contentValues);

        db.eliminarMascotaFavorito(obtenerDatosFavo().get(0).getId());
*/
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////



}

