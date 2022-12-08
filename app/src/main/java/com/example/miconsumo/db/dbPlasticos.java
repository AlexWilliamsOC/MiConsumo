package com.example.miconsumo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbPlasticos extends DbHelper{

    Context context;

    public dbPlasticos(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertarPlastico(String nombre, String descripcion, String usuario, String origen, String ubicacion, String categoria, String fotografia){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("descripcion", descripcion);
            values.put("usuario", usuario);
            values.put("origen", origen);
            values.put("ubicacion", ubicacion);
            values.put("categoria", categoria);
            values.put("fotografia", fotografia);

            id = db.insert(TABLE_PLASTICOS, null, values);
        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }
}
