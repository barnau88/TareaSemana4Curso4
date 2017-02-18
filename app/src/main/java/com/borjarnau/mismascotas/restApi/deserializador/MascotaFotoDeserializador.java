package com.borjarnau.mismascotas.restApi.deserializador;

import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.restApi.JsonKeys;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoPerfilResponse;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by ArnAu on 26/01/2017.
 */
public class MascotaFotoDeserializador implements JsonDeserializer<MascotaFotoResponse> {

    int posicion;

    public MascotaFotoDeserializador(int position){
        this.posicion = position;
    }

    @Override
    public MascotaFotoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        int objetoEnELArray = this.posicion;
        MascotaFotoResponse mascotaFotoResponse = gson.fromJson(json, MascotaFotoResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaFotoResponse.setMediaId(deserializarFotoMascotaDeJson(mascotaResponseData, objetoEnELArray));



        return mascotaFotoResponse;
    }


    private String deserializarFotoMascotaDeJson(JsonArray mascotaResponseData, int i){


        JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
        //JsonObject userJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
        String mediaId = mascotaResponseDataObject.get(JsonKeys.ID_IMAGES).getAsString();

        //MascotaFotoPerfilResponse mascotaFotoPerfilResponse = new MascotaFotoPerfilResponse();
        //mascotaFotoPerfilResponse.setUrlFotoPerfil(fotoPerfil);

        return mediaId;
    }

}
