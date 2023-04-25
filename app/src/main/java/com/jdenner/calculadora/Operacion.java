package com.jdenner.calculadora;

public enum Operacion {

    SUMA(" + "),
    RESTA(" - "),
    MULTIPLICACION(" × "),
    DIVISION(" ÷ "),
    PORC(" % ");

    private String texto = "";

    private Operacion(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return this.texto;
    }
}
