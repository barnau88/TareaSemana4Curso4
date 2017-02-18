package com.borjarnau.mismascotas.pojo;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class Mascota {

    private String urlFoto;
    private String nombreCompleto;
    private int likes = 0;

    /////////////////////////////////////////////////////////////////////////////////////////////
    private String id;
    ////////////////////////////////////////////////////////////////////////////////////////////

    private String urlFotoPerfil;
    private int numeroDeLaFoto;
    private boolean teGustaLaFoto = false;



    public Mascota(String urlFoto, String nombreCompleto, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;

    }


    public Mascota() {

    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }


    public int getNumeroDeLaFoto() {
        return numeroDeLaFoto;
    }

    public void setNumeroDeLaFoto(int numeroDeLaFoto) {
        this.numeroDeLaFoto = numeroDeLaFoto;
    }


    public boolean isTeGustaLaFoto() {
        return teGustaLaFoto;
    }

    public void setTeGustaLaFoto(boolean teGustaLaFoto) {
        this.teGustaLaFoto = teGustaLaFoto;
    }


}


