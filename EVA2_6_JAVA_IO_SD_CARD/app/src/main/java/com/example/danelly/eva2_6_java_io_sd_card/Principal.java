package com.example.danelly.eva2_6_java_io_sd_card;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

/**
	java_io_sd_card
	Created by Danelly on 08/03/2017.
	written by: Danelly Montañez Hernández
	Instituto Tecnológico de Chihuahua II-13550406
	DESARROLLO DE APLICACIONES PARA DISPOSITIVOS MÓVILES PLATAFORMA II
	*/

public class Principal extends AppCompatActivity {
    TextView txtV;
    String sRuta;//ruta a la tarjeta de memoria
    final static String Archivo = "/miarchivo.txt";//archivo a leer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtV = (TextView)findViewById(R.id.txtV);
        sRuta = Environment.getExternalStorageDirectory().getAbsolutePath();
        Toast.makeText(this,sRuta,Toast.LENGTH_LONG).show();
}
    @Override
    protected void onStart() {//leer
        super.onStart();
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
    @Override
    protected void onPause() {//escribir
        super.onPause();
        try {
            OutputStream osEscribir =new FileOutputStream(sRuta+Archivo);
            OutputStreamWriter oswEscribir =new OutputStreamWriter(osEscribir);
            oswEscribir.write("LECTURA Y ESCRITURA EN LA SD CARD");
            oswEscribir.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
