package com.borjarnau.mismascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ArnAu on 14/10/2016.
 */
public class DetalleMascota extends AppCompatActivity {
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
    //private TextView tvNombre;
    //private TextView tvTelefono;
    //private TextView tvEmail;
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota_foto);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKES);


        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle= (ImageView)findViewById(R.id.imgFotoDetalle);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.perro1)
                .into(imgFotoDetalle);



    }
}