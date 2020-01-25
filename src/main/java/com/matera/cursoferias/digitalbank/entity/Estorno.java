package com.matera.cursoferias.digitalbank.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_estorno")
public class Estorno extends EntidadeBase {

	@OneToOne
	@JoinColumn(name = "id_lancamento_original", nullable = false)
	private Lancamento lancamentoOriginal;

	@OneToOne
	@JoinColumn(name = "id_lancamento_estorno", nullable = false)
	private Lancamento lancamentoEstorno;

}
