package com.example.parcialprimercorte;

import static org.junit.Assert.*;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BdcrudTest extends Bdcrud {

    private Bdcrud bdcrud;
    private Context context;
    private SQLiteDatabase db;

    public BdcrudTest(@Nullable Context context) {
        super(context);
    }

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        bdcrud = new Bdcrud(context);
        db = bdcrud.getWritableDatabase();
    }

    @After
    public void tearDown() throws Exception {
        db.close();
    }

    @Test
    public void insertardato() {
        String nombre = "Juan";
        String ciudad = "Barcelona";
        String edad = "25";

        long id = bdcrud.insertardato(nombre, ciudad, edad);
        assertTrue(id > 0);

        // Verificar si el registro se ha insertado correctamente
        String[] projection = {"nombre", "ciudad", "edad"};
        String selection = "nombre = ?";
        String[] selectionArgs = {nombre};
        Cursor cursor = db.query(TABLE_ESTUDIANTE, projection, selection, selectionArgs, null, null, null);

        assertTrue(cursor.moveToFirst());
        assertEquals(ciudad, cursor.getString(cursor.getColumnIndex("ciudad")));
        assertEquals(edad, cursor.getString(cursor.getColumnIndex("edad")));
        cursor.close();
    }
}