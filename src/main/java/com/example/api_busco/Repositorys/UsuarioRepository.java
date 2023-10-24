package com.example.api_busco.Repositorys;

import com.example.api_busco.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByEmail(String email);

    @Query("SELECT u FROM Usuarios u WHERE u.cpf = :cpf OR u.email = :email OR u.telefone = :telefone")
    List<Usuarios> findByCpfOrEmailOrTelefone(@Param("cpf") String cpf, @Param("email") String email, @Param("telefone") String telefone);
}
