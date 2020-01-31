package com.matera.cursoferias.digitalbank.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExtratoResponseDTO {

	private ContaResponseDTO conta;
	private List<ComprovanteResponseDTO> lancamentos;

}
