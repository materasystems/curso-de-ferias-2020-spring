package com.matera.cursoferias.digitalbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "db_estorno")
public class Estorno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@OneToOne
	@JoinColumn(name = "id_lancamento_original", nullable = false)
	private Lancamento lancamentoOriginal;

	@OneToOne
	@JoinColumn(name = "id_lancamento_estorno", nullable = false)
	private Lancamento lancamentoEstorno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lancamento getLancamentoOriginal() {
        return lancamentoOriginal;
    }

    public void setLancamentoOriginal(Lancamento lancamentoOriginal) {
        this.lancamentoOriginal = lancamentoOriginal;
    }

    public Lancamento getLancamentoEstorno() {
        return lancamentoEstorno;
    }

    public void setLancamentoEstorno(Lancamento lancamentoEstorno) {
        this.lancamentoEstorno = lancamentoEstorno;
    }

}
