package com.esgproject.cidades_esg.controller;

import com.esgproject.cidades_esg.model.PontosFidelidade;
import com.esgproject.cidades_esg.repository.PontosFidelidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pontos")
public class PontosFidelidadeController {

    @Autowired
    private PontosFidelidadeRepository repository;

    // ➕ Adicionar pontos ao usuário
    @PostMapping("/ganhar")
    public PontosFidelidade ganharPontos(@RequestParam String usuario, @RequestParam int pontos) {
        Optional<PontosFidelidade> existente = repository.findByUsuario(usuario);

        if (existente.isPresent()) {
            PontosFidelidade pf = existente.get();
            pf.setPontos(pf.getPontos() + pontos);
            return repository.save(pf);
        } else {
            PontosFidelidade novo = new PontosFidelidade(usuario, pontos);
            return repository.save(novo);
        }
    }

    // 💰 Resgatar pontos
    @PostMapping("/resgatar")
    public String resgatarPontos(@RequestParam String usuario, @RequestParam int pontos) {
        Optional<PontosFidelidade> existente = repository.findByUsuario(usuario);

        if (existente.isEmpty()) {
            return "Usuário não encontrado!";
        }

        PontosFidelidade pf = existente.get();
        if (pf.getPontos() < pontos) {
            return "Pontos insuficientes para resgate.";
        }

        pf.setPontos(pf.getPontos() - pontos);
        repository.save(pf);

        return "Resgate de " + pontos + " pontos realizado com sucesso! Saldo atual: " + pf.getPontos();
    }

    // 👀 Consultar saldo de pontos
    @GetMapping("/saldo")
    public String consultarSaldo(@RequestParam String usuario) {
        Optional<PontosFidelidade> existente = repository.findByUsuario(usuario);

        if (existente.isEmpty()) {
            return "Usuário ainda não possui pontos.";
        }

        return "Usuário: " + usuario + " | Pontos: " + existente.get().getPontos();
    }
}