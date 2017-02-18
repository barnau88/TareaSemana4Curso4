package com.borjarnau.mismascotas.db;

/**
 * Created by ArnAu on 27/05/2016.
 */
public final class ConstantesBaseDatos {

    public static  final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1; //version de la base de datos


    public static  final String TABLE_MASCOTAS          = "mascota";
    public static  final String TABLE_MASCOTAS_ID       = "id";
    public static  final String TABLE_MASCOTAS_NOMBRE   = "nombre";
    public static  final String TABLE_MASCOTAS_FOTO     = "foto";



    public static final String TABLE_LIKES_MASCOTA              = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID           = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA   = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes";

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static  final String TABLE_FAVO_MASCOTA           = "mascota_favo";
    public static  final String TABLE_FAVO_MASCOTAS_ID       = "id";
    public static  final String TABLE_FAVO_MASCOTAS_NOMBRE   = "nombre";
    public static  final String TABLE_FAVO_MASCOTAS_FOTO     = "foto";


    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////

}
