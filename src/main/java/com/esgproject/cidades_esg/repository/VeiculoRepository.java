package com.esgproject.cidades_esg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.esgproject.cidades_esg.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}