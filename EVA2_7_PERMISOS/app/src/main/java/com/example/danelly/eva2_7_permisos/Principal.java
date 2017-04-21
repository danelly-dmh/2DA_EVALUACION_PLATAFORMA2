package com.example.danelly.eva2_7_permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
	permisos
	Created by Danelly on 08/03/2017.
	written by: Danelly Montañez Hernández
	Instituto Tecnológico de Chihuahua II-13550406
	DESARROLLO DE APLICACIONES PARA DISPOSITIVOS MÓVILES PLATAFORMA II
	*/
public class Principal extends AppCompatActivity {
    final static int PERMIS=11;

    TextView txtV;
    String sRuta;//ruta a la tarjeta de memoria
    final static String Archivo = "/miarchivo.txt";//archivo a leer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    @Override
    protected void onPause() {
        super.onPause();
        EscribirArchivo();
    }
    @Override
    protected void onStart() {
        super.onStart();
        //if BUSCO SI TENGO PERMISOS != TIENES PERMISOS)
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){//no tenenmos permisos
                ActivityCompat.requestPermissions(this,new String[]
                        {Manifest.permission.READ_EXTERNAL_STORAGE}, PERMIS);
            }else{//SI TENEMOS PERMOSOS LEER EL ARCHIVO
            }
        }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMIS){
            Toast.makeText(this,permissions[0],Toast.LENGTH_LONG).show();
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                LeerArchivo();//EL USUARIO PERMITIÓ ACCESO A LA SD
                Toast.makeText(this,"ACCESO A LA SD",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"PERMISO DENEGADO", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void LeerArchivo(){
        try {
            FileInputStream isAbrir = new FileInputStream(sRuta + Archivo);
            InputStreamReader isrLeer=new InputStreamReader(isAbrir);
            BufferedReader brLeer =new BufferedReader(isrLeer);
            String scade;
            while ((scade= brLeer.readLine())!=null){
                txtV.append(scade);
                txtV.append("\n");
            }
            brLeer.close();
            isrLeer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void EscribirArchivo(){
        super.onPause();
        try {
            OutputStream osEscribir =new FileOutputStream(sRuta +Archivo);
            OutputStreamWriter oswEscribir =new OutputStreamWriter(osEscribir);
            oswEscribir.write("LECTURA Y ESCRITURA EN LA SD CARD");
            oswEscribir.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
