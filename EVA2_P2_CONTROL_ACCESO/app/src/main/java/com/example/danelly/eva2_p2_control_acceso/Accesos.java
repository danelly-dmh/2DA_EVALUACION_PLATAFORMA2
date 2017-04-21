package com.example.danelly.eva2_p2_control_acceso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
	control de acceso
	Created by Danelly on 08/03/2017.
	written by: Danelly Montañez Hernández
	Instituto Tecnológico de Chihuahua II-13550406
	DESARROLLO DE APLICACIONES PARA DISPOSITIVOS MÓVILES PLATAFORMA II
	*/
public class Accesos extends AppCompatActivity {
    EditText user, password;
    Button aceptar,cancelar;
    SQLiteDatabase db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceso);
        user =(EditText) findViewById(R.id.editUsuario);
        password= (EditText) findViewById(R.id.editContra);
        aceptar = (Button) findViewById(R.id.btnOk);
        cancelar = (Button) findViewById(R.id.btnCancel);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eUsuario = user.getText().toString();
                String ePassword = password.getText().toString();
                if(login(eUsuario, ePassword))
                    if (id != 0) {
                            Intent i = new Intent(Accesos.this, Inicio.class);
                        i.putExtra("id", id);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "Accediste", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accesos.this, Principal.class);
                startActivity(intent);
            }
        });
    }
    public boolean login(String usuario, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? and password = ?", new String[]{usuario, password});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            id = cursor.getInt(0);
            Log.i("id", ""+id);
            Log.i("usuario", cursor.getString(3));
            Log.i("usuario", cursor.getString(4));
            return true;
        }else
        return false;
    }
}
