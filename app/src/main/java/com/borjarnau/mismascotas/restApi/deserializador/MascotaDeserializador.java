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
 * Created by ArnAu on 17/10/2016.
 */
public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {



        @Override
        public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson gson = new Gson();
            MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
            JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

            mascotaResponse.setMascotas(deserializarMascotaDeJson(mascotaResponseData));

            return mascotaResponse;
        }



        private ArrayList<Mascota> deserializarMascotaDeJson(JsonArray mascotaResponseData){
            ArrayList<Mascota> mascotas = new ArrayList<>();
            for (int i = 0; i < mascotaResponseData.size(); i++) {
                JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
                JsonObject userJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
                String id = userJson.get(JsonKeys.USER_ID).getAsString();
                String nombreCompleto = userJson.get(JsonKeys.USER_FULLNAME).getAsString();
                String fotoPerfil = userJson.get(JsonKeys.FOTO_PERFIL).getAsString();

                JsonObject imageJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
                JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
                String urlFoto = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

                JsonObject likesJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
                int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(id);
                mascotaActual.setNombreCompleto(nombreCompleto);
                mascotaActual.setUrlFoto(urlFoto);
                mascotaActual.setLikes(likes);
                mascotaActual.setUrlFotoPerfil(fotoPerfil);
                mascotaActual.setNumeroDeLaFoto(i);



                mascotas.add(mascotaActual);

            }

            return  mascotas;
        }




    }


