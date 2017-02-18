package com.borjarnau.mismascotas.restApi.deserializador;

import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.restApi.JsonKeys;
import com.borjarnau.mismascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ArnAu on 18/10/2016.
 */
public class InfoMascotaDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarInfoMascotaDeJson(mascotaResponseData));


        return mascotaResponse;
    }
    private ArrayList<Mascota> deserializarInfoMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            String id = mascotaResponseDataObject.get(JsonKeys.USER_ID).getAsString();

            //String nombreCompleto = mascotaResponseDataObject.get(JsonKeys.USER_FULLNAME).getAsString();
            String username = mascotaResponseDataObject.get(JsonKeys.USER_NAME).getAsString();


            String urlFotoPerfil = mascotaResponseDataObject.get(JsonKeys.FOTO_PERFIL).getAsString();


            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombreCompleto(username);
            mascotaActual.setUrlFoto(urlFotoPerfil);
            mascotaActual.setLikes(0);

            //mascotas.add(mascotaActual);
            mascotas.add(0,mascotaActual); /////////////////////



            //Intent t = new Intent();

            //t.putExtra(EndPointApi.idUsuario, id);

        }
        return  mascotas;
    }
}
