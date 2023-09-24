package org.example.pessoa;

import org.example.Enum.EstadoCivil;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private EstadoCivil estadoCivil;

    public PessoaFisica (String nome, LocalDate dataNasc, String cpf, EstadoCivil estadoCivil){
        super(nome, dataNasc);
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }
}
