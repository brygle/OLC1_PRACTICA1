/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.LinkedList;

/**
 *
 * @author bryan
 */
public class AnalizadorLexico {

    LinkedList<Token> listaToken;

    public AnalizadorLexico() {
        this.listaToken = new LinkedList<Token>();
    }

    LinkedList<Token> analizar(String entrada) {

        int fila = 1;
        int columna = 1;
        int estado = 0;
        String cadena = "";
        for (int i = 0; i < entrada.length(); i++) {
            switch (estado) {
                case 0:
                    char car = entrada.charAt(i);
                    if (Character.isLetter(car)) {//si es letra
                        estado = 1;
                        cadena += car;
                    } else if (car == '\n') {
                        columna = 0;
                        fila++;
                    } else if (car == '{') {
                        listaToken.add(new Token(Token.Tipo.LLAVEA, "{", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '}') {
                        listaToken.add(new Token(Token.Tipo.LLAVEC, "}", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '.') {
                        listaToken.add(new Token(Token.Tipo.CONJUNCION, ".", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '|') {
                        listaToken.add(new Token(Token.Tipo.DISYUNCION, "|", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '?') {
                        listaToken.add(new Token(Token.Tipo.INTERROGACION, "?", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '+') {
                        listaToken.add(new Token(Token.Tipo.POSITIVA, "+", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == ';') {
                        listaToken.add(new Token(Token.Tipo.PUNTOCOMA, ";", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '*') {
                        listaToken.add(new Token(Token.Tipo.KLEEN, "*", fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    } else if (car == '-') {
                        cadena += "-";
                        estado = 3;
                    }
                    

                    break;
                case 1://si es identificador
                    car = entrada.charAt(i);
                    if (Character.isLetter(car)) {//si es letra
                        estado = 1;
                        cadena += car;
                    } else if (Character.isDigit(car)) {
                        estado = 1;
                        cadena += car;
                    } else if (car == '\n') {
                        if (cadena.equalsIgnoreCase("conj")) {
                            listaToken.add(new Token(Token.Tipo.CONJUNTOLEX, cadena, fila, columna - cadena.length()));
                        } else {
                            listaToken.add(new Token(Token.Tipo.IDENTIFICADOR, cadena, fila, columna - cadena.length()));
                        }

                        cadena = "";
                        columna = 0;
                        fila++;
                        estado = 0;
                    } else if (car == ' ' || car == '\t') {
                        if (cadena.equalsIgnoreCase("conj")) {
                            listaToken.add(new Token(Token.Tipo.CONJUNTOLEX, cadena, fila, columna - cadena.length()));
                        } else {
                            listaToken.add(new Token(Token.Tipo.IDENTIFICADOR, cadena, fila, columna - cadena.length()));
                        }
                        cadena = "";
                        estado = 0;
                    } else {
                        //System.out.println("reconocio el identificador " + cadena);
                        if (cadena.equalsIgnoreCase("conj")) {
                            listaToken.add(new Token(Token.Tipo.CONJUNTOLEX, cadena, fila, columna - cadena.length()));
                        } else {
                            listaToken.add(new Token(Token.Tipo.IDENTIFICADOR, cadena, fila, columna - cadena.length()));
                        }
                        cadena = "";
                        estado = 0;
                        i--;
                        columna--;

                    }
                    break;
                case 2://reconocer numeros
                    break;
                case 3://reconocer flecha
                    car = entrada.charAt(i);
                    if (car == '>') {//si es flecha
                        listaToken.add(new Token(Token.Tipo.FLECHA, cadena, fila, columna - cadena.length()));
                        cadena = "";
                        estado = 0;
                    }
                    break;
            }

            columna++;

        }

        return listaToken;
    }

}
