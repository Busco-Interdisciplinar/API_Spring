package com.example.api_busco.Repositorys;

import com.example.api_busco.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    public Usuarios findByEmail(String email);
}
