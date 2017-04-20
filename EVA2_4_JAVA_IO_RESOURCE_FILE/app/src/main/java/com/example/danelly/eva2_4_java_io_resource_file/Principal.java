package com.example.danelly.eva2_4_java_io_resource_file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Principal extends AppCompatActivity {
    TextView txtVwMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwMostrar =(TextView)findViewById(R.id.txtVwMostrar);
        // INPUTSTREAM --> ABRE EL RECURSO
        InputStream isOpen = getResources().openRawResource(R.raw.datos);
        // INPUT STREAM READER (INPUTSTREAM)
        InputStreamReader isrLeeBytes = new InputStreamReader(isOpen);
        //BUFFEREDREADER (INPUTSTREAMREADER)
        BufferedReader brLeerTxt = new BufferedReader(isrLeeBytes);
        //aqui leemos
        try {
            String sCade;
            while ((sCade = brLeerTxt.readLine())!= null){
                txtVwMostrar.append(sCade);
                txtVwMostrar.append("\n");
            }
            brLeerTxt.close();
            isrLeeBytes.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
