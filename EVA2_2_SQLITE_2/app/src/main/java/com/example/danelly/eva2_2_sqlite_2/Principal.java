package com.example.danelly.eva2_2_sqlite_2;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

	/**
	sqlite_2
	Created by Danelly on 08/03/2017.
	written by: Danelly Montañez Hernández
	Instituto Tecnológico de Chihuahua II-13550406
	DESARROLLO DE APLICACIONES PARA DISPOSITIVOS MÓVILES PLATAFORMA II
	*/
public class Principal extends AppCompatActivity {
	//Declaramos la base de datos
    EditText edtTxtNom, edtTxtApe, edTxtEdad;
    SQLiteDatabase miBD;    long iReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
		//enlazamos los EditText al código
        edtTxtNom = (EditText) findViewById(R.id.edTxtNom);
        edtTxtApe = (EditText) findViewById(R.id.edTxtApe);
        edTxtEdad = (EditText) findViewById(R.id.edTxtEdad);
		//Iniciamos la base de datos
        miBD = openOrCreateDatabase("mibasedatos", MODE_PRIVATE, null);
        try {
            miBD.execSQL("create table tblDatos(miId integer PRIMARY KEY autoincrement," +
                    "nombre text, apellido text, edad integer);");
        }catch (SQLiteException e){
            e.printStackTrace();
        }
    }
    //insertar un registro en la bd
    public void onClickIns(View v){
        String sNom = edtTxtNom.getText().toString();
        String sApe = edtTxtApe.getText().toString();
        int iEdad = Integer.parseInt(edTxtEdad.getText().toString());
        //contenedior de valores
        ContentValues cvVal = new ContentValues();
            //clave ---> columna, valor (tipo de dato primitivo)
        cvVal.put("nombre", sNom);
        cvVal.put("apellido", sApe);
        cvVal.put("edad", iEdad);
                        //tabla, campos nulos, mis valores
        iReg = miBD.insert("tblDatos", null, cvVal);
                                    //aqui podemos dar la opcion de guardar algun registro nulo
        Toast.makeText(this, "Registro: "+ iReg, Toast.LENGTH_SHORT).show();
    }
    //limpliar loscomponentes de la actividad
    public void onClickLimp(View v){
    }
    //aCTUALIZAR[]
    public void onClickActual(View v){
        String sNom = edtTxtNom.getText().toString();
        String sApe = edtTxtNom.getText().toString();
        int iEdad = Integer.parseInt(edtTxtNom.getText().toString());
        //contenedior de valores
        ContentValues cvVal = new ContentValues();
        //clave ---> columna, valor (tipo de dato primitivo)
        cvVal.put("nombre", sNom);
        cvVal.put("apellido", sApe);
        cvVal.put("edad", iEdad);
        //Actualizar los valores
        String sVal =""+iReg;
        String [] sArgs = {sVal};
        miBD.update("tblDatos", cvVal, "rowID= ?", sArgs);
        //miBD.update("tlbDatos", cvVal, "rowID = " + ireg,null);
    }
    public void onClickBorrar(View view){
        String sNom = edtTxtNom.getText().toString();
        String sApe = edtTxtNom.getText().toString();
        int iEdad = Integer.parseInt(edtTxtNom.getText().toString());
        //contenedior de valores
        ContentValues cvVal = new ContentValues();
        //clave ---> columna, valor (tipo de dato primitivo)
        cvVal.put("nombre", sNom);
        cvVal.put("apellido", sApe);
        cvVal.put("edad", iEdad);
        String sVal ="";
        String [] sArgs = {sVal};
        //eliminar
        miBD.update("tblDatos", cvVal, "rowID = ?", sArgs);
    }
    //agregar una segunda actividad que muestre el contenido de la tabla
    //presentar los datos
}
