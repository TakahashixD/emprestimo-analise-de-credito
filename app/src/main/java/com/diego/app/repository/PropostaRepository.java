package com.diego.app.repository;

import com.diego.app.entity.Proposta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropostaRepository extends CrudRepository<Proposta, Long> {

    List<Proposta> findAllByIntegradaIsFalse();
}
