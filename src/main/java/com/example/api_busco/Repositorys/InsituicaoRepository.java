package com.example.api_busco.Repositorys;

import com.example.api_busco.Models.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InsituicaoRepository extends JpaRepository<Instituicao, Integer> {
    @Query("SELECT i FROM Instituicao i WHERE i.usuario_padrao = :id")
    Instituicao findInstituicaoByUsuario_padrao(int id);
}
