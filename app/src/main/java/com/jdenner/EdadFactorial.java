package com.example.parcialprimercorte;

import java.io.Serializable;

public class EdadFactorial implements Serializable {

    public static String factorial(int n, int acumulador){
        if (n == 0 || n == 1) {

            return ""+acumulador;

        } else {

            return factorial(n - 1, n * acumulador);
        }
    }


}
