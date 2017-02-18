package com.borjarnau.mismascotas.restApi.model;

/**
 * Created by ArnAu on 22/12/2016.
 */
public class UsuarioResponse {
    private String id_regristro;
    private String id_dispositivo;
    private String nombre_usuario_instagram;
    private String id_usuario_instagram ;

    public UsuarioResponse(String id_regristro, String id_dispositivo, String  nombre_usuario_instagram ,String id_usuario_instagram){
        this.id_dispositivo = id_dispositivo;
        this.id_regristro = id_regristro;
        this.nombre_usuario_instagram = nombre_usuario_instagram;
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public UsuarioResponse(){

    }

    public String getId_regristro() {
        return id_regristro;
    }

    public void setId_regristro(String id_regristro) {
        this.id_regristro = id_regristro;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public String getNombre_usuario_instagram() {
        return nombre_usuario_instagram;
    }

    public void setNombre_usuario_instagram(String nombre_usuario_instagram) {
        this.nombre_usuario_instagram = nombre_usuario_instagram;
    }
}
