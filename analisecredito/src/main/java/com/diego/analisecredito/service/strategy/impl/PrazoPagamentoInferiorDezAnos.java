package com.diego.analisecredito.service.strategy.impl;

import com.diego.analisecredito.domain.Proposta;
import com.diego.analisecredito.service.strategy.CalculoPonto;

public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }

}
