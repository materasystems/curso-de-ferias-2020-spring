package com.matera.cursoferias.digitalbank.enumerator;

public enum SituacaoConta {

    ABERTA("A"),
    BLOQUEADA("B");

    private String codigo;

    private SituacaoConta(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
