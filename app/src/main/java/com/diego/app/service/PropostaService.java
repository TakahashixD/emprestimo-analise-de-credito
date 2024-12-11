package com.diego.app.service;

import com.diego.app.dto.PropostaRequestDto;
import com.diego.app.dto.PropostaResponseDto;
import com.diego.app.entity.Proposta;
import com.diego.app.mapper.PropostaMapper;
import com.diego.app.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private PropostaMapper propostaMapper;

    private PropostaRepository propostaRepository;

    private NotificacaoRabbitService notificacaoRabbitService;

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    public PropostaService(
            PropostaMapper propostaMapper,
            PropostaRepository propostaRepository,
            NotificacaoRabbitService notificacaoRabbitService,
            @Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.propostaRepository = propostaRepository;
        this.notificacaoRabbitService = notificacaoRabbitService;
        this.exchange = exchange;
        this.propostaMapper = propostaMapper;
    }

    public PropostaResponseDto criarProposta(PropostaRequestDto requestDto) {
        Proposta proposta = propostaMapper.convertRequestDtoToEntity(requestDto);
        propostaRepository.save(proposta);
        notificarRabbitMQ(proposta);
        return propostaMapper.convertEntityToResponseDto(proposta);
    }

    public List<PropostaResponseDto> obterProposta() {
        return propostaMapper.convertListEntityToListResponseDto(propostaRepository.findAll());
    }

    public void notificarRabbitMQ(Proposta proposta){
        try {
            notificacaoRabbitService.notificar(proposta, exchange);
        } catch (RuntimeException ex) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }
}
