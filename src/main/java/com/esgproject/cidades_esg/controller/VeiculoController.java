package com.esgproject.cidades_esg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esgproject.cidades_esg.model.Veiculo;
import com.esgproject.cidades_esg.repository.VeiculoRepository;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Cadastrar veículo
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Listar todos
    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    // Atualizar veículo
    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo novo) {
        return veiculoRepository.findById(id)
                .map(v -> {
                    v.setMarca(novo.getMarca());
                    v.setModelo(novo.getModelo());
                    v.setPlaca(novo.getPlaca());
                    v.setAno(novo.getAno());
                    return veiculoRepository.save(v);
                })
                .orElse(null);
    }

    // Deletar veículo
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }
}