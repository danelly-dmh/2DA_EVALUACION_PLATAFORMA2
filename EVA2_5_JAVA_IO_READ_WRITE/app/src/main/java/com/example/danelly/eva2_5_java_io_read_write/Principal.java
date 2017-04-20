package com.example.danelly.eva2_5_java_io_read_write;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Principal extends AppCompatActivity {
    TextView txtVwMostar;
    final static String Archivo= "miarchivo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwMostar = (TextView)findViewById(R.id.txtVwMostrar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //abrimos el archivo

        try {
            //inputstream
            InputStream isOpen = openFileInput(Archivo);
            //inputstreamreader
            InputStreamReader isrLeerBytes = new InputStreamReader(isOpen);
            //bufferedreader
            BufferedReader brLeerT = new BufferedReader(isrLeerBytes);
            //leemoss
            String sCade;
            while ((sCade = brLeerT.readLine())!=null){
                txtVwMostar.append(sCade);
                txtVwMostar.append("\n");
                brLeerT.close();
                isrLeerBytes.close();//cerramos
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }

    @Override
    protected void onPause() {
        super.onPause();
        //escribir en el archivo
        try {
            OutputStream usEscribir = openFileOutput(Archivo,0);//el cero indica que si no existe se crea
            OutputStreamWriter oswEscribir = new OutputStreamWriter(usEscribir);
            oswEscribir.write("prueba de guardado!!!!!!!!!! :D");
            oswEscribir.close();//siempre cerrar el archivo
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
