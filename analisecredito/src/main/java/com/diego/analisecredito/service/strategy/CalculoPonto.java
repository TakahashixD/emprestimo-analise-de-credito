package com.diego.analisecredito.service.strategy;

import com.diego.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
