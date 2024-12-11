package com.diego.app.controller;

import com.diego.app.dto.PropostaRequestDto;
import com.diego.app.dto.PropostaResponseDto;
import com.diego.app.entity.Proposta;
import com.diego.app.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@RequestBody PropostaRequestDto requestDto) {
        PropostaResponseDto response = propostaService.criarProposta(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri()).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterProposta() {
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
