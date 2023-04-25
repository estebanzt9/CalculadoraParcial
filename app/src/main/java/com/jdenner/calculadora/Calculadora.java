package com.jdenner.calculadora;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

public class Calculadora implements Serializable {


    private Operador operador1 = new Operador();
    private Operador operador2 = new Operador();
    private Operacion Operacion = null;
    private boolean finalizado = false;
    private NumberFormat nf = NumberFormat.getNumberInstance();

    public void setCaracter(char caracter) throws ParseException {
        if(finalizado) {
            operador1 = new Operador();
            operador2 = new Operador();
            Operacion = null;
            finalizado = false;
        }

        if (operacao == null) {
            operador1.setCaracter(caracter);
        } else if (!finalizado) {
            operador2.setCaracter(caracter);
        }
    }

    public void setOperacao(Operacion operacion) {
        this.Operacion = Operacion;
    }


    public String getValorTexto() {
        String op1 = operador1.getValorTexto();
        String op2 = operador2.getValorTexto();

        String texto = "";

        if (Operacion == null) {
            texto += "";
        } else if (!finalizado) {
            texto += op1 + operacao;
        } else {
            texto += op1 + operacao + op2;
        }

        return texto;
    }

    public String getValorTextoPrincipal() {
        String op1 = operador1.getValorTexto();
        String op2 = operador2.getValorTexto();

        String texto = "";

        if (operacao == null) {
            texto += op1;
        } else if (!finalizado) {
            texto += op2;
        } else {
            texto += getResultado();
        }

        return texto;
    }

    public String getResultado() {
        double op1 = operador1.getValor();
        double op2 = operador2.getValor();
        double resultado = 0;
        if (operacao == Operacion.SUMA) {
            resultado = op1 + op2;
        } else if (operacao == Operacion.RESTA) {
            resultado = op1 - op2;
        } else if (operacao == Operacion.MULTIPLICACION) {
            resultado = op1 * op2;
        } else if (operacao == Operacion.DIVISION) {
            resultado = op1 / op2;
        } else if (operacao == Operacion.PORC) {
            resultado = op1 * op2 / 100;
        } else {
            throw new UnsupportedOperationException("Operação não implementada.");
        }
        return nf.format(resultado);
    }

    public void calcular() {
        this.finalizado = true;
    }

    public void removerUltimoCaracter() throws ParseException {
        if (operacao == null) {
            operador1.removerUltimoCaracter();
        } else if (!finalizado) {
            operador2.removerUltimoCaracter();
        }
    }

    @Override
    public String toString() {
        String texto = getValorTexto();
        if (getValorTextoPrincipal().trim().length() > 0) {
            texto += " = " + getValorTextoPrincipal();
        }
        return texto;
    }
}

