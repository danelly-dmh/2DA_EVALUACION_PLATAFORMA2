package com.example.danelly.eva2_3_cursor_adap;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    SQLiteDatabase sqlCConnect;
    ListView listV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Establecer la conexion
        sqlCConnect = openOrCreateDatabase("mibasededatos", MODE_PRIVATE, null);
        listV = (ListView)findViewById(R.id.listV);
        //si no existe lo crea, si existe lo abre
        try {
            sqlCConnect.execSQL("create table tblDatos(regID INTEGER PRIMARY KEY autoincrement, nombre text, apellido text);");
            //es una instruccion sql que pediremos que se ejecute
        }catch (SQLiteException E){
            E.printStackTrace();
        }
    Cursor cursor = sqlCConnect.rawQuery("select rowID as _id,nombre,apellido from tblDatos", null);
        listV.setAdapter(new MiCursorAdapter(this, cursor,0));//despues de correr el programa
        /*
        ContentValues cvDatos = new ContentValues();
        cvDatos.put("nombre","danelly");
        cvDatos.put("apellido","mont");
        sqlCConnect.insert("tblDatos",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","jesus");
        cvDatos.put("apellido","ruiz");
        sqlCConnect.insert("tblDatos",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","gisela");
        cvDatos.put("apellido","rodriguez");
        sqlCConnect.insert("tblDatos",null,cvDatos);
        cvDatos.put("nombre","mariana");
        cvDatos.put("apellido","montes");
        sqlCConnect.insert("tblDatos",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","jose");
        cvDatos.put("apellido","rodriguez");
        sqlCConnect.insert("tblDatos",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","azul");
        cvDatos.put("apellido","granados");
        sqlCConnect.insert("tblDatos",null,cvDatos);
        long iVal = sqlCConnect.insert("tblDatos",null,cvDatos);
        Toast.makeText(this, "" + iVal, Toast.LENGTH_SHORT).show();
        //para mostrar que se insertaron los registros, si muestra un numero
        //diferente de -1, losdatos se ingresaron correctamente
        */
    }
}
