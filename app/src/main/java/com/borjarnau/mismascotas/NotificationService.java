package com.borjarnau.mismascotas;

import android.app.Fragment;
//import android.app.NotificationManager;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.borjarnau.mismascotas.activities_menus.MenuAcercaDeActivity;
import com.borjarnau.mismascotas.adapter.MascotaAdaptador;
import com.borjarnau.mismascotas.presentador.RecyclerViewFragmentPresenter;
import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentViewII;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.view.Gravity;


/**
 * Created by ArnAu on 23/12/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    private static final String TAG = "FIREBASE";
    public static String id_user = "4192443066";
    public static final int NOTIFICATION_ID = 001;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (id_user.equals("4230859422")){
            PerfilUsuarioReiteado.quienEs = 1;
            PerfilUsuarioReiteado.nuevoPnombre = "niko_pty";
        }else if(id_user.equals("4192443066")){
            PerfilUsuarioReiteado.quienEs = 2;
            PerfilUsuarioReiteado.nuevoPnombre = "gatoulises";
        }



        //Intent i = new Intent(this, MainActivity.class);  //MainActivity.class   RecyclerViewFragmentViewII.class
    //    Intent intent = new Intent ();
    //    intent.setAction("VER_MI_PERFIL");
        //intent.setAction("FOLLOW_UNFOLLOW");
        //intent.setAction("VER_USUARIO");
        //PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);
    //    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);



        Intent intent= new Intent (this, PerfilUsuarioReiteado.class);  //MenuAcercaDeActivity  PerfilUsuarioReiteado
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);



        Intent i = new Intent ();
        i.setAction("FOLLOW_UNFOLLOW");
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        /*Intent kk= new Intent ();
        kk.setAction("VER_USUARIO");

        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(this, 0, kk, PendingIntent.FLAG_UPDATE_CURRENT);
        */

        Intent kk= new Intent (this, TimelinePerritopaco.class);  //MenuAcercaDeActivity
        //kk.setAction("VER_USUARIO");
        PendingIntent pendingIntent3 = PendingIntent.getActivity(this, 0, kk, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action action1 =
                new NotificationCompat.Action.Builder(R.drawable.ic_full_myuser,
                        getString(R.string.texto_accion_mi_perfil), pendingIntent)
                        .build();

        NotificationCompat.Action action2 =
                new NotificationCompat.Action.Builder(R.drawable.ic_full_foot,
                        getString(R.string.texto_accion_follow), pendingIntent2)
                        .build();

        NotificationCompat.Action action3 =
                new NotificationCompat.Action.Builder(R.drawable.ic_full_otheruser,
                        getString(R.string.texto_accion_ver_usuario), pendingIntent3)
                        .build();


        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintHideIcon(true)
                        .setBackground(BitmapFactory.decodeResource(getResources(), R.drawable.bk_androidwear_notification))
                        .setGravity(Gravity.CENTER_VERTICAL)     //para subir la notificacion
                ;

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notificaciones)
                .setContentTitle("Petagram imforma: ")    //Notificación
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setContentIntent(pendingIntent2)
                .setContentIntent(pendingIntent3)
                .setAutoCancel(true)
                .extend(wearableExtender.addAction(action1))
                .extend(wearableExtender.addAction(action2))
                .extend(wearableExtender.addAction(action3))
                ;

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, notificacion.build());



    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}

