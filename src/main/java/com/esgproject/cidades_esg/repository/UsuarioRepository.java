package com.esgproject.cidades_esg.repository;

import com.esgproject.cidades_esg.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}