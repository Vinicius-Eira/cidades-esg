package com.esgproject.cidades_esg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esgproject.cidades_esg.model.Laudo;
import com.esgproject.cidades_esg.repository.LaudoRepository;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/laudos")
public class LaudoController {

    @Autowired
    private LaudoRepository laudoRepository;

    // 📥 Gerar laudo e orçamento automaticamente
    @PostMapping
    public Laudo gerarLaudo(@RequestBody Laudo laudo) {
        // Simulação de uma "IA" que analisa o problema e gera o laudo
        String descricao = laudo.getDescricaoProblema().toLowerCase();

        String laudoGerado;
        double valor;

        if (descricao.contains("freio")) {
            laudoGerado = "Possível desgaste nas pastilhas de freio. Recomendado verificar o sistema de frenagem.";
            valor = 350.0;
        } else if (descricao.contains("motor")) {
            laudoGerado = "Falha detectada no sistema de ignição ou combustível. Sugere-se diagnóstico completo do motor.";
            valor = 1200.0;
        } else if (descricao.contains("óleo")) {
            laudoGerado = "Nível de óleo abaixo do recomendado. É necessária troca imediata e verificação de vazamentos.";
            valor = 250.0;
        } else if (descricao.contains("barulho")) {
            laudoGerado = "Ruído identificado, possivelmente vindo da suspensão ou escapamento.";
            valor = 450.0;
        } else {
            laudoGerado = "Análise inconclusiva. Recomendado diagnóstico em oficina credenciada.";
            valor = new Random().nextDouble() * 1000 + 200;
        }

        laudo.setLaudoGerado(laudoGerado);
        laudo.setValorEstimado(valor);

        return laudoRepository.save(laudo);
    }

    // 📋 Listar todos os laudos
    @GetMapping
    public List<Laudo> listarTodos() {
        return laudoRepository.findAll();
    }

    // 🔍 Buscar por ID
    @GetMapping("/{id}")
    public Laudo buscarPorId(@PathVariable Long id) {
        return laudoRepository.findById(id).orElse(null);
    }

    // ❌ Excluir laudo
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        laudoRepository.deleteById(id);
    }
}