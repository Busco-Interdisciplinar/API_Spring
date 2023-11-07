package com.example.api_busco.Repositorys;

import com.example.api_busco.Models.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RotaRepository extends JpaRepository<Rota, Integer> {
    List<Rota> findRotaByRota(int rota);
}
