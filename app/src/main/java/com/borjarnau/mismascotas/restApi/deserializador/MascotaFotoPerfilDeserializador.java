package com.borjarnau.mismascotas.restApi.deserializador;

import com.borjarnau.mismascotas.restApi.JsonKeys;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoPerfilResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by ArnAu on 09/11/2016.
 */
public class  MascotaFotoPerfilDeserializador implements JsonDeserializer<MascotaFotoPerfilResponse> {

    @Override
    public MascotaFotoPerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaFotoPerfilResponse mascotaFotoPerfilResponse = gson.fromJson(json, MascotaFotoPerfilResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaFotoPerfilResponse.setUrlFotoPerfil(deserializarMascotaDeJson(mascotaResponseData));



        return mascotaFotoPerfilResponse;
    }


    private String deserializarMascotaDeJson(JsonArray mascotaResponseData){


            JsonObject mascotaResponseDataObject = mascotaResponseData.get(0).getAsJsonObject();
            JsonObject userJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String fotoPerfil = userJson.get(JsonKeys.FOTO_PERFIL).getAsString();

            //MascotaFotoPerfilResponse mascotaFotoPerfilResponse = new MascotaFotoPerfilResponse();
           //mascotaFotoPerfilResponse.setUrlFotoPerfil(fotoPerfil);

        return fotoPerfil;
    }



}
