package com.diego.analisecredito.service.strategy.impl;

import com.diego.analisecredito.domain.Proposta;
import com.diego.analisecredito.service.strategy.CalculoPonto;

import java.util.Random;

public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta){
        if(nomeNegativo()){
            throw new RuntimeException("Nome negativado");
        }
        return 100;
    }

    private boolean nomeNegativo(){
        return new Random().nextBoolean();
    }
}
