package com.diego.analisecredito.service.strategy.impl;

import com.diego.analisecredito.domain.Proposta;
import com.diego.analisecredito.service.strategy.CalculoPonto;

public class RendaMaiorValorSolicitado implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorValorSolicitado(Proposta proposta){
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }
}
