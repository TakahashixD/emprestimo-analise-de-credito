package com.diego.analisecredito.service.strategy.impl;

import com.diego.analisecredito.domain.Proposta;
import com.diego.analisecredito.service.strategy.CalculoPonto;

import java.util.Random;

public class PontuacaoScoreImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();
        if(score <= 200){
            throw new RuntimeException("Score muito baixa");
        } else if(score <= 400){
            return 150;
        } else if(score <= 600){
            return 180;
        } else {
            return 220;
        }
    }

    private int score(){
        return new Random().nextInt(0, 1000);
    }
}
