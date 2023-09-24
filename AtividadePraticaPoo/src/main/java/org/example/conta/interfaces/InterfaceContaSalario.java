package org.example.conta.interfaces;

import org.example.exception.SaldoInsuficienteException;
import org.example.exception.ValorInseridoInvalidoException;
import org.jetbrains.annotations.NotNull;

public interface InterfaceContaSalario {
    Double saque(Double valorSaque) throws SaldoInsuficienteException, ValorInseridoInvalidoException;

    void pagamentoDebito(Double valorPagamento) throws ValorInseridoInvalidoException, SaldoInsuficienteException;

    void transferencia(Double valorTransferido, @NotNull InterfaceContaPoupanca contaDestino) throws ValorInseridoInvalidoException, SaldoInsuficienteException;

    Double getSaldo();
}
