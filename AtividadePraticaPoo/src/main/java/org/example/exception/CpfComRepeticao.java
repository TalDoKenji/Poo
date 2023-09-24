package org.example.exception;

public class CpfComRepeticao extends Exception {

    public CpfComRepeticao(){
            super("Cpf com caracteres repetidos");
    }
}