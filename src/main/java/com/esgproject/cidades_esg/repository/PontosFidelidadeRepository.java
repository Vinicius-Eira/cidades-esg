package com.esgproject.cidades_esg.repository;

import com.esgproject.cidades_esg.model.PontosFidelidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PontosFidelidadeRepository extends JpaRepository<PontosFidelidade, Long> {
    Optional<PontosFidelidade> findByUsuario(String usuario);
}