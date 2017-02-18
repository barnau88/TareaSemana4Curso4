package com.borjarnau.mismascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.borjarnau.mismascotas.adapter.MascotaAdaptadorFavo;
import com.borjarnau.mismascotas.db.ConstructorMascotas;
import com.borjarnau.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class Favoritas_Activity extends AppCompatActivity {



    ArrayList<Mascota> mascotasFavo;
    private RecyclerView listaMascotasFavo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);


        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listaMascotasFavo = (RecyclerView)findViewById(R.id.rvMascotasFavo);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFavo.setLayoutManager(llm);


        inicializarListaMascotasFavo();
        inicializarAdaptadorFavo();


    }

    public void inicializarAdaptadorFavo(){

        MascotaAdaptadorFavo adaptador = new MascotaAdaptadorFavo(mascotasFavo);
        listaMascotasFavo.setAdapter(adaptador);

    }




    public void inicializarListaMascotasFavo(){

        mascotasFavo = new ArrayList<Mascota>();

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(getBaseContext());
        mascotasFavo = constructorMascotas.obtenerDatosFavo();

       /* mascotasFavo.add(new Mascota(R.drawable.perro2, "Dady", 3));
        //mascotasFavo.add(new Mascota(R.drawable.perro3, "Dudú", 10));
        //mascotasFavo.add(new Mascota(R.drawable.perro4, "Caly", 6));
        mascotasFavo.add(new Mascota(R.drawable.perro5, "Carola", 2));
        mascotasFavo.add(new Mascota(R.drawable.perro6, "Mulero", 14));
        mascotasFavo.add(new Mascota(R.drawable.perro7, "Truncate", 22));
        mascotasFavo.add(new Mascota(R.drawable.perro8, "Nino", 4));*/


    }



/*
    public void atras(View v){

        onBackPressed();
    }

*/

}
