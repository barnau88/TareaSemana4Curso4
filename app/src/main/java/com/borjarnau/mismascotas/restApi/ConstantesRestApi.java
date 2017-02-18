package com.borjarnau.mismascotas.restApi;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by ArnAu on 15/10/2016.
 */
public final class ConstantesRestApi extends AppCompatActivity {

    //https://api.instagram.com/v1/    //esto (DIRECCION BASE)lo configuraremos con otro parametro con retrofit

    //public static String nombreUsuario;
    //public static final String idUsuario  = "4039200993" ;
    public static final String ID_GATOULISES = "4192443066";

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;

    public static final String ROOT_URL_SERVIDOR = "https://damp-wildwood-91392.herokuapp.com/";
    public static final String KEY_POST_ID_DISPOSITIVO = "registrar-usuario/";

    public static final String KEY_POST_LIKE = "registrar-like/";

    public static final String KEY_DAME_ID_DISPOSITIVO_DE_USUARIO_DADO = "obtener-token-usuario-dado/{id_usuario_instagram}/";



    public static final String ACCESS_TOKEN = "4013497851.efd55de.740b5611a52d4b089b6303c3943cf405";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    /////////////////////////////////////////////////////////////////////////////////////////

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN


    public static final String KEY_GET_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_KEY_GET_RECENT_MEDIA_USER = KEY_GET_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //////////////////////////////////////////////////////////////////////////////////////////

    //SACAR INFO SOBRE LAS FOTOS
    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN

    public static final String WORD_USERS = "users/";
    public static final String ID_USER = "{user_id}";
   // public static final String USERS_ID = idUsuario;  /////////////////////////////////////////////////////////////4039200993
    public static final String KEY_GET_RECENT_MEDIA_USER_ID = "/media/recent/";
   // public static final String URL_GET_RECENT_MEDIA_USER_ID = WORD_USERS + USERS_ID + KEY_GET_RECENT_MEDIA_USER_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER_ID_PRIMERA_PARTE = WORD_USERS;
    public static final String URL_GET_RECENT_MEDIA_USER_ID_SEGUNDA_PARTE = KEY_GET_RECENT_MEDIA_USER_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    public static final String URL_GET_ID_MEDIA = WORD_USERS + ID_USER + KEY_GET_RECENT_MEDIA_USER_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    //////////////////////////////////////////////////////////////////////////////////////////////

    //https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN

    public static final String KEY_GET_INFO_USER_SEARCH = "users/search?q=";
    //public static final String NAME_USER = nombreUsuario;////////////////////////////////////////////////////////////////////atuaniv
    public static final String KEY_ACCESS_TOKEN_2 = "&access_token=";
    public static final String URL_GET_INFO_USER_SEARCH_PRIMERA_PARTE = KEY_GET_INFO_USER_SEARCH ;
    public static final String URL_GET_INFO_USER_SEARCH_SEGUNDA_PARTE = KEY_ACCESS_TOKEN_2 + ACCESS_TOKEN;
    //public static final String URL_GET_INFO_USER_SEARCH = KEY_GET_INFO_USER_SEARCH + NAME_USER + KEY_ACCESS_TOKEN_2 + ACCESS_TOKEN;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //PARA DAR O QUITAR LIKES
    //https://api.instagram.com/v1/media/{media-id}/likes?access_token=ACCESS-TOKEN
    //VERSION = "/v1/";
    //ROOT_URL = "https://api.instagram.com" + VERSION;

    //public static final String WORD_MEDIA = "media/";
   // public static final String WORD_LIKES = "/likes/";
    //public static final String KEY_MEDIA_ID = "{mediaId}";
   //public static final String URL_POST_AND_DELETE_LIKES_PRIMERA_PARTE = WORD_MEDIA;
    //public static final String URL_POST_AND_DELETE_LIKES_SEGUNDA_PARTE = WORD_LIKES + KEY_ACCESS_TOKEN + ACCESS_TOKEN;;
    //public static final String URL_POST_AND_DELETE_LIKES = URL_POST_AND_DELETE_LIKES_PRIMERA_PARTE + KEY_MEDIA_ID + URL_POST_AND_DELETE_LIKES_SEGUNDA_PARTE;


    public static final String KEY_LIKES_MEDIA_ID = "media/{mediaId}/likes";
    public static final String URL_GET_POST_AND_DELETE_LIKES = KEY_LIKES_MEDIA_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



    //https://api.instagram.com/v1/users/{user-id}/relationship?access_token=ACCESS-TOKEN
    public static final String WORD_RELATIONSHIP = "/relationship";
    public static final String KEY_FOLLOW_UNFOLLOW = WORD_USERS + ID_GATOULISES + WORD_RELATIONSHIP + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    //https://api.instagram.com/v1/users/self/followed-by?access_token=ACCESS-TOKEN
    public static final String KEY_USER_FOLLOW = "users/self/follows";
    public static final String KEY_GET_YA_LE_SEGUIA = KEY_USER_FOLLOW + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

}
