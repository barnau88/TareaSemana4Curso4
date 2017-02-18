package com.borjarnau.mismascotas.restApi.deserializador;

import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.restApi.JsonKeys;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoResponse;
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
 * Created by ArnAu on 30/01/2017.
 */
public class MascotaFotoTuLikeDeserializador implements JsonDeserializer<MascotaFotoResponse> {

    String id_media;

    public MascotaFotoTuLikeDeserializador(String id_media){
        this.id_media = id_media;
    }

    @Override
    public MascotaFotoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaFotoResponse mascotaFotoResponse = gson.fromJson(json, MascotaFotoResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaFotoResponse.setYaTeGustaba(deserializarMascotaDeJson(mascotaResponseData));
        mascotaFotoResponse.setMediaId(id_media);

        return mascotaFotoResponse;
    }



    private boolean deserializarMascotaDeJson(JsonArray mascotaResponseData){
        boolean yaTeGustaba = false;
        for (int i = 0; i < mascotaResponseData.size(); i++) {

            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            String userName = mascotaResponseDataObject.get(JsonKeys.USER_NAME).getAsString();




            if(userName.equals("perritopaco")){
                yaTeGustaba = true;
                i = mascotaResponseData.size();
            }else{
                yaTeGustaba = false;
            }


        }

        return yaTeGustaba;
    }


}
