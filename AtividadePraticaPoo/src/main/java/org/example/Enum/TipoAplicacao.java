package org.example.Enum;

public enum TipoAplicacao {
    ACOES() {
        @Override
        public Double renda(Integer QtdeAcoes) {
            double valorAcoes = 2.3;
            return QtdeAcoes * valorAcoes;
        }
    },
    IMOVEIS() {
        @Override
        public Double renda(Integer QtdeAcoes) {
            double juros = 0.02;
            return QtdeAcoes * juros;
        }
    },
    CRIPTOMOEDA() {
        @Override
        public Double renda(Integer QtdeAcoes ) {
            double valor = 1.2;
            return QtdeAcoes * valor;
        }
    },
    CDB() {
        @Override
        public Double renda(Integer QtdeAcoes) {
            double valor = 10.0;
            return QtdeAcoes * (valor * 1.002);
        }
    };

    public abstract Double renda(Integer QtdeAcoes);
}
