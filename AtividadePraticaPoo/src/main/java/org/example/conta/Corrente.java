package org.example.conta;

import org.example.Enum.EstadoCivil;
import org.example.conta.interfaces.InterfaceContaPoupanca;
import org.example.conta.interfaces.InterfaceContaCorrente;
import org.example.conta.service.ValidaValores;
import org.example.exception.DivisaoPorZeroException;
import org.example.exception.EstadoCivilInvalidoException;
import org.example.exception.SaldoInsuficienteException;
import org.example.exception.ValorInseridoInvalidoException;
import org.example.pessoa.Pessoa;
import org.jetbrains.annotations.NotNull;

import static org.example.conta.service.ValidaValores.validaSaldo;

public class Corrente implements InterfaceContaCorrente {

    private Double saldo;
    private Integer numConta;
    private Pessoa titular;
    private Pessoa titular2;

    public Corrente(Double saldo, Integer numConta, Pessoa titular) {
        this.saldo = saldo;
        this.numConta = numConta;
        this.titular = titular;
    }

    public Corrente(Double saldo, Integer numConta, Pessoa titular, EstadoCivil estadoCivil, Pessoa titular2) throws EstadoCivilInvalidoException {
        ValidaValores.validaEstadoCivil(estadoCivil);
        this.saldo = saldo;
        this.numConta = numConta;
        this.titular = titular;
        this.titular2 = titular2;
    }

    @Override
    public Double saque(Double valorSaque) throws SaldoInsuficienteException, ValorInseridoInvalidoException {
        ValidaValores.validaValor(valorSaque);
        validaSaldo(saldo, valorSaque);
        saldo -= valorSaque;
        return valorSaque;
    }

    @Override
    public void deposito(Double valorDeposito) throws ValorInseridoInvalidoException {
        ValidaValores.validaValor(valorDeposito);
        saldo += valorDeposito;
    }

    @Override
    public void pagamentoDebito(Double valorPagamento) throws ValorInseridoInvalidoException, SaldoInsuficienteException {
        ValidaValores.validaValor(valorPagamento);
        ValidaValores.validaSaldo(saldo, valorPagamento);
        saldo -= valorPagamento;
    }

    @Override
    public Double pagamentoCredito(Double limite, Double valorPagamento, Integer numParcelas) throws DivisaoPorZeroException, ValorInseridoInvalidoException, SaldoInsuficienteException {
        ValidaValores.validaValor(valorPagamento);
        ValidaValores.validaSaldo(limite, valorPagamento);
        ValidaValores.validaDivisaoPorZero(numParcelas);
        saldo -= valorPagamento;
        return valorPagamento;
    }

    @Override
    public void transferencia(Double valorTransferido, @NotNull InterfaceContaPoupanca contaDestino) throws ValorInseridoInvalidoException, SaldoInsuficienteException {
        ValidaValores.validaValor(valorTransferido);
        ValidaValores.validaSaldo(saldo, valorTransferido);
        contaDestino.deposito(valorTransferido);
        saldo -= valorTransferido;
    }

    @Override
    public Double getSaldo() {
        return saldo;
    }
}
