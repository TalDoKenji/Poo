package org.example.conta.service;

import org.example.Enum.EstadoCivil;
import org.example.exception.DivisaoPorZeroException;
import org.example.exception.EstadoCivilInvalidoException;
import org.example.exception.SaldoInsuficienteException;
import org.example.exception.ValorInseridoInvalidoException;

import static org.example.Enum.EstadoCivil.SOLTEIRO;

public class ValidaValores {

    public static void validaSaldo(Double saldo, Double valorRequisitado) throws SaldoInsuficienteException {
        if(saldo < valorRequisitado)
            throw new SaldoInsuficienteException ("Saldo Insuficiente");
    }
    public static void validaValor(Double valor) throws ValorInseridoInvalidoException {
        if(valor < 0)
            throw new ValorInseridoInvalidoException("Valor inserido é inválido");
    }

    public static void validaDivisaoPorZero(Integer numParcelas) throws DivisaoPorZeroException {
        if(numParcelas <= 0)
            throw new DivisaoPorZeroException("Não foi possível realizar o procedimento");
    }

    public static void validaEstadoCivil(EstadoCivil estadoCivil) throws EstadoCivilInvalidoException {
        if(estadoCivil.equals(SOLTEIRO))
            throw new EstadoCivilInvalidoException("Você não pode abrir uma conta conjunta");
    }
}
