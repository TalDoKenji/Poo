package org.example.exception;

public class CpfComDigitosInvalidosException extends Exception {

        public CpfComDigitosInvalidosException(){
                super("1º dígito Identificador inválido");
        }
}
