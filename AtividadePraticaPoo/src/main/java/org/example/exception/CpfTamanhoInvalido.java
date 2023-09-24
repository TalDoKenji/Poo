package org.example.exception;

public class CpfTamanhoInvalido extends Exception {

    public CpfTamanhoInvalido(){
        super("Tamanho do CPF é inválido");
    }
}
