package com.esgproject.cidades_esg.service;

import org.springframework.stereotype.Service;
import com.esgproject.cidades_esg.model.Cidade;
import com.esgproject.cidades_esg.repository.CidadeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> listarTodas() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void deletar(Long id) {
        cidadeRepository.deleteById(id);
    }
}