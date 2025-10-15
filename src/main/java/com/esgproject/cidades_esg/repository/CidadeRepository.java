package com.esgproject.cidades_esg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.esgproject.cidades_esg.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}