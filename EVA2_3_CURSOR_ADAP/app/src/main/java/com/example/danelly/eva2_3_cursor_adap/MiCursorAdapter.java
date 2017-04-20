package com.example.danelly.eva2_3_cursor_adap;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Danelly on 14/03/2017.
 */

public class MiCursorAdapter extends CursorAdapter {
    public MiCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.mis_datos, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtVwNom, txtVwApe;
        txtVwNom= (TextView)view.findViewById(R.id.txtVwNom);
        txtVwApe= (TextView)view.findViewById(R.id.txtVwApe);
        //enlazamos los datos del cursora los text view
        String sNom= cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String sApe= cursor.getString(cursor.getColumnIndexOrThrow("apellido"));
        //asignamos todo el texto a los txtView
        txtVwNom.setText(sNom);
        txtVwApe.setText(sApe);

    }
}
