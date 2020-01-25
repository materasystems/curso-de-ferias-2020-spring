package com.matera.cursoferias.digitalbank.enumerator;

public enum TipoLancamento {

    DEPOSITO("D"),
    SAQUE("S"),
    TRANSFERENCIA("T"),
    PAGAMENTO("P"),
    ESTORNO("E");

    private String codigo;

    private TipoLancamento(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
