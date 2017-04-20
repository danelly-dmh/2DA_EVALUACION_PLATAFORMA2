package com.example.danelly.eva2_p2_control_acceso;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btnAcceso, btnUsuarios;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnAcceso= (Button) findViewById(R.id.btnAcceso);
        btnUsuarios= (Button) findViewById(R.id.btnUsuarios);

        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Accesos.class);
                startActivityForResult(intent,0);
            }
        });
        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Usuarios.class);
                startActivityForResult(intent,0);
            }
        });
    }
}
