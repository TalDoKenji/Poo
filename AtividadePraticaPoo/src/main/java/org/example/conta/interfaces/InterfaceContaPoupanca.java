package org.example.conta.interfaces;


import org.example.exception.SaldoInsuficienteException;
import org.example.exception.ValorInseridoInvalidoException;
import org.jetbrains.annotations.NotNull;

public interface InterfaceContaPoupanca {


    Double saque(Double valorSaque) throws SaldoInsuficienteException, ValorInseridoInvalidoException;

    void deposito(Double valorDeposito) throws ValorInseridoInvalidoException;

    void pagamento(Double valorPagamento) throws ValorInseridoInvalidoException, SaldoInsuficienteException;

    Double transferencia(Double valorTransferido, @NotNull InterfaceContaPoupanca contaDestino) throws ValorInseridoInvalidoException, SaldoInsuficienteException;

    Double getSaldo();
}
