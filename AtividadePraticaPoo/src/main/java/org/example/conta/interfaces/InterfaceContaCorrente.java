package org.example.conta.interfaces;

import org.example.exception.DivisaoPorZeroException;
import org.example.exception.SaldoInsuficienteException;
import org.example.exception.ValorInseridoInvalidoException;
import org.jetbrains.annotations.NotNull;

public interface InterfaceContaCorrente {

    Double saque(Double valorSaque) throws SaldoInsuficienteException, ValorInseridoInvalidoException;

    void deposito(Double valorDeposito) throws ValorInseridoInvalidoException;

    void pagamentoDebito(Double valorPagamento) throws ValorInseridoInvalidoException, SaldoInsuficienteException;

    Double pagamentoCredito(Double limite, Double valorPagamento, Integer numParcelas) throws DivisaoPorZeroException, ValorInseridoInvalidoException, SaldoInsuficienteException;

    void transferencia(Double valorTransferido, @NotNull InterfaceContaPoupanca contaDestino) throws ValorInseridoInvalidoException, SaldoInsuficienteException;

    Double getSaldo();
}
