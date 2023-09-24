import org.example.Enum.EstadoCivil;
import org.example.conta.Corrente;
import org.example.conta.Poupanca;
import org.example.exception.*;
import org.example.conta.service.FormatadorCpf;
import org.example.pessoa.Pessoa;
import org.example.pessoa.PessoaFisica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FormatadorCpfTest {
    @Test
    public void DeveValidarTamanhoCpf() throws CpfTamanhoInvalido, CpfComDigitosInvalidosException, CpfCaractereInvalido, CpfComRepeticao {
        PessoaFisica kenji = new PessoaFisica("kenji", LocalDate.of(2004, 4, 23),"123.123.123-88" , EstadoCivil.SOLTEIRO);
        FormatadorCpf service = new FormatadorCpf();
        String result = service.ValidaTamanhoCpf(kenji.getCpf());

        Assertions.assertEquals("12312312388", result);
    }

    @Test
    public void DeveValidarRepeticao() throws CpfTamanhoInvalido, CpfComDigitosInvalidosException, CpfCaractereInvalido, CpfCaractereInvalido, CpfComRepeticao {
        PessoaFisica kenji = new PessoaFisica("kenji", LocalDate.of(2004, 4, 23), "000.000.000-00", EstadoCivil.SOLTEIRO);
        FormatadorCpf service = new FormatadorCpf();

        Exception result;
        result = Assertions.assertThrows(Exception.class, () -> service.ValidaCpfComReticao("000.000.000-00"));

        Assertions.assertEquals("Cpf com caracteres repetidos", result.getMessage());
    }
@Test
    public void DeveValidar10Digito() throws CpfComDigitosInvalidosException {

    FormatadorCpf service = new FormatadorCpf();

    String result = service.ValidaCalculoCpf("132.006.259-88");

    Assertions.assertEquals("Cpf válido", result);
    }

    @Test
    public void DeveValidarTransferencia() throws SaldoInsuficienteException, ValorInseridoInvalidoException{
        Pessoa kenji = new Pessoa("kenji", LocalDate.of(2004,4,23));
        Poupanca conta1 = new Poupanca(500.0, 1, kenji);

        Pessoa cassia = new Pessoa("Cassia", LocalDate.of(2001,1,2));
        Poupanca conta2 = new Poupanca(1000.0, 2, cassia);

        Double result = conta1.transferencia(300.0, conta2);

        System.out.println("valor conta1: "+ conta1.getSaldo());
        System.out.println("valor conta2: "+ conta2.getSaldo());
    }

    @Test
    public void DeveValidarPagamentoCredito() throws SaldoInsuficienteException, ValorInseridoInvalidoException, DivisaoPorZeroException, EstadoCivilInvalidoException {
        Pessoa kenji = new Pessoa("Kenji", LocalDate.of(2004, 4,23));
        Pessoa popo = new Pessoa("popo", LocalDate.of(2004, 4,23));

        Corrente contaCorrente = new Corrente(1500.0, 1, kenji, EstadoCivil.CASADO, popo);
        Double result = contaCorrente.pagamentoCredito(3000.0, 600.0, 3);
        Assertions.assertEquals(200.0, result);

    }


}
