package com.example.parcialprimercorte;

import static org.junit.Assert.*;

import org.junit.Test;

public class datosTest {

    @Test
    public void testDatos() {

        // Crear una instancia de la clase datos
        datos persona = new datos("ESTEBAN", "MEDELLIN");

        // Verificar los valores de los campos usando los métodos get
        assertEquals("ESTEBAN", persona.getNombre());
        assertEquals("MEDELLIN", persona.getCiudad());

        // Cambiar el valor del campo "ciudad" usando el método set
        persona.setCiudad("CARTAGENA");

        // Verificar el nuevo valor del campo "ciudad" usando el método get
        assertEquals("BOGOTA", persona.getCiudad());

    }
}