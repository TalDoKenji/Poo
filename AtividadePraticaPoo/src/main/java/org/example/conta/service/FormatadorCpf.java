package org.example.conta.service;

import org.example.exception.*;
import org.jetbrains.annotations.NotNull;

public class FormatadorCpf {
    private Integer limit;
    private Boolean valid = false;


    public String ValidaTamanhoCpf(String cpf) throws CpfTamanhoInvalido, CpfCaractereInvalido,
            CpfComRepeticao, CpfComDigitosInvalidosException, CpfCaractereInvalido
    {
        String cpfFormatado = cpf.replaceAll("\\.|\\-", "");
        limit = cpfFormatado.length();
        if(limit != 11){
            throw new CpfTamanhoInvalido();
        }
        return "";
    }

    public String ValidaCaractereInvalido(String cpf) throws CpfCaractereInvalido {
        String cpfFormatado = cpf.replaceAll("\\.|\\-", "");
        if (cpfFormatado.contains("abc")) {
            throw new CpfCaractereInvalido();
        }
        return "";
    }
    public String ValidaCpfComReticao(@NotNull String cpf) throws CpfComRepeticao {
        String cpfFormatado = cpf.replaceAll("\\.|\\-", "");
        limit = cpfFormatado.length();
        for( int i = 0 ; i < limit ; i++){
            valid = cpfFormatado.charAt(i) != cpfFormatado.charAt(0);
        }
        if(valid) {
            throw new CpfComRepeticao();
        }
        return "";
    }

    public String ValidaCalculoCpf(String cpf) throws CpfComDigitosInvalidosException {
        String cpfFormatado = cpf.replaceAll("\\.|\\-", "");
        int multiplicador = 10;
        int num;
        int total = 0;
        for( int i = 0 ; i < 9 ; i++){
            num = Integer.parseInt(cpfFormatado.substring(i, i + 1));
            total += num * multiplicador;
            multiplicador -- ;
        }
        int resto = 11 - (total % 11);
        if(resto > 10)
            resto = 0;
        int dig1 = Integer.parseInt(cpfFormatado.substring(9,10));
        if( resto != dig1)
            throw new CpfComDigitosInvalidosException();

        return "Cpf válido";

    }
}


