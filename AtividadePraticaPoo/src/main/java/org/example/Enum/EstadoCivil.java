package org.example.Enum;

public enum EstadoCivil {
    SOLTEIRO(1),
    CASADO(2),
    VIUVO(3),
    DIVORCIADO(4);

    private Integer id;

    EstadoCivil(Integer id){
        this.id = id;
    }
}
