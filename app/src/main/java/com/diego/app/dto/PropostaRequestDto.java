package com.diego.app.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaRequestDto {

    private String nome;

    private String sobrenome;

    private String telefone;

    private String cpf;

    private Double renda;

    private Double valorSolicitado;

    private int prazoPagamento;
}
