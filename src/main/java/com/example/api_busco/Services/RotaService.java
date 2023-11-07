package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Rota;
import com.example.api_busco.Repositorys.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {
    private final RotaRepository rotaRepository;

    @Autowired
    public RotaService(RotaRepository rotaRepository){
        this.rotaRepository = rotaRepository;
    }

    public ApiResponse buscarRota(int rota){
        try{
            List<Rota> rotasResponse = rotaRepository.findRotaByRota(rota);
            if (rotasResponse != null){
                List<Object> listaObjetos = rotasResponse.stream()
                        .map(rotas -> (Object) rotas)
                        .toList();
                return new ApiResponse(true, "Rota encontrada com sucesso", listaObjetos, null);
            }else{
                return new ApiResponse(false, "Rota não encontrada no banco", null, null);
            }
        }catch (Exception e){
            return new ApiResponse(false, "Falha ao buscar a rota", null, null);
        }
    }
}
