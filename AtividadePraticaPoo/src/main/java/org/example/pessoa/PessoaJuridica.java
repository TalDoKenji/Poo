package org.example.pessoa;

import java.time.LocalDate;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, LocalDate dataNasc, String cnpj){
        super(nome, dataNasc);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}



