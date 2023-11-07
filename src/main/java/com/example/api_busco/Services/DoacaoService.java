package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Doacao;
import com.example.api_busco.Repositorys.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoacaoService {
    private final DoacaoRepository doacaoRepository;

    @Autowired
    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    public ApiResponse fazerDoacao(Doacao doacao) {
        try {
            Doacao fornecedorCadastrado = doacaoRepository.save(doacao);
            List<Object> doacaoList = new ArrayList<>();
            doacaoList.add(fornecedorCadastrado);
            return new ApiResponse(true, "Doação feita com sucesso", doacaoList, null);
        } catch (Exception exception) {
            return new ApiResponse(false, "Falha ao fazer doação fornecedor", null, null);
        }
    }
}