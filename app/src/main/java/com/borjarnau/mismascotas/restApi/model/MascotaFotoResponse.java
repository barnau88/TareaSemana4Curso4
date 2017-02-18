package com.borjarnau.mismascotas.restApi.model;

/**
 * Created by ArnAu on 25/01/2017.
 */
public class MascotaFotoResponse {

    String mediaId;
    boolean yaTeGustaba;

    //String id_usuario_instagram;
    //String id_dispositivo;

  /*  public MascotaFotoResponse(String mediaId, boolean yaTeGustaba){
        this.mediaId = mediaId;
        this.yaTeGustaba = yaTeGustaba;
    }

    public MascotaFotoResponse(String mediaId, String id_usuario_instagram, String id_dispositivo){
        this.mediaId = mediaId;
        this.id_usuario_instagram = id_usuario_instagram;
        this.id_dispositivo = id_dispositivo;
    }
    */

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public boolean isYaTeGustaba() {
        return yaTeGustaba;
    }

    public void setYaTeGustaba(boolean yaTeGustaba) {
        this.yaTeGustaba = yaTeGustaba;
    }

   /* public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }
    */
}
