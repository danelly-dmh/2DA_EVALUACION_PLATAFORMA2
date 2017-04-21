package com.example.danelly.eva2_p2_control_acceso;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
	control de acceso
	Created by Danelly on 08/03/2017.
	written by: Danelly Montañez Hernández
	Instituto Tecnológico de Chihuahua II-13550406
	DESARROLLO DE APLICACIONES PARA DISPOSITIVOS MÓVILES PLATAFORMA II
	*/

public class Usuarios extends AppCompatActivity {
    EditText usuario, contra;
    Button aceptar,cancelar;
    SQLiteDatabase  db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuarios);
        cancelar = (Button) findViewById(R.id.btnCancel);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Usuarios.this, Principal.class);
                startActivity(intent);
            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
