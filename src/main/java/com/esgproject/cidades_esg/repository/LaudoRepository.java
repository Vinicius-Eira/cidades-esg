package com.esgproject.cidades_esg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.esgproject.cidades_esg.model.Laudo;

public interface LaudoRepository extends JpaRepository<Laudo, Long> {
}