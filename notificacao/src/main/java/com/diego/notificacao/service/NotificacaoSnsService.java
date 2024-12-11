package com.diego.notificacao.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {

    private final Logger logger = LoggerFactory.getLogger(NotificacaoSnsService.class);

    public void notificar(String mensagem){
        logger.info(mensagem);
    }
}
