/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author bryan
 */
public class Token {
     
    Tipo tipo;
    String contenido;
    int fila;
    int columna;

    public Token(Tipo tipo, String contenido, int fila, int columna) {
        this.tipo = tipo;
        this.contenido = contenido;
        this.fila = fila;
        this.columna = columna;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
    enum Tipo { 
        COMENTARIO,
        IDENTIFICADOR, 
        NUMERO, 
        PUNTOCOMA, 
        CONJUNCION,
        DISYUNCION,
        INTERROGACION,
        KLEEN,
        POSITIVA,
        LLAVEA, 
        LLAVEC, 
        FLECHA,
        CADENA,
        DOSPUNTOS,
        CONJUNTOLEX,
        PORCENTAJE,
        SABER,//~
        CARACTER
        
    }
}
