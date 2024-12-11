package com.diego.analisecredito.listener;

import com.diego.analisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta) {
        System.out.println("Recebido Proposta Pendente: " + proposta);
    }
}
