package com.example.api_busco.Repositorys;

import com.example.api_busco.Models.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {
    @Query("SELECT d FROM Doacao d WHERE d.usuario_doador = :id")
    Doacao findDoacaoByUsuario_doador(int id);
}
