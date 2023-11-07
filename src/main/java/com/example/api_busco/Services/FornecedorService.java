package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Fornecedor;
import com.example.api_busco.Repositorys.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    public ApiResponse cadastrarFornecedor(Fornecedor fornecedor){
        try {
            Fornecedor fornecedorCadastrado = fornecedorRepository.save(fornecedor);
            List<Object> fornecedorList = new ArrayList<>();
            fornecedorList.add(fornecedorCadastrado);
            return new ApiResponse(true, "Fornecedor cadastrado com sucesso", fornecedorList, null);
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao cadastrar fornecedor", null, null);
        }
    }
}
