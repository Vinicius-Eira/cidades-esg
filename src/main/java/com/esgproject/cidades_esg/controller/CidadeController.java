package com.esgproject.cidades_esg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esgproject.cidades_esg.model.Cidade;
import com.esgproject.cidades_esg.service.CidadeService;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public List<Cidade> listarTodas() {
        return cidadeService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
        return cidadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cidade criar(@RequestBody Cidade cidade) {
        return cidadeService.salvar(cidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade) {
        return cidadeService.buscarPorId(id)
                .map(cidadeExistente -> {
                    cidadeExistente.setNome(cidade.getNome());
                    cidadeExistente.setPopulacao(cidade.getPopulacao());
                    cidadeExistente.setEstado(cidade.getEstado());
                    Cidade atualizada = cidadeService.salvar(cidadeExistente);
                    return ResponseEntity.ok(atualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (cidadeService.buscarPorId(id).isPresent()) {
            cidadeService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}