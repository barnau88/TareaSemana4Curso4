package com.borjarnau.mismascotas.restApi.deserializador;

import com.borjarnau.mismascotas.pojo.Mascota;
import com.borjarnau.mismascotas.restApi.JsonKeys;
import com.borjarnau.mismascotas.restApi.model.MascotaFotoResponse;
import com.borjarnau.mismascotas.restApi.model.UsuarioFollowedResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by ArnAu on 18/02/2017.
 */
public class UsuarioFolloewDeserializador implements JsonDeserializer<UsuarioFollowedResponse> {


    String id_user;

    public UsuarioFolloewDeserializador(String id_user){
        this.id_user = id_user;
    }

    @Override
    public UsuarioFollowedResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UsuarioFollowedResponse usuarioFollowedResponse = gson.fromJson(json, UsuarioFollowedResponse.class);


        JsonArray usuarioFollowedResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        usuarioFollowedResponse.setYaLeSeguias(deserializarUsuaDeJson(usuarioFollowedResponseData));

        return usuarioFollowedResponse;
    }



    private boolean deserializarUsuaDeJson(JsonArray usuarioFollowedResponseData){

        boolean leSigues = false;

        for (int i = 0; i < usuarioFollowedResponseData.size(); i++) {
            JsonObject usuarioResponseDataObject = usuarioFollowedResponseData.get(i).getAsJsonObject();

            String id = usuarioResponseDataObject.get(JsonKeys.USER_ID).getAsString();



            if (id.equals(id_user)){
                leSigues = true;
                i = usuarioFollowedResponseData.size();
            }



        }

        return leSigues;

    }

}
