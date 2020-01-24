package com.matera.cursoferias.digitalbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "db_transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
	@JoinColumn(name = "id_lancamento_debito", nullable = false)
	private Lancamento lancamentoDebito;

    @OneToOne
	@JoinColumn(name = "id_lancamento_credito", nullable = false)
    private Lancamento lancamentoCredito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lancamento getLancamentoDebito() {
        return lancamentoDebito;
    }

    public void setLancamentoDebito(Lancamento lancamentoDebito) {
        this.lancamentoDebito = lancamentoDebito;
    }

    public Lancamento getLancamentoCredito() {
        return lancamentoCredito;
    }

    public void setLancamentoCredito(Lancamento lancamentoCredito) {
        this.lancamentoCredito = lancamentoCredito;
    }

}
