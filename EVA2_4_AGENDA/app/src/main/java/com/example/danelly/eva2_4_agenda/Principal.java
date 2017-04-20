package com.example.danelly.eva2_4_agenda;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    EditText txtNom, txtNum;
    SQLiteDatabase miBD;    long iReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtNom = (EditText) findViewById(R.id.editNom);
        txtNum = (EditText) findViewById(R.id.editNum);
        miBD = openOrCreateDatabase("mibasedatos", MODE_PRIVATE, null);
        try {
            miBD.execSQL("create table tblDatos(miId integer PRIMARY KEY autoincrement," +
                    "nombre text, telefono text);");
        }catch (SQLiteException E){
            E.printStackTrace();
        }
    }
    //insertar un registro en la bd
    public void onClickIns(View v){
        String sNombre = txtNom.getText().toString();
        String sNumero = txtNum.getText().toString();
        //contenedior de valores
        ContentValues cvVal = new ContentValues();
        //clave ---> columna, valor (tipo de dato primitivo)
        cvVal.put("nombre", sNombre);
        cvVal.put("telefono", sNumero);
        //tabla, campos nulos, mis valores
        iReg = miBD.insert("tblDatos", null, cvVal);
        //aqui podemos dar la opcion de guardar algun registro nulo
        Toast.makeText(this, "Registro: "+ iReg, Toast.LENGTH_SHORT).show();
}
    public void onClickActual(View v){
        String sNombre = txtNom.getText().toString();
        String sNumero = txtNum.getText().toString();
        //contenedior de valores
        ContentValues cvVal = new ContentValues();
        //clave ---> columna, valor (tipo de dato primitivo)
        cvVal.put("nombre", sNombre);
        cvVal.put("telefono", sNumero);
        String sVal =""+iReg;
        String [] sArgs = {sVal};
        miBD.update("tblDatos", cvVal, "rowID= ?", sArgs);
        //miBD.update("tlbDatos", cvVal, "rowID = " + ireg,null);
    }
    public void onClickBorrar(View view){
        String sNombre = txtNom.getText().toString();
        String sNumero = txtNum.getText().toString();
        String sVal = ""+iReg;
        String [] sArgs = {sVal};
        miBD.delete("tblDatos","rowID= ?",sArgs);
    }
    //agregar una segunda actividad que muestre el contenido de la tabla
    //presentar los datos
}