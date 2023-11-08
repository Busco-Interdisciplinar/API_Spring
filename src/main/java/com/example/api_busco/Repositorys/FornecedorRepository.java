package com.example.api_busco.Repositorys;

import com.example.api_busco.Models.Doacao;
import com.example.api_busco.Models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    @Query("SELECT f FROM Fornecedor f WHERE f.usuario_padrao = :id")
    Fornecedor findFornecedorByUsuario_padrao(int id);
}
