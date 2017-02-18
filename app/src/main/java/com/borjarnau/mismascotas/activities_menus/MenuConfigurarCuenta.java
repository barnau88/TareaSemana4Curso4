package com.borjarnau.mismascotas.activities_menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.borjarnau.mismascotas.MainActivity;
import com.borjarnau.mismascotas.R;

import com.borjarnau.mismascotas.vista.fragment.RecyclerViewFragmentViewII;

/**
 * Created by ArnAu on 18/10/2016.
 */
public class MenuConfigurarCuenta extends AppCompatActivity {

    private EditText etUsuario;

    public static  String nombreUsuarioNuevo;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_configurar_cuenta);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Button btGuardarUsuario = (Button)findViewById(R.id.etButtonGuardarUser);
        btGuardarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etUsuario = (EditText)findViewById(R.id.etUsuario);

                nombreUsuarioNuevo = etUsuario.getText().toString();


              /*  if(nombreUsuarioNuevo.equals("perritopaco")){
                    RecyclerViewFragmentViewII.esPako = true;
                    RecyclerViewFragmentViewII.nuevoPnombre = "perritopaco";

                }else{
                    Toast.makeText(getBaseContext(),nombreUsuarioNuevo + "  no es el usuario principal de la aplicación" , Toast.LENGTH_LONG).show();
                    RecyclerViewFragmentViewII.esPako = false;
                    RecyclerViewFragmentViewII.nuevoPnombre = "";
                }

              */

                if(nombreUsuarioNuevo.equals("perritopaco")){
                    RecyclerViewFragmentViewII.quienEs = 1;
                    RecyclerViewFragmentViewII.nuevoPnombre = nombreUsuarioNuevo;
                }else if (nombreUsuarioNuevo.equals("niko_pty")){
                    RecyclerViewFragmentViewII.quienEs = 2;
                    RecyclerViewFragmentViewII.nuevoPnombre = nombreUsuarioNuevo;
                }else if (nombreUsuarioNuevo.equals("gatoulises")){
                    RecyclerViewFragmentViewII.quienEs = 3;
                    RecyclerViewFragmentViewII.nuevoPnombre = nombreUsuarioNuevo;
                }else{
                    Toast.makeText(getBaseContext(),nombreUsuarioNuevo + "  no ha compartido su usuario sandbox con el desarrollador de la App" , Toast.LENGTH_LONG).show();
                    RecyclerViewFragmentViewII.quienEs = 0;
                    RecyclerViewFragmentViewII.nuevoPnombre = "";
                }



                Intent intent = new Intent(MenuConfigurarCuenta.this, MainActivity.class);


                startActivity(intent);
                onBackPressed();


            }
        });
    }
}


