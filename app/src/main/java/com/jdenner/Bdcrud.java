package com.example.parcialprimercorte;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Bdcrud extends DBhelper{
    Context context;
    public Bdcrud(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertardato(String nombre , String ciudad ,String edad){

        long id =0;

        try {
            DBhelper database = new DBhelper(context);
            SQLiteDatabase db = database.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("ciudad", ciudad);
            values.put("edad", edad);

            id = db.insert(TABLE_ESTUDIANTE, null,values);
        } catch (Exception ex){
            ex.toString();
        }
        return id ;
    }
}
