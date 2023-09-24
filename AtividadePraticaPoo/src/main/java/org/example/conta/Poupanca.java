package org.example.conta;

import org.example.conta.interfaces.InterfaceContaPoupanca;
import org.example.conta.service.ValidaValores;
import org.example.exception.SaldoInsuficienteException;
import org.example.exception.ValorInseridoInvalidoException;
import org.example.pessoa.Pessoa;
import org.jetbrains.annotations.NotNull;

import static org.example.conta.service.ValidaValores.validaSaldo;

public class Poupanca implements InterfaceContaPoupanca {
    private Double saldo;
    private Integer numConta;
    private Pessoa titular;

    public Poupanca(Double saldo, Integer numConta, Pessoa pesssoa) throws SaldoInsuficienteException {
        this.saldo = saldo;
        this.numConta = numConta;
        this.titular = titular;
        ValidaValores.validaSaldo(saldo,50.0);
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
    public void pagamento(Double valorPagamento) throws ValorInseridoInvalidoException, SaldoInsuficienteException {
        ValidaValores.validaValor(valorPagamento);
        ValidaValores.validaSaldo(saldo, valorPagamento);
        saldo -= valorPagamento;
    }

    @Override
    public Double transferencia(Double valorTransferido, @NotNull InterfaceContaPoupanca contaDestino) throws ValorInseridoInvalidoException, SaldoInsuficienteException {
        ValidaValores.validaValor(valorTransferido);
        ValidaValores.validaSaldo(saldo, valorTransferido);
        contaDestino.deposito(valorTransferido);
        saldo -= valorTransferido;
        return valorTransferido;
    }

    @Override
    public Double getSaldo() {
        return saldo;
    }

}
