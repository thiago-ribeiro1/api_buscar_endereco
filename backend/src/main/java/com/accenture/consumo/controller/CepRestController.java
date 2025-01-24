package com.accenture.consumo.controller;

import com.accenture.consumo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<?> buscarEndereco(@PathVariable String cep) {
        try {
            // Remove espaços, quebras de linha e hífens
            String cepNormalizado = cep.replaceAll("[^0-9]", "").trim();

            // Verifica se o CEP tem exatamente 8 números
            if (!cepNormalizado.matches("\\d{8}")) {
                return ResponseEntity.badRequest().body("CEP inválido. Insira um CEP com exatamente 8 números.");
            }

            // Consulta a API ViaCEP
            Endereco endereco = cepService.buscaEnderecoPorCep(cepNormalizado);
            if (endereco == null || endereco.getCep() == null) {
                return ResponseEntity.status(404).body("Endereço não encontrado para o CEP informado.");
            }

            // Salva o endereço no banco H2
            enderecoRepository.save(endereco);

            return ResponseEntity.ok(endereco);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar o serviço de CEP: " + e.getMessage());
        }
    }
}
