package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Fornecedor;
import com.example.api_busco.Models.Instituicao;
import com.example.api_busco.Repositorys.InsituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstituicaoService {
    private final InsituicaoRepository insituicaoRepository;

    @Autowired
    public InstituicaoService(InsituicaoRepository insituicaoRepository){
        this.insituicaoRepository = insituicaoRepository;
    }

    public ApiResponse cadastrarInstituicao(Instituicao instituicao){
        try {
            Instituicao instituicaoCadastrada = insituicaoRepository.save(instituicao);
            List<Object> instituicaoList = new ArrayList<>();
            instituicaoList.add(instituicaoCadastrada);
            return new ApiResponse(true, "Instituição cadastrado com sucesso", instituicaoList, null);
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao cadastrar Instituição", null, null);
        }
    }

    public ApiResponse findByUserId(int id) {
        try {
            Instituicao instituicao = insituicaoRepository.findInstituicaoByUsuario_padrao(id);
            if (instituicao != null){
                List<Object> instituicaoList = new ArrayList<>();
                instituicaoList.add(instituicao);
                return new ApiResponse(true, "Instituição encontrada com sucesso", instituicaoList, null);
            }else{
                return new ApiResponse(false, "Instituição não encontrada no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao buscar Instituição", null, null);
        }
    }
}