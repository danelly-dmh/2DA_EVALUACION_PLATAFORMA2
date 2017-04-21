package com.example.danelly.eva2_1_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.view.MenuItem;

import org.w3c.dom.Text;


/**
 * Created by Danelly on 08/03/2017.
 * written by: Danelly Montañez Hernández
 * Instituto Tecnológico de Chihuahua II-13550406
 * DESARROLLO DE APLICACIONES PARA DISPOSITIVOS MÓVILES PLATAFORMA II
 */


public class Principal extends AppCompatActivity {
	//Declaramos la base de datos y el TextView para enlazarse al código
    SQLiteDatabase sqlCConnect;
    TextView txtDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtDatos = (TextView)findViewById(R.id.txtDatos);
        //Establecer la conexion
        sqlCConnect = openOrCreateDatabase("mibasededatos", MODE_PRIVATE, null);
        //si no existe lo crea, si existe lo abre
        try {
            sqlCConnect.execSQL("create table tblDatos(regID INTEGER PRIMARY KEY autoincrement, nombre text, apellido text);");
        //es una instruccion sql que pediremos que se ejecute
        }catch (SQLiteException e){
            e.printStackTrace();
        }
		//Realizamos los querys para crear nuestra tabla dentro de la base de datos
        sqlCConnect.execSQL("insert into tblDatos(nombre, apellido) values('DANELLY', 'MONTANEZ');");
        sqlCConnect.execSQL("insert into tblDatos(nombre, apellido) values('DIEGO', 'SALCIDO');");
        sqlCConnect.execSQL("insert into tblDatos(nombre, apellido) values('JIMENA', 'PARRA');");
        sqlCConnect.execSQL("insert into tblDatos(nombre, apellido) values('LUIS', 'TORRES');");
		//Los resultados de la consulta los vamos a obtener como cursor 
        Cursor cl = sqlCConnect.rawQuery("select * from tblDatos", null);
		//para recorrerlo y poder trabajar los registros
        cl.moveToFirst();
        while (!cl.isAfterLast()){
			// en el caso de que no conozca el numero de la columna, se puede indicar con nombre
            txtDatos.append(cl.getInt(cl.getColumnIndex("regID")) + " - ");
            txtDatos.append(cl.getString(cl.getColumnIndex("nombre")) + " - ");
            txtDatos.append(cl.getString(cl.getColumnIndex("apellido")) + " - ");cl.moveToNext();
            /*
            txtDatos.append(c1.getInt(0) + " - ");//para no borrar lo previo, solo ir agregando nuevos datos
            txtDatos.append(c1.getString(1) + " - ");
            txtDatos.append(c1.getString(2) + " - ");
            */
        }
    }
}
